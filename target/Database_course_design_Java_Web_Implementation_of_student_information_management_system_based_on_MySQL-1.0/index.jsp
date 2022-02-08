<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>学生信息管理系统</title>
    <link rel="stylesheet" href="index.css">
    <link rel="stylesheet" href="animate.css">
</head>
<body>
<br/>
<div class="text">
    <div style="border: 10px dotted lightpink;" class="animated slideInDown">
        <c:out value="欢迎使用学生信息管理系统" escapeXml="true" default="null"/>
    </div>
</div>
<div class="link_position">
    <a style="border: 10px dotted lightpink;" class="link animated flip" href="Login.html">进入程序</a>
</div>
<div class="l animated bounceInRight">
    <div class="box">
        <div class="tip left"></div>
        <div class="tip right"></div>
        <div class="tip font"><br><br><a style="text-decoration: none;" href="https://github.com/maomao124/">github</a>
        </div>
        <div class="tip back"></div>
        <div class="tip top"></div>
        <div class="tip bottom"></div>
    </div>
</div>
<div class="r animated bounceInLeft">
    <div class="box">
        <div class="tip left"></div>
        <div class="tip right"></div>
        <div class="tip font"><br><br>作者：mao</div>
        <div class="tip back"></div>
        <div class="tip top"></div>
        <div class="tip bottom"></div>
    </div>
</div>

</body>
</html>