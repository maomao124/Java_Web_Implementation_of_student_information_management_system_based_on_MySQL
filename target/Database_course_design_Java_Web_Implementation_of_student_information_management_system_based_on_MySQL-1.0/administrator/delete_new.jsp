<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): delete_new
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/13
  Time(创建时间)： 14:47
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除新闻</title>
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
    <link rel="stylesheet" href="css/page.css">
    <link rel="stylesheet" href="css/new.css">
    <link rel="stylesheet" href="css/insert_score.css">
    <link rel="stylesheet" href="css/hotAirBalloon.css">

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
    data.News aNew = table.News.getNew(curr_page);
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

<div class="text_p">
    <div class="text animated flipInY">
        删除新闻
        <br>
        新闻不能更改，只能删除再重新发布
    </div>
</div>
<div class="form">
    <br/>
    <form action="delete_new_result.jsp" method="post">
        <table border="1" class="animated bounceInDown">
            <tr>
                <td colspan="2" align="center">
                </td>
            </tr>
            <tr>
                <td class="s">新闻编号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="new_no" readonly="readonly"
                               value="<%=aNew.getNew_no()%>">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">新闻发布者</td>
                <td>
                    <label>
                        <input class="c" type="text" name="new_author" readonly="readonly"
                               value="<%=aNew.getNew_author()%>">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">新闻标题</td>
                <td>
                    <label>
                        <input class="c" type="text" readonly="readonly"
                               name="title"
                               value="<%=aNew.getNew_title()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">新闻正文</td>
                <%
                    //获取新闻标题
                    String title = aNew.getNew_text();
                    //防止标题太长
                    if (title.length() > 20)
                    {
                        title = title.substring(0, 20) + "...";
                    }
                %>
                <td>
                    <label>
                        <input class="c" type="text" readonly="readonly"
                               name="text"
                               value="<%=title%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input style="color: red;" type="submit" value="删除"/>
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
