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

    /**
     * 插入一条管理员信息,此操作应该只允许超级管理员操作
     *
     * @param administrator data.Administrators对象
     * @return 插入成功，则返回true，失败返回false
     */
    public static boolean insert(data.Administrators administrator)
    {
        //获得身份证号码
        String id_card = administrator.getAdministrator_idcard();
        //获得密码，身份证后6位
        String password = id_card.substring(id_card.length() - 6);
        //获得密码的散列值
        String password_SHA3_512 = SHA.SHA3_512.getSHA3_512(password);
        //sql语句
        String sql1 = "INSERT INTO administrators VALUES(?,?,?,?)";
        Object[] objects1 = {administrator.getAdministrator_no(), administrator.getAdministrator_name(),
                administrator.getAdministrator_job(), administrator.getAdministrator_idcard()};
        String sql2 = "INSERT INTO administrators_password VALUES(?,?)";
        Object[] objects2 = {administrator.getAdministrator_no(), password_SHA3_512};
        //执行sql语句
        String[] sql = {sql1, sql2};
        Object[][] objects = {objects1, objects2};
        int result = JDBCTemplate.update(sql, objects);
        //返回
        if (result > 0)
        {
            return true;
        }
        return false;
    }

    /**
     * 更新管理员信息，此操作应该只允许超级管理员操作
     *
     * @param administrator_no     要更新的管理员编号
     * @param administrator_name   新的管理员姓名
     * @param administrator_job    新的管理员职位
     * @param administrator_idcard 新的管理员身份证，这个用于把身份证输入错了才改这项
     * @return 更新成功，则返回true，失败返回false
     */
    public static boolean update(Long administrator_no, String administrator_name, String administrator_job, String administrator_idcard)
    {
        //sql语句
        String sql = "UPDATE administrators SET administrator_name=?,administrator_job=?,administrator_idcard=? where administrator_no=?";
        Object[] objects = {administrator_name, administrator_job, administrator_idcard, administrator_no};
        //执行sql
        int result = JDBCTemplate.update(sql, objects);
        //返回结果
        if (result > 0)
        {
            return true;
        }
        return false;
    }

    /**
     * 删除管理员信息，此操作应该只允许超级管理员操作
     *
     * @param administrator_no 要删除的管理员编号
     * @return 删除成功，则返回true，失败返回false
     */
    public static boolean delete(Long administrator_no)
    {
        //sql语句
        String sql1 = "DELETE FROM administrators_password WHERE administrator_no=?";
        String sql2 = "DELETE FROM administrators WHERE administrators.administrator_no=?";
        Object[] objects1 = {administrator_no};
        Object[] objects2 = {administrator_no};
        String[] sql = {sql1, sql2};
        Object[][] objects = {objects1, objects2};
        //执行sql
        int result = JDBCTemplate.update(sql, objects);
        //返回结果
        if (result > 0)
        {
            return true;
        }
        return false;
    }
}
