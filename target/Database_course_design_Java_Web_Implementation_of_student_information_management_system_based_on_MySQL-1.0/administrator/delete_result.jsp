<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): delete_result
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/9
  Time(创建时间)： 20:01
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除学生信息-结果</title>
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
    String no_str = request.getParameter("student_no");
    String class_no_str = request.getParameter("class_no");
//        String name = request.getParameter("name");
//        String sex = request.getParameter("sex");
//        String telephone_number = request.getParameter("telephone_number");
//        String family_telephone_number = request.getParameter("family_telephone_number");
//        String birthday = request.getParameter("birthday");
//        String address = request.getParameter("address");
//        String id_card = request.getParameter("id_card");
//        String email = request.getParameter("email");
//        String dormitory_number = request.getParameter("dormitory_number");
//        String class_no_str = request.getParameter("class_no");

    //转换成数字
    Long no = null;
    try
    {
        assert no_str != null;
        no = Long.parseLong(no_str);
    }
    catch (Exception e)
    {
        //把错误信息写入session里
        session.setAttribute("message", "学号不为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    Long class_no = null;
    try
    {
        assert class_no_str != null;
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

    //删除
    boolean result = table.Student.delete(no);
    if (!result)
    {
        //把错误信息写入session里
        session.setAttribute("message", "学生信息删除失败！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
%>
<script>
    window.alert("删除成功！")
</script>

<%
    //重定向
    //当更改了班级编号后，重定向至新的班级编号
    response.sendRedirect("update_class_student.jsp?class_no=" + class_no);
%>
</body>
</html>
