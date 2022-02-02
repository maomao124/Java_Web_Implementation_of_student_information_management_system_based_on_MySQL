package table;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(测试类名): AdministratorsPasswordTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/2
 * Time(创建时间)： 19:16
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class AdministratorsPasswordTest
{

    @Test
    void verification()
    {
        boolean verification = AdministratorsPassword.verification(10001L, "156312");
        System.out.println(verification);
    }

    @Test
    void changePassword()
    {
        boolean b = AdministratorsPassword.changePassword(10001L, "156312", "123456");
        System.out.println(b);
    }
}