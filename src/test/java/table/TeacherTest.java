package table;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(测试类名): TeacherTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/8
 * Time(创建时间)： 20:35
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class TeacherTest
{

    @Test
    void getTeacherList()
    {
        List<data.Teacher> list = Teacher.getTeacherList();
        for (data.Teacher t : list)
        {
            System.out.print(t);
        }
    }

    @Test
    void getTeacher()
    {
        data.Teacher teacher = Teacher.getTeacher(3001L);
        System.out.println(teacher);
    }

    @Test
    void getTeacherCount()
    {
        Long teacherCount = Teacher.getTeacherCount();
        System.out.println(teacherCount);
    }

    @Test
    void insert()
    {
        boolean b = Teacher.insert(3004L, "赵六", "男",
                "188888", "12345@qq.com", "中国", "122222200001111111");
        System.out.println(b);
    }

    @Test
    void update()
    {
        boolean b = Teacher.update(3004L, "赵六", "男",
                "188888", "1235@qq.com", "中国", "122222200001111111");
        System.out.println(b);
    }

    @Test
    void delete()
    {
        boolean b = Teacher.delete(3004L);
        System.out.println(b);
    }
}