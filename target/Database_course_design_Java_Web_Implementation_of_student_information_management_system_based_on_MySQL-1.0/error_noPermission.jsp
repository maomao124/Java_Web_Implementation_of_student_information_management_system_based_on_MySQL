<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): error_noPermission
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/11
  Time(创建时间)： 20:22
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误</title>
    <style>
        body {
            margin: 0;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: rgb(20%, 20%, 20%);
        }

        a {
            text-decoration: none;
        }

        .warning {
            color: whitesmoke;
            font-size: 80px;
            font-family: sans-serif;
            font-weight: bold;
            position: relative;
            padding: 0.6em 0.4em;
        }

        .warning::before,
        .warning::after {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            border: 0.2em solid transparent;
            box-sizing: border-box;
            color: orangered;
            animation: rotating 10s infinite;
        }

        .warning::before {
            border-top-color: currentColor;
            border-right-color: currentColor;
            z-index: -1;
        }

        .warning::after {
            border-bottom-color: currentColor;
            border-left-color: currentColor;
            box-shadow: 0.3em 0.3em 0.3em rgba(20%, 20%, 20%, 0.8);
        }

        @keyframes rotating {
            to {
                transform: rotate(360deg);
            }
        }
    </style>
</head>
<body>
<a class="warning" href="../index.jsp">您无权限访问</a>
</body>
</html>
