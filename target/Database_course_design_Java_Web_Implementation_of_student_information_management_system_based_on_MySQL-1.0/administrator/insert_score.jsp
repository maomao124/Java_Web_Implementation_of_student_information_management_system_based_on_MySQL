<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): insert_score
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/9
  Time(创建时间)： 21:03
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生成绩</title>
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
    <link rel="stylesheet" href="css/insert_score.css">
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
%>

<a class="back" href="index.jsp">返回</a>
<div class="text_p">
    <div class="text animated flipInY">
        插入学生学号为
        <%=no%>
        的成绩
    </div>
</div>
<div class="form">
    <br/>
    <form action="insert_score_result.jsp" method="post">
        <table border="1" class="animated bounceInDown">
            <tr>
                <td colspan="2" align="center">
                </td>
            </tr>
            <tr>
                <td class="s">学号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="student_no" readonly="readonly" value="<%=no%>">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">课程号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="course_no">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">平时成绩</td>
                <td>
                    <label>
                        <input class="c" type="number" min="0.0" max="100.0" step="0.5" name="usual_score"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">期末成绩</td>
                <td>
                    <label>
                        <input class="c" type="number" min="0.0" max="100.0" step="0.5" name="end_score"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">学期</td>
                <td>
                    <label>
                        <input class="c" type="text" name="semester"/>
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
