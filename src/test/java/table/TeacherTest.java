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

    @Test
    void add()
    {
        final int course_count = 12;
        for (int i = 0; i < 100; i++)
        {
            Map<String, String> studentInformation = Add.getStudentInformation();
            Long class_no = 1010L;
            Long student_no = 10000001L + i;
            String name = studentInformation.get("name");
            String sex = studentInformation.get("sex");
            String address = studentInformation.get("road");
            String id_card = studentInformation.get("IdCard");
            String birthday = studentInformation.get("birthday");
            String tel = studentInformation.get("tel");
            String FamilyPhone = studentInformation.get("FamilyPhone");
            String dormitoryNumber = studentInformation.get("dormitoryNumber");
            String email = studentInformation.get("email");
            //table.Student.insert(student_no, name, sex, tel, FamilyPhone, birthday, address, id_card, email, dormitoryNumber, class_no, "在读", "");
            //table.Teacher.insert(student_no, name, sex, tel, email, address, id_card);
            //随机
            for (int j = 0; j < 3; j++)
            {
                Long class1_no = (long) getIntRandom(1001, 1010);
                Long course_no = (long) getIntRandom(200001, 200012);
                table.Teach.insert(student_no, class1_no, course_no, "2021下学期");
            }
        }

    }
}