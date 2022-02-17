<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): delete_a_class_result
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/11
  Time(创建时间)： 22:26
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除班级信息-结果</title>
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
    String class_no_str = request.getParameter("class_no");

    //判断是否为空
    if (class_no_str == null || class_no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入班级编号！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //转换成数字
    Long class_no = null;
    try
    {
        class_no = Long.parseLong(class_no_str);
    }
    catch (Exception e)
    {
        //把错误信息写入session里
        session.setAttribute("message", "班级编号不为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //判断班级编号是否存在
    data.Class classInformation = table.Class.getClassInformation(class_no);
    if (classInformation == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "该班级不存在，无法删除！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //删除班级
    boolean result = table.Class.delete(class_no);
    if (!result)
    {
        //把错误信息写入session里
        session.setAttribute("message", "班级删除失败！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
%>

<%
    //重定向
    response.sendRedirect("update_class_choose.jsp");
%>
</body>
</html>
