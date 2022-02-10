<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): delete_score
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/10
  Time(创建时间)： 15:12
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除学生成绩</title>
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
    <link rel="stylesheet" href="css/insert_score.css">
    <link rel="stylesheet" href="css/hotAirBalloon.css">
</head>
<body>
<%
    //从request里获取参数
    String no_str = request.getParameter("no");
    String course_no_str = request.getParameter("course_no");
    //判断是否为空
    if (no_str == null || no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "此页面不能单独访问！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }
    if (course_no_str == null || course_no_str.equals(""))
    {
        //把错误信息写入session里
        session.setAttribute("message", "课程号为空！");
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
    Long course_no = null;
    try
    {
        assert course_no_str != null;
        course_no = Long.parseLong(course_no_str);
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
    //判断课程号是否存在
    data.Course courseInformation = table.Course.getCourseInformation(course_no);
    if (courseInformation == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "此课程不存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }
%>

<%
    //获取该学生该课程的成绩
    data.Score studentScore = table.Score.getStudentScore(no, course_no);
    //判断是否为空
    if (studentScore == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "此成绩不存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }
    assert studentScore != null;
%>

<a class="back" href="index.jsp">返回</a>
<div class="text_p">
    <div class="text animated flipInY">
        删除学生学号为
        <%=no%>、课程号为
        <%=course_no%>
        的成绩
    </div>
</div>
<div class="form">
    <br/>
    <form action="delete_score_result.jsp" method="post">
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
                        <input class="c" type="text" name="course_no" readonly="readonly" value="<%=course_no%>">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">平时成绩</td>
                <td>
                    <label>
                        <input class="c" type="number" min="0.0" max="100.0" step="0.5" name="usual_score"
                               value="<%=studentScore.getUsual_score()%>" disabled="disabled"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">期末成绩</td>
                <td>
                    <label>
                        <input class="c" type="number" min="0.0" max="100.0" step="0.5" name="end_score"
                               value="<%=studentScore.getEnd_score()%>" disabled="disabled"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">学期</td>
                <td>
                    <label>
                        <input class="c" type="text" name="semester" value="<%=studentScore.getSemester()%>"
                               disabled="disabled"/>
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

<div class="left animated slideInUp">
    <figure class="balloon">
        <div class="envelope">
            <span></span>
            <span></span>
        </div>
        <div class="basket">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </div>
    </figure>
</div>
<div class="right animated slideInUp">
    <figure class="balloon">
        <div class="envelope">
            <span></span>
            <span></span>
        </div>
        <div class="basket">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </div>
    </figure>
</div>
</body>
</html>
