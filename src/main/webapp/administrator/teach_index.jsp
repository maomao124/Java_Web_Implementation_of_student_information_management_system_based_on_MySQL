<%@ page import="data.Teach" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %>
<%@ page import="table.Class" %>
<%@ page import="table.Course" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): teach_index
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/14
  Time(创建时间)： 20:07
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师工作信息</title>
    <link rel="stylesheet" href="css/table.css">
    <link rel="stylesheet" href="../animate.css">
    <style>
        body {
            background-color: skyblue;
        }

        a.back {
            text-decoration: none;
            color: #0066ff;
            font-size: 22px;
        }
    </style>
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

    //获得教师信息
    List<Teach> teacher_teach = table.Teach.getTeacher_teach(teacher_no);

%>
<a class="back" href="index.jsp">返回</a>
<br>
<table class="animated fadeInUp">
    <br/>
    <tr>
        <!-- th为表格标题栏-->
        <th>编号</th>
        <th>教师所教班级编号</th>
        <th>教师所教课程编号</th>
        <th>教师所教班级名称</th>
        <th>教师所教课程名称</th>
        <th>学期</th>
        <th>操作</th>
    </tr>
    <%
        for (data.Teach teach : teacher_teach)
        {
    %>
    <tr>
        <td>
            <%=teach.getTeach_no()%>
        </td>
        <td>
            <%=teach.getClass_no()%>
        </td>
        <td>
            <%=teach.getCourse_no()%>
        </td>
        <td>
            <%=Objects.requireNonNull(Class.getClassInformation(teach.getClass_no())).getClass_name()%>
        </td>
        <td>
            <%=Objects.requireNonNull(Course.getCourseInformation(teach.getCourse_no())).getCourse_name()%>
        </td>
        <td>
            <%=teach.getSemester()%>
        </td>
        <td>
            <a href="delete_teach.jsp?teach_no=<%=teach.getTeach_no()%>">删除</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
