<%@ page import="data.Class" %>
<%@ page import="data.Course" %>
<%@ page import="table.Teach" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): insert_teach_result
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/14
  Time(创建时间)： 21:49
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加教师工作信息-结果</title>
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
    String class_no_str = request.getParameter("class_no");
    String course_no_str = request.getParameter("course_no");
    String semester = request.getParameter("semester");

    //判断是否为空
    if (teacher_no_str == null || teacher_no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "不能单独访问此页面！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (class_no_str == null || class_no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入教师所教班级编号！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (course_no_str == null || course_no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入教师所教课程编号！");
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

    Long class_no = null;
    try
    {
        class_no = Long.parseLong(class_no_str);
    }
    catch (Exception e)
    {
        //把错误信息写入session里
        session.setAttribute("message", "班级编号不为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

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

    //判断班级是否存在
    Class classInformation = table.Class.getClassInformation(class_no);
    if (classInformation == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "该班级不存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //判断课程编号是否存在
    Course courseInformation = table.Course.getCourseInformation(course_no);
    if (courseInformation == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "该课程不存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //判断此条信息是否已经存在
    boolean verification = Teach.verification(teacher_no, class_no, course_no);
    if (verification)
    {
        //把错误信息写入session里
        session.setAttribute("message", "已经存在，不能重复添加！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //插入信息
    boolean result = table.Teach.insert(teacher_no, class_no, course_no, semester);
    if (!result)
    {
        //把错误信息写入session里
        session.setAttribute("message", "添加失败！");
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
