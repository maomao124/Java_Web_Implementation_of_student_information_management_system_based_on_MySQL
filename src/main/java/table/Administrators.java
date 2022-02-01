package table;

import tools.Handler.BeanHandler;
import tools.Handler.BeanListHandler;
import tools.JDBCTemplate;

import java.util.List;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(类名): Administrators
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 23:12
 * Version(版本): 1.0
 * Description(描述)： 管理员信息表
 */

public class Administrators
{
    /**
     * 私有化构造函数，不能创建对象
     */
    private Administrators()
    {
    }

    /**
     * 管理员信息表，查询全部信息并返回集合对象
     *
     * @return List<data.Administrators>对象
     */
    public static List<data.Administrators> getAdministrators()
    {
        String sql = "SELECT * FROM administrators";
        //查询
        List<data.Administrators> administrators = JDBCTemplate.queryForList(sql, new BeanListHandler<>(data.Administrators.class));
        return administrators;
    }

    /**
     * 获得某个管理员的信息
     *
     * @param no 管理员编号
     * @return data.Administrators对象
     */
    public static data.Administrators getAdministrator(Long no)
    {
        String sql = "SELECT * FROM administrators WHERE administrator_no=?";
        //占位符参数列表
        Object[] objects = {no};
        //查询
        data.Administrators administrator = JDBCTemplate.queryForObject(sql, new BeanHandler<>(data.Administrators.class), objects);
        //主键为空，直接返回null
        if (administrator.getAdministrator_no() == null)
        {
            return null;
        }
        return administrator;
    }
}
