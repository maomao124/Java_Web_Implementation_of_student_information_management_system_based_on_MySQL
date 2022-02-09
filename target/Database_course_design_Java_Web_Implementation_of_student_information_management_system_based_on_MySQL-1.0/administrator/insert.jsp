<%--
  Created by IntelliJ IDEA.
  Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
  File name(文件名): insert
  Author(作者）: mao
  Author QQ：1296193245
  GitHub：https://github.com/maomao124/
  Date(创建日期)： 2022/2/9
  Time(创建时间)： 20:13
  Description(描述)： 无
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生信息</title>
    <link rel="stylesheet" href="../animate.css">
    <link rel="stylesheet" href="css/link.css">
    <link rel="stylesheet" href="css/update.css">
</head>
<body>
<a class="back" href="index.jsp">返回</a>
<div class="text_p">
    <div class="text animated flipInY">
        插入学生基本信息
    </div>
</div>
<div class="form">
    <br/>
    <form action="insert_result.jsp" method="post">
        <table border="1" class="animated bounceInDown">
            <tr>
                <td colspan="2" align="center">
                </td>
            </tr>
            <tr>
                <td class="s">学号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="student_no">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">姓名</td>
                <td>
                    <label>
                        <input class="c" type="text" name="name">
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">性别</td>
                <td>
                    <label>
                        <input class="c" type="text" name="sex"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">电话号码</td>
                <td>
                    <label>
                        <input class="c" type="text" name="telephone_number"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">家庭电话号码</td>
                <td>
                    <label>
                        <input class="c" type="text" name="family_telephone_number"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">生日</td>
                <td>
                    <label>
                        <input class="c" type="text" name="birthday"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">家庭地址</td>
                <td>
                    <label>
                        <input class="c" type="text" name="address"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">身份证号码</td>
                <td>
                    <label>
                        <input class="c" type="text" name="id_card"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">电子邮箱</td>
                <td>
                    <label>
                        <input class="c" type="email" name="email"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">寝室号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="dormitory_number"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">班级编号</td>
                <td>
                    <label>
                        <input class="c" type="text" name="class_no"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">状态</td>
                <td>
                    <label>
                        <input class="c" type="text" name="state"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class="s">备注</td>
                <td>
                    <label>
                        <input class="c" type="text" name="remarks"/>
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
