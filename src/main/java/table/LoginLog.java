package table;

import tools.Handler.BeanListHandler;
import tools.JDBCTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(类名): LoginLog
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/2
 * Time(创建时间)： 20:19
 * Version(版本): 1.0
 * Description(描述)： 登录日志表,不提供修改和删除功能
 */

public class LoginLog
{
    /**
     * 私有化构造函数，目的是不让创建对象
     */
    public LoginLog()
    {
    }

    /**
     * 获得登录日志列表，不推荐使用，因为太多，推荐使用分页的方法
     *
     * @return List<data.LoginLog>对象
     */
    public static List<data.LoginLog> getLogList()
    {
        //sql语句
        String sql = "select * from login_log order by log_no desc";
        //参数，无
        Object[] objects = {};
        //执行sql
        List<data.LoginLog> loginLogs = JDBCTemplate.queryForList(sql, new BeanListHandler<>(data.LoginLog.class), objects);
        //返回参数
        return loginLogs;
    }


    /**
     * 获得某个人的登录日志
     *
     * @param log_login_no 登录人的学号或者编号
     * @return List<data.LoginLog>对象
     */
    public static List<data.LoginLog> getPeopleLogList(Long log_login_no)
    {
        //sql语句
        String sql = "select * from login_log where log_login_no=? order by log_no desc";
        //参数
        Object[] objects = {log_login_no};
        //执行sql
        List<data.LoginLog> loginLogs = JDBCTemplate.queryForList(sql, new BeanListHandler<>(data.LoginLog.class), objects);
        //返回参数
        return loginLogs;
    }

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");

    /**
     * 插入一条日志，时间和编号由程序填充
     *
     * @param log_login_no 登录人的学号或者编号
     * @param log_name     登录人的姓名
     * @return 成功，返回true，失败返回false
     */
    public static boolean insert(Long log_login_no, String log_name)
    {
        //获得时间
        Date date = new Date();
        //获得格式化的时间
        String dateformat = simpleDateFormat.format(date);
        //sql语句
        String sql = "insert into login_log (log_time,log_login_no,log_name) values(?,?,?)";
        //参数
        Object[] objects = {dateformat, log_login_no, log_name};
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
