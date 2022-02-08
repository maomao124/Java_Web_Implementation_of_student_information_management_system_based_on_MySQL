<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="data.Administrators" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): index
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/1/31
  Time(创建时间)： 23:18
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员-菜单</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
</head>
<%
    //获得管理员信息
    data.Administrators administrator = (Administrators) session.getAttribute("administrator");
%>
<%
    if (administrator.getAdministrator_sex().equals("女"))
    {
%>
<body style="background: pink">
    <%
    }
    else
        {
    %>
<body style="background: skyblue">
<%
    }
%>
<div class="text_p">
    <div class="animated shake">
        <div class="text">
            欢迎登录！<%=administrator.getAdministrator_job()%><%=administrator.getAdministrator_name()%>
        </div>
    </div>
</div>
<div class="link">
    <a href="">查看学生信息</a>
</div>
</body>
</html>
