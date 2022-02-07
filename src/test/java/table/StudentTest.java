package table;

import io.Add;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;

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

    public static int getIntRandom(int min, int max)         //空间复杂度和时间复杂度更低
    {
        if (min > max)
        {
            min = max;
        }
        return min + (int) (Math.random() * (max - min + 1));
    }

    public static int getIntRandom1(int min, int max)          //获取int型的随机数
    {
        if (min > max)
        {
            min = max;
        }
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

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
        boolean b = Student.delete(1000000001L);
        System.out.println(b);
    }

    @Test
    void add()
    {
        final int course_count = 12;
        for (int i = 0; i < 60; i++)
        {
            Map<String, String> studentInformation = Add.getStudentInformation();
            Long class_no = 1010L;
            Long student_no = 202012341001L + i;
            String name = studentInformation.get("name");
            String sex = studentInformation.get("sex");
            String address = studentInformation.get("road");
            String id_card = studentInformation.get("IdCard");
            String birthday = studentInformation.get("birthday");
            String tel = studentInformation.get("tel");
            String FamilyPhone = studentInformation.get("FamilyPhone");
            String dormitoryNumber = studentInformation.get("dormitoryNumber");
            String email = studentInformation.get("email");
            table.Student.insert(student_no, name, sex, tel, FamilyPhone, birthday, address, id_card, email, dormitoryNumber, class_no, "在读", "");
            //填充成绩
            for (int j = 0; j < course_count; j++)
            {
                Long course_no = 200001L + j;
                Float usual_score = (float) getIntRandom(60, 100);
                Float end_score = (float) getIntRandom(45, 100);
                table.Score.insert(student_no, course_no, usual_score, end_score, "2021下学期");
            }
        }

    }

    @Test
    void getStudent()
    {
        data.Student student = Student.getStudent(202012340101L);
        System.out.println(student);
    }
}