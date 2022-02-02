package SHA;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): SHA
 * Class(测试类名): SHA3_512Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/2
 * Time(创建时间)： 14:27
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class SHA3_512Test
{

    @Test
    void getSHA3_512()
    {
        //64d09d9930c8ecf79e513167a588cb75439b762ce8f9b22ea59765f32aa74ca19d2f1e97dc922a3d4954594a05062917fb24d1f8e72f2ed02a58ed7534f94d27
        //长度为128位
        System.out.println(SHA.SHA3_512.getSHA3_512("123456"));
    }

    @Test
    void getSHA3_512toUpperCase()
    {
        System.out.println(SHA.SHA3_512.getSHA3_512toUpperCase("123456"));
    }
}