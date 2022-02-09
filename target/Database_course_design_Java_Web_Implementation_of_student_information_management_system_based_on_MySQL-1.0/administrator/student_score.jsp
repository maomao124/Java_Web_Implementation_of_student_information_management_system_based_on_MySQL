<%@ page import="data.Student" %>
<%@ page import="table.Score" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): student_score
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/9
  Time(创建时间)： 15:18
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生课程信息</title>
    <link rel="stylesheet" href="css/table.css">
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
    <style>
        body {
            background-color: skyblue;
        }

        div.p {
            width: 500px;
            position: absolute;
            left: 50%;
            transform: translate(-50%, 0%);
            transition: all 1s linear 0s;
        }

        div.p:hover {
            width: 700px;
            position: absolute;
            left: 50%;
            transform: translate(-50%, 0%);
            transition: all 1s linear 0s;
        }

        p.text {
            text-align: center;
            font-size: 25px;
            color: coral;
            background: cornsilk;
            border-style: dotted;
            border-color: plum;
            border-width: 10px;
            transition: all 1s linear 0s;
        }

        p:hover
        {
            background: aquamarine;
            transition: all 1s linear 0s;
        }

        /*a.back {*/
        /*    text-decoration: none;*/
        /*    color: #0066ff;*/
        /*    font-size: 22px;*/
        /*}*/
    </style>
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
    Student student = table.Student.getStudent(no);
    if (student == null)
    {
        //把错误信息写入session里
        session.setAttribute("message", "此学生不存在！");
        //转发至错误页面
        request.getRequestDispatcher("Error.jsp").forward(request, response);
    }
    //获取学生的所有课程信息
    Object[][] studentScoreArray = Score.getStudentScoreArray(no);
    assert student != null;
%>

<a class="back" href="index.jsp">返回</a>
<br>
<table class="animated fadeInUp">
    <caption>
        学生“<%=student.getName()%>”的成绩
    </caption>
    <br/>
    <tr>
        <!-- th为表格标题栏-->
        <th>课程编号</th>
        <th>课程名称</th>
        <th>课程学分</th>
        <th>课程学时</th>
        <th>考核模式</th>
        <th>平时成绩</th>
        <th>期末成绩</th>
        <th>最终成绩</th>
        <th>绩点</th>
        <th>学期</th>
    </tr>
    <%
        //学分总和
        float creditCount = 0;
        //总绩点
        float total_grade_point = 0;
        for (int i = 1; i < studentScoreArray.length; i++)
        {
    %>
    <tr>
        <td>
            <%=studentScoreArray[i][0]%>
        </td>
        <td>
            <%=studentScoreArray[i][1]%>
        </td>
        <td>
            <%=studentScoreArray[i][2]%>
        </td>
        <td>
            <%=studentScoreArray[i][3]%>
        </td>
        <td>
            <%=studentScoreArray[i][4]%>
        </td>
        <td>
            <%=studentScoreArray[i][5]%>
        </td>
        <td>
            <%=studentScoreArray[i][6]%>
        </td>
        <td>
            <%=studentScoreArray[i][7]%>
        </td>
        <td>
            <%=studentScoreArray[i][8]%>
        </td>
        <td>
            <%=studentScoreArray[i][9]%>
        </td>
    </tr>
    <%
            //增加学分总数
            creditCount = creditCount + (float) studentScoreArray[i][2];
            //增加总绩点
            total_grade_point = total_grade_point + ((float) studentScoreArray[i][2] * (float) studentScoreArray[i][8]);
        }
    %>
</table>
<%
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
%>
<div class="p">
    <div class="animated zoomInUp">
        <p class="text">
            总修得学分：<%=creditCount%>
            <br>
            获得总绩点：
            <%=total_grade_point%>
            <br/>
            平均学分绩点：
            <%=decimalFormat.format(total_grade_point / creditCount)%>
        </p>
    </div>
</div>
</body>
</html>
