<%@ page import="java.util.Objects" %>
<%@ page import="com.mysql.cj.xdevapi.Table" %>
<%@ page import="table.StudentPassword" %>
<%@ page import="table.TeacherPassword" %>
<%@ page import="table.AdministratorsPassword" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): Authentication
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/1/31
  Time(创建时间)： 23:16
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>身份验证</title>
</head>
<body>
<%
    //获取request请求的信息
    //获得身份信息
    String identity = request.getParameter("identity");
    //学号或者职工号（编号）
    String no = request.getParameter("no");
    //密码
    String password = request.getParameter("password");
    //验证码
    String code = request.getParameter("CheckCode");
    //从session里取正确的验证码
    String session_code = (String) session.getAttribute("code");
    //输入的验证码不为空
    if (code == null || code.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入验证码！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }
    //输入的身份不能为空
    if (identity == null || identity.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请选择身份！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }
    //学号或者职工号不能为空
    if (no == null || no.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入学号或者职工号！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }
    //密码不能为空
    if (password == null || password.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入密码！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }
    //判断验证码是否正确
    assert code != null;
    if (!Objects.equals(code.toLowerCase(), session_code.toLowerCase()))//不分大小写
    {
        //把错误信息写入session里
        session.setAttribute("message", "验证码不正确！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }

    Long number_no = null;
    //学号或者职工号只能是数字
    try
    {
        assert no != null;
        number_no = Long.parseLong(no);
    }
    catch (Exception e)
    {
        //把错误信息写入session里
        session.setAttribute("message", "学号只能为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }

    //学号不能为负数
    if (number_no < 0)
    {
        //把错误信息写入session里
        session.setAttribute("message", "学号不能为负数！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }

    //密码不能超过20位
    assert password != null;
    if (password.length() > 20)
    {
        //把错误信息写入session里
        session.setAttribute("message", "密码长度太长！密码长度不能超过20位！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }

    //开始验证信息
    //验证学生
    if (Objects.equals(identity, "1"))
    {
        boolean result = StudentPassword.verification(number_no, password);
        //用户名或者密码错误
        if (!result)
        {
            //把错误信息写入session里
            session.setAttribute("message", "学号不存在或者密码错误！");
            //转发至错误页面
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
        //验证成功
        //获得全部信息
        data.Student student = table.Student.getStudent(number_no);
        //写入session
        session.setAttribute("student", student);
        //重定向到主页
        response.sendRedirect("student/index.jsp");
    }
    else if (Objects.equals(identity, "2"))
    {
        //验证老师
        boolean result = TeacherPassword.verification(number_no, password);
        //用户名或者密码错误
        if (!result)
        {
            //把错误信息写入session里
            session.setAttribute("message", "职工号不存在或者密码错误！");
            //转发至错误页面
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
        //验证成功
        //获得全部信息
        data.Teacher teacher = table.Teacher.getTeacher(number_no);
        //写入session
        session.setAttribute("student", teacher);
        //重定向到主页
        response.sendRedirect("teacher/index.jsp");
    }
    else
    {
        //验证管理员
        boolean result = AdministratorsPassword.verification(number_no, password);
        //用户名或者密码错误
        if (!result)
        {
            //把错误信息写入session里
            session.setAttribute("message", "职工号不存在或者密码错误！");
            //转发至错误页面
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
        //验证成功
        //获得全部信息
        data.Administrators administrator = table.Administrators.getAdministrator(number_no);
        //写入session
        session.setAttribute("student", administrator);
        //重定向到主页
        response.sendRedirect("administrator/index.jsp");
    }
%>
<%--输出验证：--%>
<%--<br>--%>
<%--身份：--%>
<%--<%=identity%>--%>
<%--<br/>--%>
<%--学号：--%>
<%--<%=no%>--%>
<%--<br/>--%>
<%--密码：--%>
<%--<%=password%>--%>
<%--<br/>--%>
<%--输入的验证码：--%>
<%--<%=code%>--%>
<%--<br/>--%>
<%--正确的验证码：--%>
<%--<%=session_code%>--%>
</body>
</html>
