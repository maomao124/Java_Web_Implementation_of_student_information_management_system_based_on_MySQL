package table;

import tools.Handler.BeanHandler;
import tools.Handler.BeanListHandler;
import tools.Handler.ScalarHandler;
import tools.JDBCTemplate;

import java.util.List;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(类名): Class
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 23:12
 * Version(版本): 1.0
 * Description(描述)： 班级表
 */

public class Class
{
    /**
     * 私有化构造函数，不能创建对象
     */
    public Class()
    {
    }

    /**
     * 获得班级列表
     *
     * @return List<data.Class>集合对象
     */
    public static List<data.Class> getClassList()
    {
        //sql语句
        String sql = "select * from class";
        //参数，无
        Object[] objects = {};
        //执行sql
        List<data.Class> list = JDBCTemplate.queryForList(sql, new BeanListHandler<>(data.Class.class), objects);
        //返回结果
        return list;
    }

    /**
     * 获取班级总数量
     *
     * @return Long型，班级总数量
     */
    public static Long getClassCount()
    {
        Long count = 0L;
        //sql语句
        String sql = "SELECT COUNT(class.class_no) FROM class";
        //执行sql语句
        count = JDBCTemplate.queryForScalar(sql, new ScalarHandler<>());
        //返回结果
        return count;
    }

    /**
     * 根据班级编号获得班级信息
     *
     * @return data.Class对象
     */
    public static data.Class getClassInformation(Long class_no)
    {
        //sql语句
        String sql = "SELECT * FROM class WHERE class_no=?";
        //参数
        Object[] objects = {class_no};
        //执行sql语句
        data.Class class1 = JDBCTemplate.queryForObject(sql, new BeanHandler<>(data.Class.class), objects);
        //返回结果
        if (class1.getClass_no() == null)
        {
            return null;
        }
        return class1;
    }

    /**
     * 插入一条班级数据
     *
     * @param class_no              班级编号
     * @param class_name            班级名称
     * @param class_college         所属学院
     * @param class_major           所属专业
     * @param class_enrollment_year 入学年份
     * @return 成功则返回true，失败返回false
     */
    public static boolean insert(Long class_no, String class_name, String class_college, String class_major, String class_enrollment_year)
    {
        //sql语句
        String sql = "insert into class values (?,?,?,?,?)";
        //参数
        Object[] objects = {class_no, class_name, class_college, class_major, class_enrollment_year};
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
     * 更新班级数据，不可更新班级编号
     *
     * @param class_no              要更新的班级编号
     * @param class_name            班级名称
     * @param class_college         学院
     * @param class_major           专业
     * @param class_enrollment_year 入学年份
     * @return 成功，返回true，失败返回false
     */
    public static boolean update(Long class_no, String class_name, String class_college, String class_major, Integer class_enrollment_year)
    {
        //sql语句
        String sql = "UPDATE class SET class_name=?,class_college=?,class_major=?,class_enrollment_year=? WHERE class_no=?";
        //参数
        Object[] objects = {class_name, class_college, class_major, class_enrollment_year, class_no};
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
     * 删除班级
     *
     * @param class_no 班级编号
     * @return 成功，返回true，失败返回false
     */
    public static boolean delete(Long class_no)
    {
        //sql语句
        String sql = "delete from class where class_no=?";
        //参数
        Object[] objects = {class_no};
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
