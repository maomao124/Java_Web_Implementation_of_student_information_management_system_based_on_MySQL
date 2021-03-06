<%@ page import="table.Forum" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): forum_insert_result
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/16
  Time(创建时间)： 22:11
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布一条论坛消息-结果</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    //获取信息
    String text = request.getParameter("text");
    //判断是否为空
    if (text == null || text.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "输入的消息不能为空！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //判断是否太长
    if (text.length() > 255)
    {
        //把错误信息写入session里
        session.setAttribute("message", "输入的消息太长最大允许255个字符，您的字符为！" + text.length() + "个");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //获取信息
    data.Teacher teacher = (data.Teacher) session.getAttribute("teacher");
    //插入
    boolean result = Forum.insert(teacher.getTeacher_no(), teacher.getTeacher_name(), "老师", text);
    //判断返回值
    if (!result)
    {
        //把错误信息写入session里
        session.setAttribute("message", "论坛消息发布失败！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
%>

<%
    //重定向
    response.sendRedirect("forum.jsp?page=1");
%>
</body>
</html>
