package data;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): data
 * Class(类名): LoginLog
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/2
 * Time(创建时间)： 20:13
 * Version(版本): 1.0
 * Description(描述)： 登录日志
 */

public class LoginLog
{
    //日志编号，主键
    private Long log_no;
    //登录时间
    private String log_time;
    //登录人学号或者编号
    private Long log_login_no;
    //登录人姓名
    private String log_name;

    /**
     * 无参构造
     */
    public LoginLog()
    {
    }

    /**
     * 全参构造
     *
     * @param log_no       日志编号，主键
     * @param log_time     登录时间
     * @param log_login_no 登录人学号或者编号
     * @param log_name     登录人姓名
     */
    public LoginLog(Long log_no, String log_time, Long log_login_no, String log_name)
    {
        if (log_no >= 0)
        {
            this.log_no = log_no;
        }
        else
        {
            this.log_no = 0L;
        }
        this.log_time = log_time;
        if (log_login_no >= 0)
        {
            this.log_login_no = log_login_no;
        }
        else
        {
            this.log_login_no = 0L;
        }
        this.log_name = log_name;
    }

    //对应的getter方法和setter方法


    public Long getLog_no()
    {
        return log_no;
    }

    public void setLog_no(Long log_no)
    {
        if (log_no >= 0)
        {
            this.log_no = log_no;
        }
        else
        {
            this.log_no = 0L;
        }
    }

    public Long getLog_login_no()
    {
        return log_login_no;
    }

    public void setLog_login_no(Long log_login_no)
    {
        if (log_login_no >= 0)
        {
            this.log_login_no = log_login_no;
        }
        else
        {
            this.log_login_no = 0L;
        }
    }

    public String getLog_time()
    {
        return log_time;
    }

    public void setLog_time(String log_time)
    {
        this.log_time = log_time;
    }

    public String getLog_name()
    {
        return log_name;
    }

    public void setLog_name(String log_name)
    {
        this.log_name = log_name;
    }

    /**
     * toString方法
     *
     * @return 字符串
     */
    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("log_no：").append(log_no).append('\t');
        stringbuilder.append("log_time：").append(log_time).append('\t');
        stringbuilder.append("log_login_no：").append(log_login_no).append('\t');
        stringbuilder.append("log_name：").append(log_name).append('\n');
        return stringbuilder.toString();
    }
}
