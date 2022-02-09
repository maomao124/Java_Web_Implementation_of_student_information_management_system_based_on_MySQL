<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): update
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/9
  Time(创建时间)： 16:06
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
    <link rel="stylesheet" href="css/update.css">
</head>
<body>
<%
    //从request里获取参数
    String no_str = request.getParameter("no");
    //判断是否为空
    if (no_str == null || no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "此页面不能单独访问！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
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
        session.setAttribute("message", "此页面传入的参数必须为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }
    //判断学生是否存在
    data.Student student = table.Student.getStudent(no);
    if (student == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "此学生不存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }
    assert student != null;
%>
<a class="back" href="index.jsp">返回</a>
<div class="text_p">
    <div class="text animated flipInY">
        修改学号为
        <%=student.getStudent_no()%>
        的学生基本信息
    </div>
</div>
<div class="form">
    <br/>
    <form action="update_result.jsp" method="post">
        <table border="1" class="animated bounceInDown">
            <tr>
                <td colspan="2" align="center">
                </td>
            </tr>
            <tr>
                <td class="s">学号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="student_no" readonly="readonly"
                               value="<%=student.getStudent_no()%>">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">姓名</td>
                <td>
                    <label>
                        <input class="c" type="text" name="name" value="<%=student.getName()%>">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">性别</td>
                <td>
                    <label>
                        <input class="c" type="text" name="sex" value="<%=student.getSex()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">电话号码</td>
                <td>
                    <label>
                        <input class="c" type="text" name="telephone_number"
                               value="<%=student.getTelephone_number()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">家庭电话号码</td>
                <td>
                    <label>
                        <input class="c" type="text" name="family_telephone_number"
                               value="<%=student.getFamily_telephone_number()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">生日</td>
                <td>
                    <label>
                        <input class="c" type="text" name="birthday" value="<%=student.getBirthday()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">家庭地址</td>
                <td>
                    <label>
                        <input class="c" type="text" name="address" value="<%=student.getAddress()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">身份证号码</td>
                <td>
                    <label>
                        <input class="c" type="text" name="id_card" value="<%=student.getId_card()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">电子邮箱</td>
                <td>
                    <label>
                        <input class="c" type="email" name="email" value="<%=student.getEmail()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">寝室号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="dormitory_number"
                               value="<%=student.getDormitory_number()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">班级编号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="class_no" value="<%=student.getClass_no()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">状态</td>
                <td>
                    <label>
                        <input class="c" type="text" name="state" value="<%=student.getState()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">备注</td>
                <td>
                    <label>
                        <input class="c" type="text" name="remarks" value="<%=student.getRemarks()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="提交"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
