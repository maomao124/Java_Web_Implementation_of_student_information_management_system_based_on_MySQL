<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): delete_score_result
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/10
  Time(创建时间)： 15:21
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除学生成绩-结果</title>
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
    String no_str = request.getParameter("student_no");
    String course_no_str = request.getParameter("course_no");

    //验证
    if (no_str == null || no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "此页面不能单独访问！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (course_no_str == null || course_no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "课程编号不能为空！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //转换成数字
    Long no = null;
    try
    {
        assert no_str != null;
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
    Long course_no = null;
    try
    {
        assert course_no_str != null;
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
    Float usual_score = null;
    //判断课程号对应的课程是否存在
    data.Course courseInformation = table.Course.getCourseInformation(course_no);
    if (courseInformation == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "该课程不存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //判断学生的成绩是否已经存在
    boolean verification = table.Score.verification(no, course_no);
    if (!verification)
    {
        //把错误信息写入session里
        session.setAttribute("message", "此学生不存在此课程，不能再次删除！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //课程存在，更新
    boolean result = table.Score.delete(no, course_no);
    //判断结果
    if (!result)
    {
        //把错误信息写入session里
        session.setAttribute("message", "成绩删除失败！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
%>
<%
    //重定向
    response.sendRedirect("update_score_course.jsp?no=" + no);
%>
</body>
</html>
