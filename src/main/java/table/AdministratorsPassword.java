package table;

import tools.Handler.BeanHandler;
import tools.JDBCTemplate;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(类名): AdministratorsPassword
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 23:12
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class AdministratorsPassword
{
    /**
     * 管理员登录验证
     *
     * @param administrator_no 管理员编号
     * @param LoginPassword    管理员登录密码
     * @return 如果密码正确，返回true，密码错误，返回false
     */
    public static boolean verification(Long administrator_no, String LoginPassword)
    {
        //获得此密码的散列值
        String loginPassword_SHA3_512 = SHA.SHA3_512.getSHA3_512(LoginPassword);
        //sql语句
        String sql = "select * from administrators_password where administrator_no=? and administrator_password=?";
        //参数
        Object[] objects = {administrator_no, loginPassword_SHA3_512};
        //执行sql
        data.AdministratorsPassword administratorsPassword = JDBCTemplate.queryForObject(sql, new BeanHandler<>(data.AdministratorsPassword.class), objects);
        //判断返回值
        if (administratorsPassword.getAdministrator_no() == null)
        {
            //主键为空，密码错误或者账号不存在
            return false;
        }
        else
        {
            //主键不为空
            administratorsPassword = null;
            return true;
        }
    }

    /**
     * 更改管理员密码，包含旧密码验证
     *
     * @param administrator_no 管理员编号
     * @param oldPassword      老密码
     * @param newPassword      新密码
     * @return 如果密码正确，并且更改1成功，返回true，密码错误，或者更改失败，返回false
     */
    public static boolean changePassword(Long administrator_no, String oldPassword, String newPassword)
    {
        //旧密码验证
        boolean verificationResult = verification(administrator_no, oldPassword);
        if (!verificationResult)
        {
            //验证结果为false，旧密码不正确，直接返回false
            return false;
        }
        //验证结果为true，旧密码正确
        //获得新密码的散列值
        String newPassword_SHA3_512 = SHA.SHA3_512.getSHA3_512(newPassword);
        //sql语句
        String sql = "update administrators_password set administrator_password=? where administrator_no=?";
        //参数
        Object[] objects = {newPassword_SHA3_512, administrator_no};
        //执行sql语句
        int result = JDBCTemplate.update(sql, objects);
        //处理结果
        if (result > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
