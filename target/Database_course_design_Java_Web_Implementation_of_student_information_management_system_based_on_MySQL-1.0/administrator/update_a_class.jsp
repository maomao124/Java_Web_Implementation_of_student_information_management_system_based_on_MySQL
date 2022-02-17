<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): update_a_class
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/11
  Time(创建时间)： 22:10
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新班级信息</title>
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
    <link rel="stylesheet" href="css/insert_score.css">
    <link rel="stylesheet" href="css/hotAirBalloon.css">
</head>
<body>

<%
    String class_no_str = request.getParameter("class_no");
    //判断是否为空
    if (class_no_str == null || class_no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入班级编号！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //转换成数字
    Long class_no = null;
    try
    {
        class_no = Long.parseLong(class_no_str);
    }
    catch (Exception e)
    {
        //把错误信息写入session里
        session.setAttribute("message", "班级编号不为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //判断班级编号是否存在
    data.Class classInformation = table.Class.getClassInformation(class_no);
    if (classInformation == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "该班级不存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
%>

<a class="back" href="index.jsp">返回</a>
<div class="text_p">
    <div class="text animated flipInY">
        更新班级信息
    </div>
</div>
<div class="form">
    <br/>
    <form action="update_a_class_result.jsp" method="post">
        <table border="1" class="animated bounceInDown">
            <tr>
                <td colspan="2" align="center">
                </td>
            </tr>
            <tr>
                <td class="s">班级编号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="class_no" readonly="readonly" value="<%=class_no%>">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">班级名称</td>
                <td>
                    <label>
                        <input class="c" type="text" name="class_name" value="<%=classInformation.getClass_name()%>">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">所属学院</td>
                <td>
                    <label>
                        <input class="c" type="text" name="class_college"
                               value="<%=classInformation.getClass_college()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">所属专业</td>
                <td>
                    <label>
                        <input class="c" type="text" name="class_major" value="<%=classInformation.getClass_major()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">入学年份</td>
                <td>
                    <label>
                        <input class="c" type="number" min="2000" max="3000" step="1" name="class_enrollment_year"
                               value="<%=classInformation.getClass_enrollment_year()%>"/>
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
