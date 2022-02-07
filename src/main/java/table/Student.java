package table;

import tools.Handler.BeanListHandler;
import tools.Handler.ScalarHandler;
import tools.JDBCTemplate;

import java.util.List;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(类名): Student
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 23:11
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Student
{
    /**
     * 私有化构造函数，目的是不让创建对象
     */
    public Student()
    {
    }

    /**
     * 获得学生信息列表，学生信息列表可能较多
     *
     * @return List<data.Student>对象
     */
    public static List<data.Student> getStudentList()
    {
        //sql语句
        String sql = "select * from student";
        //参数，无
        Object[] objects = {};
        //执行sql
        List<data.Student> list = JDBCTemplate.queryForList(sql, new BeanListHandler<>(data.Student.class), objects);
        //返回结果
        return list;
    }

    /**
     * 获得学生信息列表，与getStudentList方法不同的是：该方法不会返回班级编号，也就是班级编号那一栏始终为null
     *
     * @return List<data.Student>对象，Student对象中class_no为空
     */
    public static List<data.Student> getStudentList_ClassNoIsNull()
    {
        //sql语句
        String sql = "SELECT student.`no`,student.`name`,student.sex,student.telephone_number,student." +
                "family_telephone_number,student.birthday,student.address,student.id_card,student.email," +
                "student.dormitory_number,student.state,student.remarks FROM student";
        //参数，无
        Object[] objects = {};
        //执行sql
        List<data.Student> list = JDBCTemplate.queryForList(sql, new BeanListHandler<>(data.Student.class), objects);
        //返回结果
        return list;
    }

    /**
     * 获得学生总数量
     *
     * @return 学生总数量
     */
    public static Long getStudentCount()
    {
        //sql语句
        String sql = "SELECT COUNT(student.`no`) FROM student";
        //参数，无
        Object[] objects = {};
        //执行sql
        Long result = JDBCTemplate.queryForScalar(sql, new ScalarHandler<>(), objects);
        //返回结果
        return result;
    }

    /**
     * 获得某个班级的所有学生列表
     *
     * @param class_no 班级编号
     * @return List<data.Student>对象
     */
    public static List<data.Student> getClassStudentList(Long class_no)
    {
        //sql语句
        String sql = "select * from student where class_no=?";
        //参数
        Object[] objects = {class_no};
        //执行sql
        List<data.Student> list = JDBCTemplate.queryForList(sql, new BeanListHandler<>(data.Student.class), objects);
        //返回结果
        return list;
    }

    /**
     * 插入一条学生信息
     *
     * @param no                      学号
     * @param name                    学生姓名
     * @param sex                     学生性别
     * @param telephone_number        电话号码
     * @param family_telephone_number 家庭电话号码，或者紧急联系人
     * @param birthday                生日
     * @param address                 家庭地址
     * @param id_card                 身份证号
     * @param email                   电子邮箱
     * @param dormitory_number        寝室号
     * @param class_no                所属班级号
     * @param state                   状态，在读、毕业或者退学
     * @param remarks                 备注
     * @return 成功，返回true，失败返回false
     */
    public static boolean insert(Long no, String name, String sex, String telephone_number, String family_telephone_number,
                                 String birthday, String address, String id_card, String email, String dormitory_number,
                                 Long class_no, String state, String remarks)
    {
        //获得身份证后六位,作为初始密码
        String password = id_card.substring(id_card.length() - 6);
        //获得密码的散列值
        String password_MD5 = SHA.MD5.getMD5(password);
        //sql语句
        //插入密码
        String sql1 = "insert into student_password values(?,?)";
        //插入学生信息
        String sql2 = "insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        //参数
        Object[] objects1 = {no, password_MD5};
        Object[] objects2 = {no, name, sex, telephone_number, family_telephone_number, birthday, address,
                id_card, email, dormitory_number, class_no, state, remarks};
        //合并
        String[] sql = {sql1, sql2};
        Object[][] objects = {objects1, objects2};
        //执行sql
        int result = JDBCTemplate.update(sql, objects);
        //判断返回值
        if (result > 0)
        {
            return true;
        }
        return false;
    }

    /**
     * 插入一条学生信息
     *
     * @param student data.Student对象
     * @return 成功，返回true，失败返回false
     */
    public static boolean insert(data.Student student)
    {
        //获得身份证后六位,作为初始密码
        String password = student.getId_card().substring(student.getId_card().length() - 6);
        //获得密码的散列值
        String password_MD5 = SHA.MD5.getMD5(password);
        //sql语句
        //插入密码
        String sql1 = "insert into student_password values(?,?)";
        //插入学生信息
        String sql2 = "insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        //参数
        Object[] objects1 = {student.getNo(), password_MD5};
        Object[] objects2 = {student.getNo(), student.getName(), student.getSex(), student.getTelephone_number(),
                student.getFamily_telephone_number(), student.getBirthday(), student.getAddress(),
                student.getId_card(), student.getEmail(), student.getDormitory_number(), student.getClass_no(), student.getState(), student.getRemarks()};
        //合并
        String[] sql = {sql1, sql2};
        Object[][] objects = {objects1, objects2};
        //执行sql
        int result = JDBCTemplate.update(sql, objects);
        //判断返回值
        if (result > 0)
        {
            return true;
        }
        return false;
    }
}
