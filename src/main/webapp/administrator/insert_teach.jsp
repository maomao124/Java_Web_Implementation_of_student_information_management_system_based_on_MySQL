<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): insert_teach
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/14
  Time(创建时间)： 21:37
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加教师工作信息</title>
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
    <link rel="stylesheet" href="css/insert_teach.css">
    <link rel="stylesheet" href="css/hotAirBalloon.css">
</head>
<body>
<%
    //从request里获取参数
    String teacher_no_str = request.getParameter("teacher_no");
    //判断是否为空
    if (teacher_no_str == null || teacher_no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "此页面不能单独访问！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //转换成数字
    Long teacher_no = null;
    try
    {

        teacher_no = Long.parseLong(teacher_no_str);
    }
    catch (Exception e)
    {
        //把错误信息写入session里
        session.setAttribute("message", "此页面传入的参数必须为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //获取教师信息
    data.Teacher teacher = table.Teacher.getTeacher(teacher_no);
    if (teacher == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "该教师信息不存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
%>
<a class="back" href="index.jsp">返回</a>
<div class="text_p">
    <div class="text animated flipInY">
        添加教师工作信息
    </div>
</div>
<div class="form">
    <br/>
    <form action="insert_teach_result.jsp" method="post">
        <table border="1" class="animated bounceInDown">
            <tr>
                <td colspan="2" align="center">
                </td>
            </tr>
            <tr>
                <td class="ss">教师编号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="teacher_no" readonly="readonly" value="<%=teacher_no%>">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="ss">教师姓名</td>
                <td>
                    <label>
                        <input class="c" type="text" name="teacher_name" readonly="readonly" value="<%=teacher.getTeacher_name()%>">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="ss">教师所教班级编号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="class_no"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="ss">教师所教课程编号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="course_no"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="ss">学期</td>
                <td>
                    <label>
                        <input class="c" type="email" name="semester"/>
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
