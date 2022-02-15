<%@ page import="data.News" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): new
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/15
  Time(创建时间)： 20:59
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻</title>
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
    <link rel="stylesheet" href="css/page.css">
    <link rel="stylesheet" href="css/new.css">
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
    //获取当前页面
    request.setCharacterEncoding("utf-8");
    String curr_page_str = request.getParameter("page");
    //判断是否为空
    if (curr_page_str == null || curr_page_str.equals(""))
    {
        //赋值，第一页
        curr_page_str = "1";
    }

    //转数字
    Long curr_page = null;
    try
    {
        curr_page = Long.parseLong(curr_page_str);
    }
    catch (Exception e)
    {
        //把错误信息写入session里
        session.setAttribute("message", "页面参数不为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //判断当前页面是否是大于0的
    if (curr_page <= 0)
    {
        //把错误信息写入session里
        session.setAttribute("message", "页面参数不能为负数和0！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //获得总条数
    Long count = table.News.getNewsCount();
    //判断当前页面是否大于页总数
    if (curr_page > count)
    {
        //把错误信息写入session里
        session.setAttribute("message", "当前页面大于页面总数！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //获得新闻
    News aNew = table.News.getNew(curr_page);
    if (aNew == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "新闻获取失败！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
%>

<a class="back" href="index.jsp">返回</a>

<br>
<div class="title_p">
    <div class="title animated zoomInDown">
        <%=aNew.getNew_title()%>
    </div>
</div>
<br>
<br>
<br>
<br>

<div class="author_and_time_p">
    <div class="author_and_time animated bounceInRight">
        新闻发布者：
        <%=aNew.getNew_identity()%>
        <%=aNew.getNew_author()%>
        <br>
        时间：
        <%=aNew.getNew_time()%>
    </div>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br/>

<div class="new_text_p">
    <div class="new_text animated bounceInUp">
        <c:out value="<%=aNew.getNew_text()%>" escapeXml="true" default="null"/>

    </div>

    <br/>
    <br/>
    <br/>
    <%
        if (curr_page >= 2)
        {
    %>
    <div class="before2">
        <a class="animated slideInLeft" href="new.jsp?page=<%=(curr_page-1)%>">上一条新闻</a>
    </div>
    <%
        }
    %>


    <%
        if (curr_page < count)
        {
    %>
    <div class="next2">
        <a class="animated slideInRight" href="new.jsp?page=<%=(curr_page+1)%>">下一条新闻</a>
    </div>
    <%
        }
    %>

</div>

</body>
</html>
