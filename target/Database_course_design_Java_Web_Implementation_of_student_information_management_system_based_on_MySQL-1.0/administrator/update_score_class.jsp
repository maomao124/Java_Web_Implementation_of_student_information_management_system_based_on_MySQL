<%@ page import="data.Class" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): update_score_class
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/10
  Time(创建时间)： 14:08
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新学生成绩-请选择班级</title>
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
    //获得班级信息
    List<Class> classList = table.Class.getClassList();
%>
<a class="back" href="index.jsp">返回</a>
<br>
<table class="animated fadeInUp">
    <caption>
        请选择班级
    </caption>
    <br/>
    <tr>
        <!-- th为表格标题栏-->
        <th>班级编号</th>
        <th>班级名称</th>
        <th>所属学院</th>
        <th>所属专业</th>
        <th>入学年份</th>
        <th>操作</th>
    </tr>
    <%
        for (data.Class c : classList)
        {
    %>
    <tr>
        <td>
            <%=c.getClass_no()%>
        </td>
        <td>
            <%=c.getClass_name()%>
        </td>
        <td>
            <%=c.getClass_college()%>
        </td>
        <td>
            <%=c.getClass_major()%>
        </td>
        <td>
            <%=c.getClass_enrollment_year()%>
        </td>
        <td>
            <a href="update_score_student.jsp?class_no=<%=c.getClass_no()%>">进入</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
