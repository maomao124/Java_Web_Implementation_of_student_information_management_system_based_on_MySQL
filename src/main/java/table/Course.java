package table;

import tools.Handler.BeanHandler;
import tools.Handler.BeanListHandler;
import tools.Handler.ScalarHandler;
import tools.JDBCTemplate;

import java.util.List;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(类名): Course
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 23:12
 * Version(版本): 1.0
 * Description(描述)： 课程表
 */

public class Course
{
    /**
     * 获得课程列表
     *
     * @return List<data.Course>集合对象
     */
    public static List<data.Course> getCourseList()
    {
        //sql语句
        String sql = "select * from course";
        //参数，无
        Object[] objects = {};
        //执行sql
        List<data.Course> list = JDBCTemplate.queryForList(sql, new BeanListHandler<>(data.Course.class), objects);
        //返回结果
        return list;
    }

    /**
     * 获取课程总数量
     *
     * @return Long型，课程总数量
     */
    public static Long getCourseCount()
    {
        Long count = 0L;
        //sql语句
        String sql = "SELECT COUNT(course.course_no) FROM course";
        //执行sql语句
        count = JDBCTemplate.queryForScalar(sql, new ScalarHandler<>());
        //返回结果
        return count;
    }

    /**
     * 根据课程编号获得课程信息
     *
     * @return data.Course对象
     */
    public static data.Course getCourseInformation(Long course_no)
    {
        //sql语句
        String sql = "SELECT * FROM course WHERE course_no=?";
        //参数
        Object[] objects = {course_no};
        //执行sql语句
        data.Course course = JDBCTemplate.queryForObject(sql, new BeanHandler<>(data.Course.class), objects);
        //返回结果
        if (course.getCourse_no() == null)
        {
            return null;
        }
        return course;
    }

    /**
     * 插入一条班级数据
     *
     * @param course_no     课程编号
     * @param course_name   课程名称
     * @param course_credit 课程学分
     * @param course_hour   课程学时
     * @param course_mode   方式，考试或者考察
     * @return 成功则返回true，失败返回false
     */
    public static boolean insert(Long course_no, String course_name, Float course_credit, Integer course_hour, String course_mode)
    {
        //sql语句
        String sql = "insert into course values (?,?,?,?,?)";
        //参数
        Object[] objects = {course_no, course_name, course_credit, course_hour, course_mode};
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
     * 更新课程数据，不可更新课程编号
     *
     * @param course_no     要更新的课程编号
     * @param course_name   课程名称
     * @param course_credit 课程学分
     * @param course_hour   课程学时
     * @param course_mode   方式，考试或者考察
     * @return 成功，返回true，失败返回false
     */
    public static boolean update(Long course_no, String course_name, Float course_credit, Integer course_hour, String course_mode)
    {
        //sql语句
        String sql = "UPDATE course SET course_name=?,course_credit=?,course_hour=?,course_mode=? WHERE course_no=?";
        //参数
        Object[] objects = {course_name, course_credit, course_hour, course_mode, course_no};
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
     * 删除课程
     *
     * @param class_no 课程编号
     * @return 成功，返回true，失败返回false
     */
    public static boolean delete(Long course_no)
    {
        //sql语句
        String sql = "delete from course where course_no=?";
        //参数
        Object[] objects = {course_no};
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
