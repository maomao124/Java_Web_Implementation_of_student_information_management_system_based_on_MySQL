package table;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(测试类名): ClassTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/4
 * Time(创建时间)： 22:21
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class ClassTest
{

    @Test
    void getClassList()
    {
        //System.out.println(table.Class.getClassList());
        List<data.Class> list = Class.getClassList();
        for (data.Class c : list)
        {
            System.out.print(c);
        }
    }
}