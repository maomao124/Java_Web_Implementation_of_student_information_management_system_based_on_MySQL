<%@ page import="data.Teach" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): delete_teach
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/14
  Time(创建时间)： 20:26
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除教师工作信息</title>
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
    <link rel="stylesheet" href="css/insert_score.css">
    <link rel="stylesheet" href="css/hotAirBalloon.css">
</head>
<body>
<%
    //从request里获取参数
    String teach_no_str = request.getParameter("teach_no");
    //判断是否为空
    if (teach_no_str == null || teach_no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "此页面不能单独访问！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //转换成数字
    Long teach_no = null;
    try
    {
        teach_no = Long.parseLong(teach_no_str);
    }
    catch (Exception e)
    {
        //把错误信息写入session里
        session.setAttribute("message", "此页面传入的参数必须为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //判断编号是否存在
    Teach teach = table.Teach.getTeach(teach_no);
    if (teach == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "此信息不存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

%>



<a class="back" href="index.jsp">返回</a>
<div class="text_p">
    <div class="text animated flipInY">
       删除教师工作信息
    </div>
</div>
<div class="form">
    <br/>
    <form action="delete_teach_result.jsp" method="post">
        <table border="1" class="animated bounceInDown">
            <tr>
                <td colspan="2" align="center">
                </td>
            </tr>
            <tr>
                <td class="s">编号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="student_no" readonly="readonly" value="<%=teach_no%>">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">教师编号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="course_no" readonly="readonly" value="<%=teach.getTeacher_no()%>">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">老师所教班级编号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="course_no" readonly="readonly" value="<%=teach.getClass_no()%>">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">老师所教课程编号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="course_no" readonly="readonly" value="<%=teach.getCourse_no()%>">
                    </label>
                </td>
            </tr>

            <tr>
                <td class="s">学期</td>
                <td>
                    <label>
                        <input class="c" type="text" name="semester" value="<%=teach.getSemester()%>"
                               disabled="disabled"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input style="color: red" type="submit" value="删除"/>
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
