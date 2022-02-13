<%@ page import="data.Administrators" %>
<%@ page import="table.News" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): insert_new_result
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/13
  Time(创建时间)： 14:29
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布新闻-结果</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    //获取信息
    String title = request.getParameter("title");
    String text = request.getParameter("text");

    //判断是否为空
    if (title == null || title.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入标题！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (text == null || text.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入正文！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //新闻不能太长
    if (title.length() > 255)
    {
        //把错误信息写入session里
        session.setAttribute("message", "新闻标题太长，新闻标题不能超过255个字符！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (text.length() > 65535)
    {
        //把错误信息写入session里
        session.setAttribute("message", "新闻正文太长，新闻正文不能超过65535个字符！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //从session里获取自身信息
    data.Administrators administrator = (Administrators) session.getAttribute("administrator");


    //插入新闻
    boolean result = News.insert(administrator.getAdministrator_name(), administrator.getAdministrator_job(), title, text);
    if (!result)
    {
        //把错误信息写入session里
        session.setAttribute("message", "新闻发布失败！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
%>

<%
    //重定向
    response.sendRedirect("see_newList.jsp?page=1");
%>
</body>
</html>
