<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): delete_teacher_result
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/14
  Time(创建时间)： 21:29
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除教师信息-结果</title>
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

    //判断是否为空
    if (teacher_no_str == null || teacher_no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入教师编号！");
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
    data.Teacher teacher = table.Teacher.getTeacher(teacher_no);
    if (teacher == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "该教师不存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //删除教师信息
    boolean result = table.Teacher.delete(teacher_no);
    if (!result)
    {
        //把错误信息写入session里
        session.setAttribute("message", "教师信息删除失败！");
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
