<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): update_a_class_result
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/11
  Time(创建时间)： 22:17
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新班级信息-结果</title>
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
    String class_name = request.getParameter("class_name");
    String class_college = request.getParameter("class_college");
    String class_major = request.getParameter("class_major");
    String class_enrollment_year_str = request.getParameter("class_enrollment_year");

    //判断是否为空
    if (class_no_str == null || class_no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入班级编号！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (class_name == null || class_name.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入班级名称！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (class_college == null || class_college.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入所属学院！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (class_major == null || class_major.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入所属专业！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (class_enrollment_year_str == null || class_enrollment_year_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入入学年份！");
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
    Integer class_enrollment_year = null;
    try
    {
        class_enrollment_year = Integer.parseInt(class_enrollment_year_str);
    }
    catch (Exception e)
    {
        //把错误信息写入session里
        session.setAttribute("message", "入学年份不为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //判断班级编号是否存在
    data.Class classInformation = table.Class.getClassInformation(class_no);
    if (classInformation == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "该班级不存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

    //更新班级
    boolean result = table.Class.update(class_no, class_name, class_college, class_major, class_enrollment_year_str);
    if (!result)
    {
        //把错误信息写入session里
        session.setAttribute("message", "班级更新失败！");
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
