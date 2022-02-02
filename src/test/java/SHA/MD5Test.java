package SHA;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): SHA
 * Class(测试类名): MD5Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/2
 * Time(创建时间)： 14:25
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class MD5Test
{

    @Test
    void getMD5()
    {
        //e10adc3949ba59abbe56e057f20f883e
        //长度为32位
        System.out.println(SHA.MD5.getMD5("123456"));
    }

    @Test
    void getMD5toUpperCase()
    {
        System.out.println(SHA.MD5.getMD5toUpperCase("123456"));
    }
}