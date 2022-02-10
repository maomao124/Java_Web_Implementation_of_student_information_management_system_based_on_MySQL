<%@ page import="data.Course" %>
<%@ page import="table.Score" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): insert_score_result
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/9
  Time(创建时间)： 21:15
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生成绩-结果</title>
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
    String usual_score_str = request.getParameter("usual_score");
    String end_score_str = request.getParameter("end_score");
    String semester = request.getParameter("semester");

    //验证
    if (no_str == null || no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "此页面不能单独访问！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }
    if (course_no_str == null || course_no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "课程编号不能为空！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }
    if (usual_score_str == null || usual_score_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "平时成绩不能为空！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }
    if (end_score_str == null || end_score_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "期末成绩不能为空！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }
    if (semester == null || semester.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "学期不能为空 示例：2021年下学期！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
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
    }
    Float usual_score = null;
    try
    {
        assert usual_score_str != null;
        usual_score = Float.parseFloat(usual_score_str);
    }
    catch (Exception e)
    {
        //把错误信息写入session里
        session.setAttribute("message", "平时成绩不为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }
    Float end_score = null;
    try
    {
        assert end_score_str != null;
        end_score = Float.parseFloat(end_score_str);
    }
    catch (Exception e)
    {
        //把错误信息写入session里
        session.setAttribute("message", "期末成绩不为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }
    //判断课程号对应的课程是否存在
    Course courseInformation = table.Course.getCourseInformation(course_no);
    if (courseInformation == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "该课程不存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }
    //判断学生的成绩是否已经存在
    boolean verification = Score.verification(no, course_no);
    if (verification)
    {
        //把错误信息写入session里
        session.setAttribute("message", "此学生已经存在此课程！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }
    //课程不存在
    boolean result = Score.insert(no, course_no, usual_score, end_score, semester);
    //判断结果
    if (!result)
    {
        //把错误信息写入session里
        session.setAttribute("message", "成绩插入失败！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }
%>
<%
    //重定向
    response.sendRedirect("student_score.jsp?no=" + no);
%>
</body>
</html>
