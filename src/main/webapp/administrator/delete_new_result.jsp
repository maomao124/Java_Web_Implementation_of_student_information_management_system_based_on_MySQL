<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): delete_new_result
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/13
  Time(创建时间)： 14:54
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除新闻-结果</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    //获取信息
    String new_no_str = request.getParameter("new_no");
    //判断是否为空
    if (new_no_str == null || new_no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "此页面不能单独访问！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //转换成数字
    Long new_no = null;
    try
    {
        new_no = Long.parseLong(new_no_str);
    }
    catch (Exception e)
    {
        //把错误信息写入session里
        session.setAttribute("message", "新闻编号不为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }


    //删除课程
    boolean result = table.News.delete(new_no);
    if (!result)
    {
        //把错误信息写入session里
        session.setAttribute("message", "新闻删除失败！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
%>

<%
    //重定向
    response.sendRedirect("update_news_list.jsp?page=1");
%>

</body>
</html>
