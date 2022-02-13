<%@ page import="table.News" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): see_newList
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/12
  Time(创建时间)： 21:31
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻列表</title>
    <link rel="stylesheet" href="css/table.css">
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
    <link rel="stylesheet" href="css/page.css">
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
    //获取总页数
    long pageCount = News.getPageCount(count);
    //判断是否有新闻
    if (count == 0)
    {
        //把错误信息写入session里
        session.setAttribute("message", "当前没有已发布的新闻！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //判断当前页面是否大于页总数
    if (curr_page > pageCount)
    {
        //把错误信息写入session里
        session.setAttribute("message", "当前页面大于页面总数！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //获得当前页面列表
    List<data.News> thisPageList = News.getThisPageList(pageCount, curr_page);
%>

<a class="back" href="index.jsp">返回</a>

<table class="animated fadeInUp">
    <caption>
        当前页面：
        <%=curr_page%>
    </caption>
    <br/>
    <tr>
        <!-- th为表格标题栏-->
        <th>新闻编号</th>
        <th>新闻发布者</th>
        <th>发布者身份</th>
        <th>发布时间</th>
        <th>新闻标题</th>
        <th>操作</th>
    </tr>
    <%
        int i = 1;
        assert thisPageList != null;
        for (data.News news : thisPageList)
        {
    %>
    <tr>
        <td>
            <%=news.getNew_no()%>
        </td>
        <td>
            <%=news.getNew_author()%>
        </td>
        <td>
            <%=news.getNew_identity()%>
        </td>
        <td>
            <%=news.getNew_time()%>
        </td>
        <td>
            <%=news.getNew_title()%>
        </td>
        <td>
            <a style="width: 50px;display:inline;"
               href="new.jsp?page=<%=(table.News.getPageSize()*(curr_page-1)+i)%>">查看</a>
        </td>
    </tr>
    <%
            i++;
        }
    %>
</table>
<br/>

<%
    if (curr_page >= 2)
    {
%>
<div class="before">
    <a class="animated slideInLeft" href="see_newList.jsp?page=<%=(curr_page-1)%>">上一页</a>
</div>
<%
    }
%>

<%
    if (curr_page >= 3)
    {
%>
<div class="before2">
    <a class="animated slideInLeft" href="see_newList.jsp?page=<%=(curr_page-2)%>">前两页</a>
</div>
<%
    }
%>

<%
    if (curr_page < pageCount)
    {
%>
<div class="next">
    <a class="animated slideInRight" href="see_newList.jsp?page=<%=(curr_page+1)%>">下一页</a>
</div>
<%
    }
%>

<%
    if (curr_page < pageCount - 1)
    {
%>
<div class="next2">
    <a class="animated slideInRight" href="see_newList.jsp?page=<%=(curr_page+2)%>">后两页</a>
</div>
<%
    }
%>

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

<%
    if (curr_page >= 2)
    {
%>
<div class="first">
    <a class="animated rotateInUpLeft" href="see_newList.jsp?page=<%=(1)%>">第一页</a>
</div>
<%
    }
%>

<%
    if (curr_page < pageCount - 1)
    {
%>
<div class="last">
    <a class="animated rotateInUpRight" href="see_newList.jsp?page=<%=(pageCount)%>">最后一页</a>
</div>
<%
    }
%>
</body>
</html>
