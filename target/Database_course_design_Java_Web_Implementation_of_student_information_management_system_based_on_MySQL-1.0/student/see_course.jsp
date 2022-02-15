<%@ page import="data.Course" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): see_course
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/15
  Time(创建时间)： 20:44
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看所有课程</title>
    <link rel="stylesheet" href="css/table.css">
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
    <style>
        body {
            background-color: skyblue;
        }

        p:hover
        {
            background: aquamarine;
        }
    </style>
</head>
<body>
<%
    //获取所有课程列表
    List<Course> courseList = table.Course.getCourseList();
%>
<a class="back" href="index.jsp">返回</a>
<br>
<table class="animated fadeInUp">
    <caption>
        课程列表
    </caption>
    <br/>
    <tr>
        <!-- th为表格标题栏-->
        <th>课程编号</th>
        <th>课程名称</th>
        <th>课程学分</th>
        <th>课程学时</th>
        <th>考核模式</th>
    </tr>
    <%
        for (data.Course course : courseList)
        {
    %>
    <tr>
        <td>
            <%=course.getCourse_no()%>
        </td>
        <td>
            <%=course.getCourse_name()%>
        </td>
        <td>
            <%=course.getCourse_credit()%>
        </td>
        <td>
            <%=course.getCourse_hour()%>
        </td>
        <td>
            <%=course.getCourse_mode()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
