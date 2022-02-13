package table;

import tools.Handler.BeanHandler;
import tools.Handler.BeanListHandler;
import tools.Handler.ScalarHandler;
import tools.JDBCTemplate;

import java.util.List;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(类名): Teach
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 23:13
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Teach
{
    /**
     * 私有化构造函数，目的是不让创建对象
     */
    public Teach()
    {
    }

    /**
     * 获得老师教授列表，不推荐使用
     *
     * @return List<data.Teach>对象
     */
    public static List<data.Teach> getTeachList()
    {
        //sql语句
        String sql = "select * from teach";
        //参数，无
        Object[] objects = {};
        //执行sql
        List<data.Teach> list = JDBCTemplate.queryForList(sql, new BeanListHandler<>(data.Teach.class));
        //返回结果
        return list;
    }

    /**
     * 获得某个老师的工作信息列表（教授的班级和课程）
     *
     * @param teacher_no 老师编号
     * @return List<data.Teach>对象
     */
    public static List<data.Teach> getTeacher_teach(Long teacher_no)
    {
        //sql语句
        String sql = "SELECT * from teach where teacher_no=?";
        //参数
        Object[] objects = {teacher_no};
        //执行sql
        List<data.Teach> list = JDBCTemplate.queryForList(sql, new BeanListHandler<>(data.Teach.class), objects);
        //返回
        return list;
    }

    /**
     * 获得总数
     *
     * @return 总数量
     */
    public static Long getTeachCount()
    {
        //sql语句
        String sql = "SELECT COUNT(teach.`teach_no`) FROM teach";
        //参数，无
        Object[] objects = {};
        //执行sql
        Long result = JDBCTemplate.queryForScalar(sql, new ScalarHandler<>(), objects);
        //返回结果
        return result;
    }


    public static Long getTeacherTeachCount(Long teacher_no)
    {
        //sql语句
        String sql = "SELECT COUNT(teach.`teach_no`) FROM teach WHERE teacher_no=?";
        //参数，无
        Object[] objects = {teacher_no};
        //执行sql
        Long result = JDBCTemplate.queryForScalar(sql, new ScalarHandler<>(), objects);
        //返回结果
        return result;
    }

    /**
     * 插入一条教书信息
     *
     * @param teacher_no 老师编号
     * @param class_no   班级编号
     * @param course_no  课程编号
     * @param semester   学期
     * @return 成功，返回true，失败返回false
     */
    public static boolean insert(Long teacher_no, Long class_no, Long course_no, String semester)
    {
        //sql语句
        String sql = "INSERT INTO teach (teach.teacher_no,teach.class_no,teach.course_no,teach.semester) VALUES(?,?,?,?)";
        //参数
        Object[] objects = {teacher_no, class_no, course_no, semester};
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
     * 删除编号为teach_no的教书信息
     *
     * @param teach_no 编号
     * @return 成功，返回true，失败返回false
     */
    public static boolean delete(Long teach_no)
    {
        //sql语句
        String sql = "delete from teach where teach_no=?";
        //参数
        Object[] objects = {teach_no};
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
     * 删除一名老师的所有教书信息
     *
     * @param teacher_no 老师编号
     * @return 成功，返回true，失败返回false
     */
    public static boolean delete_teacher(Long teacher_no)
    {
        //sql语句
        String sql = "delete from teach where teacher_no=?";
        //参数
        Object[] objects = {teacher_no};
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
     * 验证信息是否存在，用于插入判断
     *
     * @param teacher_no 老师编号
     * @param class_no   班级编号
     * @param course_no  课程编号
     * @return 如果存在，返回true，不存在，返回false
     */
    public static boolean verification(Long teacher_no, Long class_no, Long course_no)
    {
        //sql语句
        String sql = "SELECT * from teach where teacher_no=? and class_no=? and course_no=?";
        //参数
        Object[] objects = {teacher_no, class_no, course_no};
        //执行sql
        data.Teach teach = JDBCTemplate.queryForObject(sql, new BeanHandler<>(data.Teach.class), objects);
        //判断返回值
        if (teach.getTeach_no() == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
