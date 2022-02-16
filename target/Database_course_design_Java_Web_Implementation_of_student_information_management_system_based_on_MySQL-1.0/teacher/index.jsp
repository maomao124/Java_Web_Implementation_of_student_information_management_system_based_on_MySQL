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
    <title>老师-菜单</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link_index.css">
    <link rel="stylesheet" href="css/wandered_jelly.css">
    <link rel="stylesheet" href="css/newList.css">
    <link rel="stylesheet" href="css/vue.css">
<%--    <link rel="stylesheet" href="../fonts/css/font-awesome.css">--%>
        <link href="https://cdn.bootcdn.net/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <style>
        body {
            /* 初始化 取消内外边距 */
            margin: 0;
            padding: 0;
            /* 100%窗口高度 */
            height: 100vh;
            /* 弹性布局 水平垂直居中 */
            display: flex;
            justify-content: center;
            align-items: center;
            /* 渐变背景 */
            background: linear-gradient(125deg, #2c3e50, #27ae60, #2980b9, #e74c3c, #8e44ad);
            /* 指定背景图像的大小 */
            background-size: 500%;
            /* 执行动画：动画名 时长 线性的 无限次播放 */
            animation: bgAnimation 15s linear infinite;
        }


        /* 定义动画 */
        @keyframes bgAnimation {
            0% {
                background-position: 0% 50%;
            }
            50% {
                background-position: 100% 50%;
            }
            100% {
                background-position: 0% 50%;
            }
        }

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


        .con {
            /* 弹性布局 水平、垂直居中 */
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            /* 100%的窗口高度 */
            height: 100vh;
            /* 行高 */
            line-height: 80px;
            font-size: 30px;
            /* 字间距 */
            letter-spacing: 15px;
        }

        .wrapper {
            /* 固定定位 窗口滚动也不会移动 */
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            /* 渐变背景 */
            background: linear-gradient(200deg, #ec77ab, #7873f5);
            /* 将元素剪切为一个圆形【25px表示圆的直径】【calc(100% - 45px) 45px表示圆心】 */
            clip-path: circle(25px at calc(0% - 45px) 45px);
            /* 过渡动画 */
            transition: all 0.3s ease-in-out;
        }

        .menu-btn {
            position: absolute;
            left: 20px;
            top: 20px;
            z-index: 2;
            /* 渐变背景 */
            background: linear-gradient(200deg, #ec77ab, #7873f5);
            width: 50px;
            height: 50px;
            text-align: center;
            line-height: 50px;
            border-radius: 50%;
            color: #fff;
            font-size: 20px;
            cursor: pointer;
            /* 这里也加个过渡动画 */
            transition: all 0.3s ease;
        }

        /* 把复选框隐藏 */
        #menu_btn {
            display: none;
        }

        #menu_btn:checked ~ .wrapper {
            /* 将元素剪切为一个圆形 75%表示圆的直径 */
            clip-path: circle(75%);
        }

        #menu_btn:checked ~ .menu-btn {
            color: #d576ba;
            background: #fff;
        }

        /* 当复选框为选中态时，改变图标 */
        #menu_btn:checked ~ .menu-btn i::before {
            content: "\f00d";
        }

        .wrapper ul {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            list-style: none;
            text-align: center;
        }

        .wrapper ul li {
            margin: 30px 0px;
        }

        .wrapper ul li a {
            color: #fff;
            text-decoration: none;
            font-size: 30px;
            font-weight: 500;
            padding: 5px 50px;
            position: relative;
            line-height: 50px;
        }

        .wrapper ul li a::after {
            content: "";
            position: absolute;
            width: 0%;
            height: 50px;
            background: #fff;
            z-index: -1;
            border-radius: 50px;
            left: 0px;
            transform: scaleY(0);
            /* 加个动画过渡 */
            transition: transform 0.3s ease;
        }

        .wrapper ul li a:hover::after {
            transform: scaleY(1);
        }

        .wrapper ul li a:hover {
            color: #d576ba;
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
    //获得教师信息
    data.Teacher teacher = (data.Teacher) session.getAttribute("teacher");
%>
<%--<%--%>
<%--    if (student.getSex().equals("女"))--%>
<%--    {--%>
<%--%>--%>
<%--<body style="background: pink">--%>
<%--    <%--%>
<%--    }--%>
<%--    else--%>
<%--        {--%>
<%--    %>--%>
<%--<body style="background: skyblue">--%>
<%--<%--%>
<%--    }--%>
<%--%>--%>
<body>


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

<div class="vue_p">
    <div class="vue animated bounceInUp">
        <span class="outer"></span>
        <span class="middle"></span>
        <span class="inner"></span>
    </div>
</div>


<div class="text_p">
    <div class="animated flip">
        <div class="container">
            <h2 contenteditable="true">欢迎登录！教师<%=teacher.getTeacher_name()%>
            </h2>
        </div>
        <%--        <div class="text">--%>
        <%--            欢迎登录！<%=student.getName()%>--%>
        <%--        </div>--%>
    </div>
</div>
<div class="link">
    <div class="animated fadeInRightBig">
        <a class="choose" href="see_course.jsp">查看所有课程</a>
        <a class="choose" href="">查看学生信息</a>
        <a class="choose" href="">登入学生成绩</a>
        <a class="choose" href="">管理员电话</a>
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


<input type="checkbox" id="menu_btn">
<label class="menu-btn" for="menu_btn">
    <i class="fa fa-bars" aria-hidden="true"></i>
</label>
<div class="wrapper">
    <ul class="menu">
        <li>
            <a href="see_course.jsp">查看所有课程</a>
        </li>
        <li>
            <a href="">查看学生信息</a>
        </li>
        <li>
            <a href="">登入学生成绩</a>
        </li>
        <li>
            <a href="">管理员电话</a>
        </li>
        <li>
            <a href="see_newList.jsp?page=1">查看新闻列表</a>
        </li>
        <li>
            <a href="forum.jsp?page=1">进入校园论坛</a>
        </li>
        <li>
            <a href="change_password.jsp">更改登录密码</a>
        </li>
        <li>
            <a href="quit.jsp">安全退出</a>
        </li>
    </ul>
</div>

</body>
</html>
