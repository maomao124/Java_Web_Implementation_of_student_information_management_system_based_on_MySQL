<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): delete_teach_result
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/14
  Time(创建时间)： 20:39
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除教师工作信息-结果</title>
    <style>
        body {
            background-color: skyblue;
        }
    </style>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    //获取信息
    String teach_no_str = request.getParameter("teach_no");

    //验证
    if (teach_no_str == null || teach_no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "此页面不能单独访问！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //转换成数字
    Long teach_no = null;
    try
    {

        teach_no = Long.parseLong(teach_no_str);
    }
    catch (Exception e)
    {
        //把错误信息写入session里
        session.setAttribute("message", "编号不为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //判断编号是否存在
    data.Teach teach = table.Teach.getTeach(teach_no);
    if (teach == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "此信息不存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //编号存在，删除
    boolean result = table.Teach.delete(teach_no);
    //判断结果
    if (!result)
    {
        //把错误信息写入session里
        session.setAttribute("message", "删除失败！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
%>
<%
    //重定向
    response.sendRedirect("teach_index.jsp");
%>
</body>
</html>
