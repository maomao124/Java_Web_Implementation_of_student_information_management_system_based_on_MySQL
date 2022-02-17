<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): insert_course
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/10
  Time(创建时间)： 19:31
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加课程</title>
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
    <link rel="stylesheet" href="css/insert_score.css">
    <link rel="stylesheet" href="css/hotAirBalloon.css">
</head>
<body>
<a class="back" href="index.jsp">返回</a>
<div class="text_p">
    <div class="text animated flipInY">
        添加课程信息
    </div>
</div>
<div class="form">
    <br/>
    <form action="insert_course_result.jsp" method="post">
        <table border="1" class="animated bounceInDown">
            <tr>
                <td colspan="2" align="center">
                </td>
            </tr>
            <tr>
                <td class="s">课程编号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="course_no">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">课程名称</td>
                <td>
                    <label>
                        <input class="c" type="text" name="course_name">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">课程学分</td>
                <td>
                    <label>
                        <input class="c" type="number" min="0.0" max="30.0" step="0.1" name="course_credit"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">课程学时</td>
                <td>
                    <label>
                        <input class="c" type="number" min="0.0" max="500.0" step="1" name="course_hour"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">考核方式</td>
                <td>
                    <label>
                        <input class="c" type="text" name="course_mode"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="提交"/>
                </td>
            </tr>
        </table>
    </form>
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
