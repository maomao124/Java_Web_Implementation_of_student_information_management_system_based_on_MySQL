package table;

import tools.Handler.BeanHandler;
import tools.JDBCTemplate;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(类名): TeacherPassword
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 23:14
 * Version(版本): 1.0
 * Description(描述)： 老师密码
 */

public class TeacherPassword
{
    /**
     * 老师登录验证
     *
     * @param teacher_no    老师职工号或者编号
     * @param LoginPassword 老师登录密码
     * @return 如果密码正确，返回true，密码错误，返回false
     */
    public static boolean verification(Long teacher_no, String LoginPassword)
    {
        //获得此密码的散列值
        String loginPassword_SHA256 = SHA.SHA256.getSHA256(LoginPassword);
        //sql语句
        String sql = "select * from teacher_password where teacher_no=? and teacher_password=?";
        //参数
        Object[] objects = {teacher_no, loginPassword_SHA256};
        //执行sql
        data.TeacherPassword Password = JDBCTemplate.queryForObject(sql, new BeanHandler<>(data.TeacherPassword.class), objects);
        //判断返回值
        if (Password.getTeacher_no() == null)
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
     * 更改老师登录密码，包含旧密码验证
     *
     * @param teacher_no  老师职工号
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 如果密码正确，并且更改成功，返回true，密码错误，或者更改失败，返回false
     */
    public static boolean changePassword(Long teacher_no, String oldPassword, String newPassword)
    {
        //旧密码验证
        boolean verificationResult = verification(teacher_no, oldPassword);
        if (!verificationResult)
        {
            //验证结果为false，旧密码不正确，直接返回false
            return false;
        }
        //验证结果为true，旧密码正确
        //获得新密码的散列值
        String newPassword_SHA256 = SHA.SHA256.getSHA256(newPassword);
        //sql语句
        String sql = "update teacher_password set teacher_password=? where teacher_no=?";
        //参数
        Object[] objects = {newPassword_SHA256, teacher_no};
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
