package table;

import tools.Handler.BeanHandler;
import tools.Handler.BeanListHandler;
import tools.Handler.ScalarHandler;
import tools.JDBCTemplate;

import java.util.List;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(类名): Teacher
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 23:13
 * Version(版本): 1.0
 * Description(描述)： 老师
 */

public class Teacher
{
    /**
     * 私有化构造函数，目的是不让创建对象
     */
    public Teacher()
    {
    }

    /**
     * 获得老师列表
     *
     * @return List<data.Teacher>对象
     */
    public static List<data.Teacher> getTeacherList()
    {
        //sql语句
        String sql = "select * from teacher";
        //参数，无
        Object[] objects = {};
        //执行sql
        List<data.Teacher> list = JDBCTemplate.queryForList(sql, new BeanListHandler<>(data.Teacher.class));
        //返回结果
        return list;
    }

    /**
     * 获得某个老师的信息
     *
     * @param teacher_no 老师编号
     * @return data.Teacher对象
     */
    public static data.Teacher getTeacher(Long teacher_no)
    {
        //sql语句
        String sql = "SELECT * from teacher where teacher_no=?";
        //参数
        Object[] objects = {teacher_no};
        //执行sql
        data.Teacher teacher = JDBCTemplate.queryForObject(sql, new BeanHandler<>(data.Teacher.class), objects);
        //判断返回值
        if (teacher.getTeacher_no() == null)
        {
            return null;
        }
        return teacher;
    }

    /**
     * 获得老师总数
     *
     * @return 老师的总数量
     */
    public static Long getTeacherCount()
    {
        //sql语句
        String sql = "SELECT COUNT(teacher.`teacher_no`) FROM teacher";
        //参数，无
        Object[] objects = {};
        //执行sql
        Long result = JDBCTemplate.queryForScalar(sql, new ScalarHandler<>(), objects);
        //返回结果
        return result;
    }

    /**
     * 插入一条老师信息
     *
     * @param teacher_no               老师编号
     * @param teacher_name             老师姓名
     * @param teacher_sex              老师性别
     * @param teacher_telephone_number 老师电话号码
     * @param teacher_email            老师电子邮箱
     * @param teacher_address          老师家庭地址
     * @param teacher_idcard           老师身份证号码
     * @return 成功，返回true，失败返回false
     */
    public static boolean insert(Long teacher_no, String teacher_name, String teacher_sex, String teacher_telephone_number,
                                 String teacher_email, String teacher_address, String teacher_idcard)
    {
        //获得身份证后六位,作为初始密码
        String password = teacher_idcard.substring(teacher_idcard.length() - 6);
        //获得密码的散列值
        String password_SHA256 = SHA.SHA256.getSHA256(password);
        //sql语句
        String sql1 = "insert into teacher values(?,?,?,?,?,?,?)";
        String sql2 = "insert into teacher_password values(?,?)";
        //参数
        Object[] objects1 = {teacher_no, teacher_name, teacher_sex, teacher_telephone_number, teacher_email, teacher_address, teacher_idcard};
        Object[] objects2 = {teacher_no, password_SHA256};
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
     * 更新老师信息
     *
     * @param teacher_no               要更新的老师编号
     * @param teacher_name             老师姓名
     * @param teacher_sex              老师性别
     * @param teacher_telephone_number 老师电话号码
     * @param teacher_email            老师电子邮箱
     * @param teacher_address          老师家庭地址
     * @param teacher_idcard           老师身份证号码,身份证号码输错了建议先删除再插入，因为更新身份证号码，初始密码不会变
     * @return 成功，返回true，失败返回false
     */
    public static boolean update(Long teacher_no, String teacher_name, String teacher_sex, String teacher_telephone_number,
                                 String teacher_email, String teacher_address, String teacher_idcard)
    {
        //sql语句
        String sql = "UPDATE teacher SET teacher_name=?,teacher_sex=?,teacher_telephone_number=?,teacher_email=?," +
                "teacher_address=?,teacher_idcard=? WHERE teacher_no=?";
        //参数
        Object[] objects = {teacher_name, teacher_sex, teacher_telephone_number, teacher_email, teacher_address, teacher_idcard, teacher_no};
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
     * 删除老师信息，删除之前要确保删除掉与此信息关联的信息（teach），否则删除失败
     *
     * @param teacher_no 要删除的老师编号
     * @return 成功，返回true，失败返回false
     */
    public static boolean delete(Long teacher_no)
    {
        //sql语句
        String sql1 = "delete from teacher_password where teacher_no=?";
        String sql2 = "delete from teacher where teacher_no=?";
        //参数
        Object[] objects1 = {teacher_no};
        Object[] objects2 = {teacher_no};
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
