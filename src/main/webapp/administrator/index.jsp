<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="data.Administrators" %>
<%@ page import="table.News" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): index
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/1/31
  Time(创建时间)： 23:18
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员-菜单</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link_index.css">
    <link rel="stylesheet" href="css/wandered_jelly.css">
    <link rel="stylesheet" href="css/newList.css">
</head>
<%
    //获得管理员信息
    data.Administrators administrator = (Administrators) session.getAttribute("administrator");
%>
<%
    if (administrator.getAdministrator_sex().equals("女"))
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
            欢迎登录！<%=administrator.getAdministrator_job()%><%=administrator.getAdministrator_name()%>
        </div>
    </div>
</div>
<div class="link">
    <div class="animated zoomInRight">
        <a class="choose" href="see_class.jsp">查看学生信息</a>
        <a class="choose" href="search.jsp">搜索学生信息</a>
        <a class="choose" href="update_class.jsp">更新学生信息</a>
        <a class="choose" href="insert.jsp">添加学生信息</a>
        <hr>
        <a class="choose" target="_blank" href="see_course.jsp">查看所有课程</a>
        <a class="choose" href="insert_course.jsp">添加课程信息</a>
        <a class="choose" href="update_course_courseList.jsp">更新课程信息</a>
        <hr>
        <a class="choose" href="insert_score_class.jsp">添加学生成绩</a>
        <a class="choose" href="update_score_class.jsp">更新学生成绩</a>
        <hr>
        <a class="choose" href="change_password.jsp">更改登录密码</a>
        <hr>
        <a class="choose" href="quit.jsp">安全退出</a>
    </div>
</div>
<div class="link2">
    <div class="animated fadeInRightBig">
        <a class="choose" href="insert_a_class.jsp">添加班级信息</a>
        <a class="choose" href="update_class_choose.jsp">更新班级信息</a>
        <hr>
        <a class="choose" href="custom_query.jsp">自定义查询</a>
        <hr>
        <a class="choose" href="login_log.jsp?page=1">查看登录日志</a>
        <hr>
        <a class="choose" href="see_newList.jsp?page=1">查看新闻列表</a>
        <a class="choose" href="insert_new.jsp">发布新闻</a>
        <a class="choose" href="update_news_list.jsp?page=1">管理已发布新闻</a>
        <hr>
        <a class="choose" href="insert_teacher.jsp">添加教师信息</a>
        <a class="choose" href="teacher_index.jsp">管理教师</a>
        <hr>
        <a class="choose" href="forum.jsp?page=1">进入校园论坛</a>
        <a class="choose" href="">管理校园论坛</a>
    </div>
</div>

<%
    //获得新闻总数
    Long newsCount = News.getNewsCount();

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
