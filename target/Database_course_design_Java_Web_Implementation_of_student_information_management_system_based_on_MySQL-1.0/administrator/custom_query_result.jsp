<%@ page import="table.Customize" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): custom_query_result
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/12
  Time(创建时间)： 19:10
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>自定义查询-结果</title>
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
    <link rel="stylesheet" href="css/table_student.css">
    <style>
        body {
            background: skyblue;
        }
        div.text {
            border: 10px violet dotted;
            text-align: center;
            font-size: 32px;
            color: tomato;
            background: bisque;
        }

        div.text_p {
            position: absolute;
            top: 2%;
            left: 50%;
            transform: translate(-50%, 0%);
        }
    </style>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    //获取信息
    String sql = request.getParameter("sql");
    //判断是否为空
    if (sql == null || sql.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "提交的SQL语句为空或者单独访问此页面！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //判断是否包含SELECT关键字
    if (!sql.toLowerCase().contains("select"))
    {
        //把错误信息写入session里
        session.setAttribute("message", "提交的SQL语句应该要包含select关键字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //不是更新语句
    if (sql.toLowerCase().contains("update") && sql.toLowerCase().contains("set"))
    {
        //把错误信息写入session里
        session.setAttribute("message", "提交的SQL语句不能包含update关键字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (sql.toLowerCase().contains("delete") && sql.toLowerCase().contains("from"))
    {
        //把错误信息写入session里
        session.setAttribute("message", "提交的SQL语句不能包含delete关键字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //不能包含password关键字
    if (sql.toLowerCase().contains("password"))
    {
        //把错误信息写入session里
        session.setAttribute("message", "提交的SQL语句不能包含password关键字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //查询
    Object[][] objects = Customize.queryForArray(sql);
    //判断是否错误
    if (Customize.isError)
    {
        //把错误信息写入session里
        session.setAttribute("message", table.Customize.getErrorMessage());
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
%>

<a class="back" href="index.jsp">返回</a>
<div class="text_p">
    <div class="text animated bounceInUp">
        自定义查询结果
    </div>
</div>

<table class="animated headShake">
    <caption>
        <br/>
    </caption>
    <br/>
    <tr>
        <!-- th为表格标题栏-->
        <%
            for (int i = 0; i < objects[0].length; i++)
            {
        %>
        <th>
            <%=objects[0][i]%>
        </th>
        <%
            }
        %>

    </tr>
    <%
        for (int i = 1; i < objects.length; i++)
        {
    %>
    <tr>
        <%
            for (int j = 0; j < objects[i].length; j++)
            {

        %>
        <td>
            <%=objects[i][j]%>
        </td>
        <%
            }
        %>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
