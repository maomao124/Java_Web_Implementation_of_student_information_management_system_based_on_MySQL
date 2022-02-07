package table;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(测试类名): StudentTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/7
 * Time(创建时间)： 20:53
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class StudentTest
{

    @Test
    void getStudentList()
    {
        List<data.Student> studentList = Student.getStudentList();
        for (data.Student student : studentList)
        {
            System.out.print(student);
        }
    }

    @Test
    void getStudentList_ClassNoIsNull()
    {
        List<data.Student> studentList = Student.getStudentList_ClassNoIsNull();
        for (data.Student student : studentList)
        {
            System.out.print(student);
        }
    }

    @Test
    void getStudentCount()
    {
        Long studentCount = Student.getStudentCount();
        System.out.println(studentCount);
    }

    @Test
    void getClassStudentList()
    {
        List<data.Student> studentList = Student.getClassStudentList(1001L);
        for (data.Student student : studentList)
        {
            System.out.print(student);
        }
    }

    @Test
    void insert()
    {
        boolean b = Student.insert(1000000002L, "张武", "男", "18888888888", "16666666666"
                , "2001-04-05", "中国", "432222200104051314",
                "123@qq.com", "5栋311", 1001L, "在籍", "");
        System.out.println(b);
    }

    @Test
    void testInsert()
    {

    }

    @Test
    void update()
    {
        boolean b = Student.update(1000000002L, "张武", "男", "18888888588", "16666666666"
                , "2001-04-05", "中国", "432222200104051314",
                "123@qq.com", "5栋311", 1001L, "在籍", "");
        System.out.println(b);
    }

    @Test
    void delete()
    {
        boolean b = Student.delete(1000000002L);
        System.out.println(b);
    }
}