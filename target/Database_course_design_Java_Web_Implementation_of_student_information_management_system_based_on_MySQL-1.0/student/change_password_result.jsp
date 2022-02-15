<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.regex.Matcher" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): change_password_result
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/15
  Time(创建时间)： 20:47
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更改登录密码-结果</title>
    <style>
        body {
            background-color: skyblue;
        }
    </style>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    //获取信息
    String no_str = request.getParameter("no");
    String old_password = request.getParameter("old_password");
    String password1 = request.getParameter("password1");
    String password2 = request.getParameter("password2");


    //判断是否为空
    if (no_str == null || no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "此页面不能单独访问！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (old_password == null || old_password.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入原密码！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (password1 == null || password1.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入新密码！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (password2 == null || password2.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入新密码！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //判断新密码是否一致
    if (!password1.equals(password2))
    {
        //把错误信息写入session里
        session.setAttribute("message", "输入的两次密码不一致！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //判断长度
    if (password1.length() < 6)
    {
        //把错误信息写入session里
        session.setAttribute("message", "密码长度太短！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (password1.length() > 20)
    {
        //把错误信息写入session里
        session.setAttribute("message", "密码长度太长！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //密码由大小写和数字构成
    Pattern pattern = Pattern.compile("^[\\w]*$");
    Matcher matcher = pattern.matcher(password1);
    boolean result = matcher.matches();
    if (!result)
    {
        //把错误信息写入session里
        session.setAttribute("message", "密码应该由大小写字母和数字构成！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //转换成数字
    Long no = null;
    try
    {
        no = Long.parseLong(no_str);
    }
    catch (Exception e)
    {
        //把错误信息写入session里
        session.setAttribute("message", "学号不为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //验证旧密码
    boolean verification = table.StudentPassword.verification(no, old_password);
    if (!verification)
    {
        //把错误信息写入session里
        session.setAttribute("message", "原密码不正确！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //更改密码
    boolean b = table.StudentPassword.changePassword(no, old_password, password1);
    if (!b)
    {
        //把错误信息写入session里
        session.setAttribute("message", "密码更改失败！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
%>

<%
    //密码更改成功
    //重定向至主页
    response.sendRedirect("index.jsp");
%>
</body>
</html>
