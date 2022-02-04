<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): Authentication
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/1/31
  Time(创建时间)： 23:16
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>身份验证</title>
</head>
<body>
<%
    //获取request请求的信息
    //学号或者职工号（编号）
    String no = request.getParameter("no");
    //密码
    String password = request.getParameter("password");
    //验证码
    String code = request.getParameter("CheckCode");
    //从session里取正确的验证码
    String session_code = (String) session.getAttribute("code");
%>
输出验证：
<br>
<%=no%>
<br/>
<%=password%>
<br/>
<%=code%>
<br/>
<%=session_code%>
</body>
</html>
