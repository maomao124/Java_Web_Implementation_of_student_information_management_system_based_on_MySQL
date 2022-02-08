<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): Error
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/1/31
  Time(创建时间)： 23:17
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误</title>
    <link rel="stylesheet" href="Error.css">
    <link rel="stylesheet" href="animate.css">
</head>
<body>
<%--<%--%>
<%--    //获得错误信息--%>
<%--    String message = (String) session.getAttribute("message");--%>
<%--%>--%>
<%--<%=message%>--%>
<div class="position">
    <div class="animated slideInUp">
        <div class="text">
            <c:out value="错误！！！" escapeXml="true" default="null"/>
            <br/>
            <c:out value="错误内容：${sessionScope.message}" escapeXml="true" default="null"/>
        </div>
    </div>
</div>
</body>
</html>
