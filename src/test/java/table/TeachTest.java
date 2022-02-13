package table;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(测试类名): TeachTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/13
 * Time(创建时间)： 19:38
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class TeachTest
{

    @Test
    void getTeachList()
    {
        List<data.Teach> teachList = Teach.getTeachList();
        System.out.println(teachList);
    }

    @Test
    void getTeacher_teach()
    {
        List<data.Teach> list = Teach.getTeacher_teach(10000003L);
        System.out.println(list);
    }

    @Test
    void getTeachCount()
    {
        Long teachCount = Teach.getTeachCount();
        System.out.println(teachCount);
    }

    @Test
    void getTeacherTeachCount()
    {
        Long teacherTeachCount = Teach.getTeacherTeachCount(10000003L);
        System.out.println(teacherTeachCount);
    }

    @Test
    void insert()
    {
        table.Teach.insert(2000001L, 1001L, 1002L, "2020下学期");
    }

    @Test
    void delete()
    {

    }

    @Test
    void delete_teacher()
    {

    }

    @Test
    void verification()
    {
        boolean verification = Teach.verification(2000001L, 1001L, 1002L);
        System.out.println(verification);
    }
}