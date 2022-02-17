<%@ page import="data.Forum" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): forum
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/14
  Time(创建时间)： 22:14
  Description(描述)： 论坛
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>校园论坛</title>
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
    <link rel="stylesheet" href="css/page.css">
    <link rel="stylesheet" href="css/forum.css">
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
    Long count = table.Forum.getForumCount();
    //如果总条数为0
    if (count == 0)
    {
        //把错误信息写入session里
        session.setAttribute("message", "当前论坛无消息！<br><a href=forum_insert.jsp>发布一条消息</a>");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //获取总页数
    long pageCount = table.Forum.getPageCount(count);
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
    List<Forum> thisPageList = table.Forum.getThisPageList(pageCount, curr_page);
    //获取自身信息
    data.Administrators administrator = (data.Administrators) session.getAttribute("administrator");
%>

<a class="back animated bounceInDown" href="index.jsp">返回</a>
<a class="insert_p animated bounceInDown" href="forum_insert.jsp">发布</a>

<%
    assert thisPageList != null;
    for (data.Forum forum : thisPageList)
    {
%>
<%
    if (!forum.getForum_people_no().equals(administrator.getAdministrator_no()))
    {
%>
<div class="message animated bounceInRight">
    第
    <%=forum.getForum_no()%>
    楼
    <br>
    <%=forum.getForum_time()%>
    <%
        if (forum.getForum_identity().equals("学生"))
        {
    %>
    <div style="color: black">
        <%=forum.getForum_identity()%>
        <%=forum.getForum_name()%>：
    </div>
    <%
    }
    else if (forum.getForum_identity().equals("老师"))
    {
    %>
    <div style="color:salmon">
        <%=forum.getForum_identity()%>
        <%=forum.getForum_name()%>：
    </div>
    <%
    }
    else
    {
    %>
    <div style="color:red">
        <%=forum.getForum_identity()%>
        <%=forum.getForum_name()%>：
    </div>
    <%
        }
    %>
    <div class="content"><%=forum.getForum_content()%>
    </div>
</div>
<%
}
else
{
%>

<div class="message_self animated bounceInLeft">
    第
    <%=forum.getForum_no()%>
    楼
    <br>
    <%=forum.getForum_time()%>
    <%
        if (forum.getForum_identity().equals("学生"))
        {
    %>
    <div style="color: black">
        <%=forum.getForum_identity()%>
        <%=forum.getForum_name()%>：
    </div>
    <%
    }
    else if (forum.getForum_identity().equals("老师"))
    {
    %>
    <div style="color:salmon">
        <%=forum.getForum_identity()%>
        <%=forum.getForum_name()%>：
    </div>
    <%
    }
    else
    {
    %>
    <div style="color:red">
        <%=forum.getForum_identity()%>
        <%=forum.getForum_name()%>：
    </div>
    <%
        }
    %>
    <div class="content"><%=forum.getForum_content()%>
    </div>
</div>

<%
        }
    }
%>

<div style="float: left">
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
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
    <div class="before">
        <a class="animated slideInLeft" href="forum.jsp?page=<%=(curr_page-1)%>">上一页</a>
    </div>
    <%
        }
    %>

    <%
        if (curr_page >= 3)
        {
    %>
    <div class="before2">
        <a class="animated slideInLeft" href="forum.jsp?page=<%=(curr_page-2)%>">前两页</a>
    </div>
    <%
        }
    %>

    <%
        if (curr_page < pageCount)
        {
    %>
    <div class="next">
        <a class="animated slideInRight" href="forum.jsp?page=<%=(curr_page+1)%>">下一页</a>
    </div>
    <%
        }
    %>

    <%
        if (curr_page < pageCount - 1)
        {
    %>
    <div class="next2">
        <a class="animated slideInRight" href="forum.jsp?page=<%=(curr_page+2)%>">后两页</a>
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
        <a class="animated rotateInUpLeft" href="forum.jsp?page=<%=(1)%>">第一页</a>
    </div>
    <%
        }
    %>

    <%
        if (curr_page < pageCount - 1)
        {
    %>
    <div class="last">
        <a class="animated rotateInUpRight" href="forum.jsp?page=<%=(pageCount)%>">最后一页</a>
    </div>
    <%
        }
    %>

</div>
</body>
</html>
