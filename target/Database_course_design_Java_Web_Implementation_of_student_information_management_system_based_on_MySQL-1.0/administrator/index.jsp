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
    <link href="https://cdn.bootcdn.net/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <style>
        .clock_p {
            position: absolute;
            top: 0;
            right: 0;
        }

        .clock {
            display: flex;
            /*border: #25ffe6 solid 4px;*/
        }

        .clock p {
            width: 40px;
            font-size: 40px;
            color: #fff;
            text-align: center;
            /* 设置字体 */
            font-family: "Kanit";
            font-weight: 800;
            /* 文字阴影 实现3D效果 */
            text-shadow: 0 1px 0 #deafaf,
            0 2px 0 #bda8a8,
            0 3px 0 #d8a1a1,
            0 4px 0 #d59999,
            0 5px 0 #d29292,
            0 6px 0 #cf8b8b,
            0 7px 0 #cc8484,
            0 8px 0 #c97d7d,
            0 0 5px rgba(231, 156, 156, 0.05),
            0 -1px 3px rgba(231, 156, 156, 0.2),
            0 9px 9px rgba(231, 156, 156, 0.3),
            0 12px 12px rgba(231, 156, 156, 0.3),
            0 15px 15px rgba(231, 156, 156, 0.3);
        }

        #plane {
            color: #fff;
            font-size: 70px;
            /* 绝对定位 */
            position: absolute;
            /* 弹性布局 水平+垂直居中 */
            display: flex;
            justify-content: center;
            align-items: center;
        }


        .container {
            /* 投影效果 */
            -webkit-box-reflect: below 1px linear-gradient(transparent, rgba(0, 0, 0, 0.2));
        }

        h2 {
            color: #fff;
            font-size: 40px;
            /* 字间距 */
            letter-spacing: 15px;
            /* 转大写 */
            text-transform: uppercase;
            text-align: center;
            line-height: 40px;
            outline: none;
            /* 自定义属性--c，可通过var函数对其调用 */
            --c: lightseagreen;
            /* 调用自定义属性--c，设置文字阴影（发光效果） */
            text-shadow: 0 0 10px var(--c),
            0 0 20px var(--c),
            0 0 40px var(--c),
            0 0 80px var(--c),
            0 0 160px var(--c);
            /* 执行动画：动画名 时长 线性的 无限次播放 */
            animation: animate 5s linear infinite;
        }

        /* 定义动画 */
        @keyframes animate {
            to {
                /* 色相旋转滤镜（设置度数可改变颜色） */
                filter: hue-rotate(360deg);
            }
        }
    </style>
    <script type="text/javascript">
        function myTime()
        {
            let time = new Date();
            let hh = time.getHours();  //时
            let mm = time.getMinutes();  //分
            let ss = time.getSeconds();  //秒
            // Math.floor() 向下取整
            document.getElementById("1").innerText = Math.floor(hh / 10);
            document.getElementById("2").innerText = hh % 10;
            document.getElementById("4").innerText = Math.floor(mm / 10);
            document.getElementById("5").innerText = mm % 10;
            document.getElementById("7").innerText = Math.floor(ss / 10);
            document.getElementById("8").innerText = ss % 10;
        }

        // 一秒执行一次
        setInterval(myTime, 1000);
    </script>
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

<div id="plane">
    <i class="fa fa-paper-plane" aria-hidden="true"></i>
</div>
<script>
    let plane = document.getElementById('plane');
    let deg = 0, ex = 0, ey = 0, vx = 0, vy = 0, count = 0;
    window.addEventListener('mousemove', (e) =>
    {
        ex = e.x - plane.offsetLeft - plane.clientWidth / 2;
        ey = e.y - plane.offsetTop - plane.clientHeight / 2;
        deg = 360 * Math.atan(ey / ex) / (2 * Math.PI) + 45;
        if (ex < 0)
        {
            deg += 180;
        }
        count = 0;
    })

    function draw()
    {
        plane.style.transform = 'rotate(' + deg + 'deg)';
        if (count < 100)
        {
            vx += ex / 100;
            vy += ey / 100;
        }
        plane.style.left = vx + 'px';
        plane.style.top = vy + 'px';
        count++;
    }

    setInterval(draw, 1);
</script>

<div class="clock_p">
    <div class="clock animated bounceInDown">
        <p id="1">0</p>
        <p id="2">0</p>
        <p id="3">:</p>
        <p id="4">0</p>
        <p id="5">0</p>
        <p id="6">:</p>
        <p id="7">0</p>
        <p id="8">0</p>
    </div>
</div>


<div class="monster">
    <span class="body"></span>
    <span class="eyes"></span>
</div>

<div class="text_p">
    <div class="animated flip">
        <div class="container">
            <h2 contenteditable="true">
                欢迎登录！<%=administrator.getAdministrator_job()%><%=administrator.getAdministrator_name()%>
            </h2>
        </div>
        <%--        <div class="text">--%>
        <%--            欢迎登录！<%=administrator.getAdministrator_job()%><%=administrator.getAdministrator_name()%>--%>
        <%--        </div>--%>
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
        <a class="choose" href="forum_management.jsp?page=1">管理校园论坛</a>
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
