<%@ page import="data.Administrators" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): change_password
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/10
  Time(创建时间)： 21:21
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更改登录密码</title>
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
    <link rel="stylesheet" href="css/password.css">
    <link rel="stylesheet" href="css/hotAirBalloon.css">
</head>
<body>
<%
    //获取本身的信息
    data.Administrators administrator = (Administrators) session.getAttribute("administrator");
    //判断是否为空
    if (administrator == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "无法获取到信息，请先登录！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
%>

<a class="back" href="index.jsp">返回</a>
<div class="text_p">
    <div class="text animated flipInY">
        修改登录密码
    </div>
</div>
<div class="form">
    <br/>
    <form action="update_course_result.jsp" method="post">
        <table border="1" class="animated bounceInDown">
            <tr>
                <td colspan="2" align="center">
                </td>
            </tr>
            <tr>
                <td class="ss">您的职工号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="course_no" readonly="readonly"
                               value="<%=administrator.getAdministrator_no()%>">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="ss">请输入原密码</td>
                <td>
                    <label>
                        <input class="c" type="password" name="old_password">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="ss">请输入新密码</td>
                <td>
                    <label>
                        <input class="c" type="password" name="password1">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="ss">请再次输入</td>
                <td>
                    <label>
                        <input class="c" type="password" name="password2">
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="更改"/>
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
