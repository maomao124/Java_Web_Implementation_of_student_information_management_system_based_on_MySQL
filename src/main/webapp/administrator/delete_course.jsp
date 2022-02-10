<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): delete_course
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/10
  Time(创建时间)： 20:51
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除课程信息</title>
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
    <link rel="stylesheet" href="css/insert_score.css">
    <link rel="stylesheet" href="css/hotAirBalloon.css">
</head>
<body>
<%
    //从request里获取参数
    String course_no_str = request.getParameter("course_no");
    //判断是否为空
    if (course_no_str == null || course_no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "课程号为空！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //转换成数字
    Long course_no = null;
    try
    {
        course_no = Long.parseLong(course_no_str);
    }
    catch (Exception e)
    {
        //把错误信息写入session里
        session.setAttribute("message", "此页面传入的参数必须为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //判断课程号是否存在
    data.Course courseInformation = table.Course.getCourseInformation(course_no);
    if (courseInformation == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "此课程不存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
%>

<a class="back" href="index.jsp">返回</a>
<div class="text_p">
    <div class="text animated flipInY">
        删除课程信息
        <br/>
        删除之前要确保删除与此课程关联的信息，否则将删除失败！
    </div>
</div>
<div class="form">
    <br/>
    <form action="delete_course_result.jsp" method="post">
        <table border="1" class="animated bounceInDown">
            <tr>
                <td colspan="2" align="center">
                </td>
            </tr>
            <tr>
                <td class="s">课程编号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="course_no" readonly="readonly"
                               value="<%=courseInformation.getCourse_no()%>">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">课程名称</td>
                <td>
                    <label>
                        <input class="c" type="text" name="course_name" readonly="readonly"
                               value="<%=courseInformation.getCourse_name()%>">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">课程学分</td>
                <td>
                    <label>
                        <input class="c" type="number" min="0.0" max="100.0" step="0.1" readonly="readonly"
                               name="course_credit"
                               value="<%=courseInformation.getCourse_credit()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">课程学时</td>
                <td>
                    <label>
                        <input class="c" type="number" min="0.0" max="100.0" step="1" readonly="readonly"
                               name="course_hour"
                               value="<%=courseInformation.getCourse_hour()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">考核模式</td>
                <td>
                    <label>
                        <input class="c" type="text" name="course_mode" readonly="readonly"
                               value="<%=courseInformation.getCourse_mode()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input style="color: red;" type="submit" value="删除"/>
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
