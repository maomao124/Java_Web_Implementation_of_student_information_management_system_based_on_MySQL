<%@ page import="data.Course" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): insert_course_result
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/10
  Time(创建时间)： 19:37
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加课程-结果</title>
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
    String course_no_str = request.getParameter("course_no");
    String course_name = request.getParameter("course_name");
    String course_credit_str = request.getParameter("course_credit");
    String course_hour_str = request.getParameter("course_hour");
    String course_mode = request.getParameter("course_mode");

    //判断是否为空
    if (course_no_str == null || course_no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入课程编号！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (course_name == null || course_name.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入课程名称！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (course_credit_str == null || course_credit_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入课程学分！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (course_hour_str == null || course_hour_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入课程学时！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (course_mode == null || course_mode.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入考核方式！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //转换成数字
    Long course_no = null;
    try
    {
        course_no = Long.parseLong(course_no_str);
    }
    catch (Exception e)
    {
        //把错误信息写入session里
        session.setAttribute("message", "课程编号不为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    Float course_credit = null;
    try
    {
        course_credit = Float.parseFloat(course_credit_str);
    }
    catch (Exception e)
    {
        //把错误信息写入session里
        session.setAttribute("message", "课程学分不为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    Integer course_hour = null;
    try
    {
        course_hour = Integer.parseInt(course_hour_str);
    }
    catch (Exception e)
    {
        //把错误信息写入session里
        session.setAttribute("message", "课程学时不为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //判断课程编号是否存在
    Course courseInformation = table.Course.getCourseInformation(course_no);
    if (courseInformation != null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "该课程已经存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //判断考核方式
    if (!(course_mode.equals("考试") || course_mode.equals("考查")))
    {
        //把错误信息写入session里
        session.setAttribute("message", "考核方式只能填入考试或者考查！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //插入课程
    boolean result = table.Course.insert(course_no, course_name, course_credit, course_hour, course_mode);
    if (!result)
    {
        //把错误信息写入session里
        session.setAttribute("message", "课程插入失败！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
%>

<%
    //重定向
    response.sendRedirect("see_course.jsp");
%>
<%=course_no_str%>
</body>
</html>
