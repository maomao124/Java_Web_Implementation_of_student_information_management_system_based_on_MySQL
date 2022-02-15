package io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): io
 * Class(测试类名): ConfigurationTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/15
 * Time(创建时间)： 19:39
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class ConfigurationTest
{

    @Test
    void test()
    {
        System.out.println(io.Configuration.getForum_pageSize());
        System.out.println(io.Configuration.getLogin_log_pageSize());
        System.out.println(io.Configuration.getNew_pageSize());
        System.out.println(io.Configuration.getError_path());
    }
}