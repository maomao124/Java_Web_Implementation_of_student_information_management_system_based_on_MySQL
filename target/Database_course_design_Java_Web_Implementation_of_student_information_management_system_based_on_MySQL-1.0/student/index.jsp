<%@ page import="data.Student" %>
<%@ page import="java.util.Objects" %>
<%@ page import="table.News" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): index
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/1/31
  Time(创建时间)： 23:19
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生-菜单</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link_index.css">
    <link rel="stylesheet" href="css/wandered_jelly.css">
    <link rel="stylesheet" href="css/newList.css">
</head>
<%
    //获得学生信息
    data.Student student = (Student) session.getAttribute("student");
%>
<%
    if (student.getSex().equals("女"))
    {
%>
<body style="background: pink">
    <%
    }
    else
        {
    %>
<body style="background: skyblue">
<%
    }
%>

<div class="monster">
    <span class="body"></span>
    <span class="eyes"></span>
</div>

<div class="text_p">
    <div class="animated flip">
        <div class="text">
            欢迎登录！<%=student.getName()%>
        </div>
    </div>
</div>
<div class="link">
    <div class="animated zoomInRight">
        <a class="choose" href="see_course.jsp">查看所有课程</a>
        <a class="choose" href="">查看成绩</a>
        <a class="choose" href="see_newList.jsp?page=1">查看新闻列表</a>
        <a class="choose" href="forum.jsp?page=1">进入校园论坛</a>
        <a class="choose" href="change_password.jsp">更改登录密码</a>
        <a class="choose" href="quit.jsp">安全退出</a>
    </div>
</div>
<div class="link2">
    <div class="animated fadeInRightBig">

    </div>
</div>

<%
    //获得新闻总数
    Long newsCount = table.News.getNewsCount();

%>
<%
    //如果有新闻
    if (newsCount > 0)
    {
%>
<%
    //如果新闻数量大于9条，只显示9条
    if (newsCount >= 9)
    {
%>
<div class="newList_p">
    <nav class="animated bounceInDown">
        <ul>

            <%
                for (int i = 1; i <= 9; i++)
                {
                    //获取全标题
                    String title = Objects.requireNonNull(News.getNew((long) i)).getNew_title();
                    //防止标题太长
                    if (title.length() > 19)
                    {
                        title = title.substring(0, 17) + "...";
                    }
            %>
            <li style="width: 60rem;">
                <a
                        class="new" href="new.jsp?page=<%=i%>"><%=title%>
                </a>
            </li>
            <%
                }
            %>

            <li style="width: 60rem;">
                <a class="new" href="see_newList.jsp?page=1">更多新闻</a>
            </li>
        </ul>
    </nav>
</div>
<%
}
//否则有多少条就显示多少条
else
{
%>
<div class="newList_p">
    <nav class="animated bounceInDown">
        <ul>

            <%
                for (int i = 1; i <= newsCount; i++)
                {
                    //获取全标题
                    String title = Objects.requireNonNull(News.getNew((long) i)).getNew_title();
                    //防止标题太长
                    if (title.length() > 19)
                    {
                        title = title.substring(0, 17) + "...";
                    }
            %>
            <li style="width: 60rem;">
                <a
                        class="new" href="new.jsp?page=<%=i%>"><%=title%>
                </a>
            </li>
            <%
                }
            %>

            <li style="width: 60rem;">
                <a class="new" href="see_newList.jsp?page=1">更多新闻</a>
            </li>
        </ul>
    </nav>
</div>
<%
        }
    }
%>

</body>
</html>
