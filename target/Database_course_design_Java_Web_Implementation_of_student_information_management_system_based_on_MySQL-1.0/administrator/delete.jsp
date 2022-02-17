<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): delete
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/9
  Time(创建时间)： 19:49
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除学生信息</title>
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
    <link rel="stylesheet" href="css/delete.css">
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
        session.setAttribute("message", "此页面传入的参数必须为数字！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    //判断学生是否存在
    data.Student student = table.Student.getStudent(no);
    if (student == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "此学生不存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
        return;
    }
    assert student != null;
%>

<a class="back" href="index.jsp">返回</a>
<div class="text_p">
    <div class="text animated flipInY">
        删除学号为
        <%=student.getStudent_no()%>
        的学生基本信息
        <br>
        删除此学生之前要确保已经删除掉与其关联的信息
    </div>
</div>
<div class="form">
    <br/>
    <form action="delete_result.jsp" method="post">
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
                        <input class="c" type="text" name="name" readonly="readonly" value="<%=student.getName()%>">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">性别</td>
                <td>
                    <label>
                        <input class="c" type="text" name="sex" readonly="readonly" value="<%=student.getSex()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">电话号码</td>
                <td>
                    <label>
                        <input class="c" type="text" name="telephone_number" readonly="readonly"
                               value="<%=student.getTelephone_number()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">家庭电话号码</td>
                <td>
                    <label>
                        <input class="c" type="text" name="family_telephone_number" readonly="readonly"
                               value="<%=student.getFamily_telephone_number()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">生日</td>
                <td>
                    <label>
                        <input class="c" type="text" name="birthday" readonly="readonly"
                               value="<%=student.getBirthday()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">家庭地址</td>
                <td>
                    <label>
                        <input class="c" type="text" name="address" readonly="readonly"
                               value="<%=student.getAddress()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">身份证号码</td>
                <td>
                    <label>
                        <input class="c" type="text" name="id_card" readonly="readonly"
                               value="<%=student.getId_card()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">电子邮箱</td>
                <td>
                    <label>
                        <input class="c" type="email" name="email" readonly="readonly" value="<%=student.getEmail()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">寝室号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="dormitory_number" readonly="readonly"
                               value="<%=student.getDormitory_number()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">班级编号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="class_no" readonly="readonly"
                               value="<%=student.getClass_no()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">状态</td>
                <td>
                    <label>
                        <input class="c" type="text" name="state" readonly="readonly" value="<%=student.getState()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">备注</td>
                <td>
                    <label>
                        <input class="c" type="text" name="remarks" readonly="readonly"
                               value="<%=student.getRemarks()%>"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input style="color: red" type="submit" value="删除"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
