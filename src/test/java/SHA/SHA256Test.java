package SHA;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): SHA
 * Class(测试类名): SHA256Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/2
 * Time(创建时间)： 14:29
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class SHA256Test
{

    @Test
    void getSHA256()
    {
        //8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92
        //长度为64位
        System.out.println(SHA.SHA256.getSHA256("123456"));
    }

    @Test
    void getSHA256toUpperCase()
    {
        System.out.println(SHA.SHA256.getSHA256("123456"));
    }
}