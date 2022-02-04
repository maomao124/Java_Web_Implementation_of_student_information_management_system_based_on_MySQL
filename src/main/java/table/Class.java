package table;

import tools.Handler.BeanListHandler;
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
}
