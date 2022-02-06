package table;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(测试类名): CourseTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/6
 * Time(创建时间)： 20:21
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class CourseTest
{

    @Test
    void getCourseList()
    {
        List<data.Course> courseList = Course.getCourseList();
        for (data.Course course : courseList)
        {
            System.out.print(course);
        }
    }

    @Test
    void getCourseCount()
    {
        System.out.println(table.Course.getCourseCount());
    }

    @Test
    void getCourseInformation()
    {
        System.out.println(table.Course.getCourseInformation(200003L));
    }

    @Test
    void insert()
    {
        boolean b = Course.insert(200019L, "计算机网络原理", 2.5F, 48, "考试");
        System.out.println(b);
    }

    @Test
    void update()
    {
        boolean b = Course.update(200019L, "计算机网络原理", 3.5F, 48, "考试");
        System.out.println(b);
    }

    @Test
    void delete()
    {
        boolean b = Course.delete(200019L);
        System.out.println(b);
    }
}