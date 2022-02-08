package table;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(测试类名): TeacherPasswordTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/6
 * Time(创建时间)： 22:25
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class TeacherPasswordTest
{

    @Test
    void verification()
    {
        boolean b = TeacherPassword.verification(3004L, "111111");
        System.out.println(b);
    }

    @Test
    void changePassword()
    {
        boolean b = TeacherPassword.changePassword(3004L, "111111", "123456");
        System.out.println(b);
    }
}