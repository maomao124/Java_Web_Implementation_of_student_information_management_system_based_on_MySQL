<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>学生信息管理系统</title>
    <link rel="stylesheet" href="index.css">
    <link rel="stylesheet" href="animate.css">
    <style>
        body {
            /* 初始化 取消内外边距 */
            margin: 0;
            padding: 0;
            /* 100%窗口高度 */
            height: 100vh;
            /* 弹性布局 水平垂直居中 */
            display: flex;
            justify-content: center;
            align-items: center;
            /* 渐变背景 */
            background: linear-gradient(125deg, #2c3e50, #27ae60, #2980b9,skyblue);
            /* 指定背景图像的大小 */
            background-size: 500%;
            /* 执行动画：动画名 时长 线性的 无限次播放 */
            animation: bgAnimation 15s linear infinite;
        }


        /* 定义动画 */
        @keyframes bgAnimation {
            0% {
                background-position: 0% 50%;
            }
            50% {
                background-position: 100% 50%;
            }
            100% {
                background-position: 0% 50%;
            }
        }
    </style>
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