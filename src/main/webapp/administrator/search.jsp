<%@ page import="data.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): search
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/9
  Time(创建时间)： 14:41
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索学生信息</title>
    <link rel="stylesheet" href="css/table_student.css">
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
    //获取所有学生信息
    Object[][] studentArray = table.Student.getStudentArray();
%>
<a class="back" href="index.jsp">返回</a>
<table class="animated headShake">
    <caption>
        提示：请使用浏览器的搜索功能(ctrl+f)
        <br/>
    </caption>
    <br/>
    <tr>
        <!-- th为表格标题栏-->
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>电话号码</th>
        <th>家庭电话号码</th>
        <th>生日</th>
        <th>家庭地址</th>
        <th>身份证号码</th>
        <th>电子邮箱</th>
        <th>班级</th>
        <th>状态</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    <%
        for (int i = 1; i < studentArray.length; i++)
        {
    %>
    <tr>
        <td>
            <%=studentArray[i][0]%>
        </td>
        <td>
            <%=studentArray[i][1]%>
        </td>
        <td>
            <%=studentArray[i][2]%>
        </td>
        <td>
            <%=studentArray[i][3]%>
        </td>
        <td>
            <%=studentArray[i][4]%>
        </td>
        <td>
            <%=studentArray[i][5]%>
        </td>
        <td>
            <%=studentArray[i][6]%>
        </td>
        <td>
            <%=studentArray[i][7]%>
        </td>
        <td>
            <%=studentArray[i][8]%>
        </td>
        <td>
            <%=studentArray[i][9]%>
        </td>
        <td>
            <%=studentArray[i][10]%>
        </td>
        <td>
            <%=studentArray[i][11]%>
        </td>
        <td>
            <a href="#">查看</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
