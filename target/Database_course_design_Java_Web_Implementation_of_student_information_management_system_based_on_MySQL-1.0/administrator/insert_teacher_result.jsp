<%@ page import="data.Teacher" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): insert_teacher_result
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/14
  Time(创建时间)： 19:46
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加教师信息-结果</title>
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
    String teacher_no_str = request.getParameter("teacher_no");
    String teacher_name = request.getParameter("teacher_name");
    String teacher_sex = request.getParameter("teacher_sex");
    String teacher_telephone_number = request.getParameter("teacher_telephone_number");
    String teacher_email = request.getParameter("teacher_email");
    String teacher_address = request.getParameter("teacher_address");
    String teacher_idcard = request.getParameter("teacher_idcard");

    //判断是否为空
    if (teacher_no_str == null || teacher_no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入教师编号！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (teacher_name == null || teacher_name.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入教师姓名！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (teacher_sex == null || teacher_sex.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入教师性别！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (teacher_telephone_number == null || teacher_telephone_number.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入教师电话号码！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (teacher_email == null || teacher_email.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入电子邮箱！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (teacher_address == null || teacher_address.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入教师家庭住址！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (teacher_idcard == null || teacher_idcard.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入教师身份证号码！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    if (!(teacher_sex.equals("男") || teacher_sex.equals("女")))
    {
        //把错误信息写入session里
        session.setAttribute("message", "性别只能为男或者女！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //转换成数字
    Long teacher_no = null;
    try
    {
        teacher_no = Long.parseLong(teacher_no_str);
    }
    catch (Exception e)
    {
        //把错误信息写入session里
        session.setAttribute("message", "教师编号不为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //判断教师编号是否存在
    Teacher teacher = table.Teacher.getTeacher(teacher_no);
    if (teacher != null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "该教师已经存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //插入教师信息
    boolean result = table.Teacher.insert(teacher_no, teacher_name, teacher_sex, teacher_telephone_number, teacher_email, teacher_address, teacher_idcard);
    if (!result)
    {
        //把错误信息写入session里
        session.setAttribute("message", "教师信息添加失败！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
%>

<%
    //重定向
    response.sendRedirect("teacher_index.jsp");
%>
</body>
</html>
