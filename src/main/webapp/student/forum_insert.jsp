<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): forum_insert
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/15
  Time(创建时间)： 21:02
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布一条论坛消息</title>
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
    <link rel="stylesheet" href="css/insert_score.css">
    <link rel="stylesheet" href="css/hotAirBalloon.css">
    <link rel="stylesheet" href="css/textarea.css">
    <style>
        a.position {
            position: absolute;
            top: 0;
            right: 0;
            /*transform: translate(0%, 0%);*/
        }
    </style>
</head>
<body>
<a class="back" href="index.jsp">返回</a>
<div class="text_p">
    <div class="text animated flipInY">
        发布一条论坛消息
    </div>
</div>
<div class="form">
    <div class="animated rotateIn">
        <br/>
        <form action="forum_insert_result.jsp" method="post">
            <label>
                <textarea rows="10" name="text" placeholder="从这里输入文字"></textarea>
            </label>
            <br/>
            <input style=" position: absolute;left: 50%;transform: translate(-50%, 0%);" type="submit" value="发布"/>
        </form>
    </div>
</div>

<div class="left animated slideInUp">
    <figure class="balloon">
        <div class="envelope">
            <span></span>
            <span></span>
        </div>
        <div class="basket">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </div>
    </figure>
</div>
<div class="right animated slideInUp">
    <figure class="balloon">
        <div class="envelope">
            <span></span>
            <span></span>
        </div>
        <div class="basket">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </div>
    </figure>
</div>
</body>
</html>
