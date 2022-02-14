<%@ page import="data.Teacher" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): teacher_index
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/14
  Time(创建时间)： 19:58
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理教师</title>
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
    //获得教师信息
    List<Teacher> teacherList = table.Teacher.getTeacherList();
%>
<a class="back" href="index.jsp">返回</a>
<br>
<table class="animated fadeInUp">
    <caption>
        请选择教师
    </caption>
    <br/>
    <tr>
        <!-- th为表格标题栏-->
        <th>教师编号</th>
        <th>教师姓名</th>
        <th>教师性别</th>
        <th>教师电话号码</th>
        <th>教师电子邮箱</th>
        <th>教师家庭住址</th>
        <th>教师身份证号码</th>
        <th>查看</th>
        <th>更新操作</th>
        <th>删除操作</th>
        <th>添加操作</th>
    </tr>
    <%
        for (data.Teacher teacher : teacherList)
        {
    %>
    <tr>
        <td>
            <%=teacher.getTeacher_no()%>
        </td>
        <td>
            <%=teacher.getTeacher_name()%>
        </td>
        <td>
            <%=teacher.getTeacher_sex()%>
        </td>
        <td>
            <%=teacher.getTeacher_telephone_number()%>
        </td>
        <td>
            <%=teacher.getTeacher_email()%>
        </td>
        <td>
            <%=teacher.getTeacher_address()%>
        </td>
        <td>
            <%=teacher.getTeacher_idcard()%>
        </td>
        <td>
            <a href="teach_index.jsp?teacher_no=<%=teacher.getTeacher_no()%>">查看详情</a>
        </td>
        <td>
            <a href="update_teacher.jsp?teacher_no=<%=teacher.getTeacher_no()%>">更新</a>
        </td>
        <td>
            <a href="delete_teacher.jsp?teacher_no=<%=teacher.getTeacher_no()%>">删除</a>
        </td>
        <td>
            <a href="insert_teach.jsp?teacher_no=<%=teacher.getTeacher_no()%>">添加工作信息</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
