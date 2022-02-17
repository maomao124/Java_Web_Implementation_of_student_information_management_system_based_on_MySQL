<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): quit
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/16
  Time(创建时间)： 22:16
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>安全退出</title>
</head>
<body>
<%
    //清除session域的关键信息
    //信息
    session.removeAttribute("teacher");
    //身份
    session.removeAttribute("identity");
    //重定向至索引页面
    response.sendRedirect("../thanks.jsp");
%>
</body>
</html>
