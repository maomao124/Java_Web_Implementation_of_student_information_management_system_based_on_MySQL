<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): insert_result
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/9
  Time(创建时间)： 20:25
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>插入-结果</title>
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
    String name = request.getParameter("name");
    String sex = request.getParameter("sex");
    String telephone_number = request.getParameter("telephone_number");
    String family_telephone_number = request.getParameter("family_telephone_number");
    String birthday = request.getParameter("birthday");
    String address = request.getParameter("address");
    String id_card = request.getParameter("id_card");
    String email = request.getParameter("email");
    String dormitory_number = request.getParameter("dormitory_number");
    String class_no_str = request.getParameter("class_no");
    String state = request.getParameter("state");
    String remarks = request.getParameter("remarks");

    //验证
    if (no_str == null || no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "请输入学号！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (name == null || name.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "姓名不能为空！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (sex == null || sex.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "性别不能为空！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
//    if (telephone_number == null || telephone_number.equals(""))
//    {
//        //把错误信息写入session里
//        session.setAttribute("message", "电话号码不能为空！");
//        //转发至错误页面
//        request.getRequestDispatcher("Error.jsp").forward(request, response);
//    }
    if (birthday == null || birthday.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "生日信息不能为空！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (id_card == null || id_card.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "身份证号码不能为空！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    if (class_no_str == null || class_no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "班级编号不能为空！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //身份证验证
    assert id_card != null;
    if (id_card.length() <= 10)
    {
        //把错误信息写入session里
        session.setAttribute("message", "输入的身份证号太短！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //性别验证
    if (!(sex.equals("男") || sex.equals("女")))
    {
        //把错误信息写入session里
        session.setAttribute("message", "输入的性别只能是男或者女！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }

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

    //班级验证
    data.Class classInformation = table.Class.getClassInformation(class_no);
    if (classInformation == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "班级不存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //插入
    boolean result = table.Student.insert(no, name, sex, telephone_number, family_telephone_number, birthday,
            address, id_card, email, dormitory_number, class_no, state, remarks);
    if (!result)
    {
        //把错误信息写入session里
        session.setAttribute("message", "学生信息插入失败！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //更改成功
%>
<script>
    window.alert("插入成功！")
</script>

<%
    //重定向
    //班级
    response.sendRedirect("see_class_student.jsp?class_no=" + class_no);
%>


<%--<div>--%>
<%--    显示：--%>
<%--    学号：--%>
<%--    <%=no_str%>--%>
<%--    <br/>--%>
<%--    姓名：--%>
<%--    <%=name%>--%>
<%--    <br/>--%>
<%--    性别：--%>
<%--    <%=sex%>--%>
<%--    <br/>--%>
<%--    电话号码：--%>
<%--    <%=telephone_number%>--%>
<%--    <br/>--%>
<%--    家庭电话：--%>
<%--    <%=family_telephone_number%>--%>
<%--    <br/>--%>
<%--    生日：--%>
<%--    <%=birthday%>--%>
<%--    <br/>--%>
<%--    家庭地址：--%>
<%--    <%=address%>--%>
<%--    <br/>--%>
<%--    身份证：--%>
<%--    <%=id_card%>--%>
<%--    <br/>--%>
<%--    电子邮箱：--%>
<%--    <%=email%>--%>
<%--    <br/>--%>
<%--    寝室：--%>
<%--    <%=dormitory_number%>--%>
<%--    <br/>--%>
<%--    班级：--%>
<%--    <%=class_no%>--%>
<%--    <br/>--%>
<%--    状态：--%>
<%--    <%=state%>--%>
<%--    <br/>--%>
<%--    备注：--%>
<%--    <%=remarks%>--%>
<%--    <br/>--%>
<%--</div>--%>
</body>
</html>
