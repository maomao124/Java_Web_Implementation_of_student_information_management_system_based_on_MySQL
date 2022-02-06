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

    @Test
    void getClassCount()
    {
        System.out.println(table.Class.getClassCount());
    }

    @Test
    void getClassInformation()
    {
        System.out.println(table.Class.getClassInformation(1003L));
    }

    @Test
    void insert()
    {
        boolean b = Class.insert(10012L, "计算机", "计算机学院", "计算机专业", "2019");
        System.out.println(b);
    }

    @Test
    void update()
    {
        boolean b = Class.update(10012L, "计算机2", "计算机学院", "计算机专业", "2020");
        System.out.println(b);
    }

    @Test
    void delete()
    {
        boolean b = Class.delete(10012L);
        System.out.println(b);
    }
}