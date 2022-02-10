<%@ page import="data.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): update_score_student
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/10
  Time(创建时间)： 14:11
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新学生成绩-请选择学生</title>
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
    //从request里获取参数
    String class_no_str = request.getParameter("class_no");
    //判断是否为空
    if (class_no_str == null || class_no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "此页面不能单独访问！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //转换成数字
    Long class_no = null;
    try
    {
        assert class_no_str != null;
        class_no = Long.parseLong(class_no_str);
    }
    catch (Exception e)
    {
        //转换失败
        //把错误信息写入session里
        session.setAttribute("message", "此页面传入的参数必须为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //判断班级是否存在
    data.Class classInformation = table.Class.getClassInformation(class_no);
    if (classInformation == null)
    {
        //转换失败
        //把错误信息写入session里
        session.setAttribute("message", "此班级不存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //获取班级的所有学生信息
    List<Student> classStudentList = table.Student.getClassStudentList_ClassNoIsNull(class_no);
    assert classInformation != null;
%>

<table class="animated fadeInUp">
    <caption>
        <%=classInformation.getClass_name()%>
        <br/>
        请选择学生
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
        <th>操作</th>
    </tr>
    <%
        for (data.Student student : classStudentList)
        {
    %>
    <tr>
        <td>
            <%=student.getStudent_no()%>
        </td>
        <td>
            <%=student.getName()%>
        </td>
        <td>
            <%=student.getSex()%>
        </td>
        <td>
            <%=student.getTelephone_number()%>
        </td>
        <td>
            <%=student.getFamily_telephone_number()%>
        </td>
        <td>
            <%=student.getBirthday()%>
        </td>
        <td>
            <%=student.getAddress()%>
        </td>
        <td>
            <%=student.getId_card()%>
        </td>
        <td>
            <a href="update_score_course.jsp?no=<%=student.getStudent_no()%>">进入</a>
        </td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
