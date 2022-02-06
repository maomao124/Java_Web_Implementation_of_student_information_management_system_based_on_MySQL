package table;

import tools.Handler.BeanHandler;
import tools.JDBCTemplate;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(类名): StudentPassword
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 23:13
 * Version(版本): 1.0
 * Description(描述)： 学生密码表
 */

public class StudentPassword
{
    /**
     * 学生登录验证
     *
     * @param no            学生学号
     * @param LoginPassword 登录密码
     * @return 如果密码正确，返回true，密码错误，返回false
     */
    public static boolean verification(Long no, String LoginPassword)
    {
        //获得此密码的散列值
        String loginPassword_MD5 = SHA.MD5.getMD5(LoginPassword);
        //sql语句
        String sql = "select * from student_password where no=? and password=?";
        //参数
        Object[] objects = {no, loginPassword_MD5};
        //执行sql
        data.StudentPassword Password = JDBCTemplate.queryForObject(sql, new BeanHandler<>(data.StudentPassword.class), objects);
        //判断返回值
        if (Password.getNo() == null)
        {
            //主键为空，密码错误或者账号不存在
            return false;
        }
        else
        {
            //主键不为空
            Password = null;
            return true;
        }
    }

    /**
     * 更改学生密码，包含旧密码验证
     *
     * @param no          学生学号
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 如果密码正确，并且更改成功，返回true，密码错误，或者更改失败，返回false
     */
    public static boolean changePassword(Long no, String oldPassword, String newPassword)
    {
        //旧密码验证
        boolean verificationResult = verification(no, oldPassword);
        if (!verificationResult)
        {
            //验证结果为false，旧密码不正确，直接返回false
            return false;
        }
        //验证结果为true，旧密码正确
        //获得新密码的散列值
        String newPassword_MD5 = SHA.MD5.getMD5(newPassword);
        //sql语句
        String sql = "update student_password set password=? where no=?";
        //参数
        Object[] objects = {newPassword_MD5, no};
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
