<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): custom_query
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/11
  Time(创建时间)： 23:12
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>自定义查询</title>
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
<a class="position" href="table_photo.jsp">查看表结构</a>
<div class="text_p">
    <div class="text animated flipInY">
        自定义查询
    </div>
</div>
<div class="form">
    <div class="animated rotateIn">
        <br/>
        <form action="custom_query_result.jsp" method="post">
            <label>
                <textarea rows="10" name="sql">SELECT * FROM</textarea>
            </label>
            <br/>
            <input style=" position: absolute;left: 50%;transform: translate(-50%, 0%);" type="submit" value="提交SQL语句"/>
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
