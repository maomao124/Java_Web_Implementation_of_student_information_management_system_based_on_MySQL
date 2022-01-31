package data;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): data
 * Class(类名): StudentPassword
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 22:30
 * Version(版本): 1.0
 * Description(描述)： 学生密码
 */

public class StudentPassword
{
    //学生学号
    private Long no;
    //学生登录密码
    private String password;

    /**
     * 无参构造
     */
    public StudentPassword()
    {
    }

    /**
     * 全参构造
     *
     * @param no       学生学号
     * @param password 学生登录密码
     */
    public StudentPassword(Long no, String password)
    {
        if (no >= 0)
        {
            this.no = no;
        }
        else
        {
            this.no = 0L;
        }
        this.password = password;
    }

    //对应的getter方法和setter方法

    public Long getNo()
    {
        return no;
    }

    public void setNo(Long no)
    {
        if (no >= 0)
        {
            this.no = no;
        }
        else
        {
            this.no = 0L;
        }
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
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
        stringbuilder.append("no：").append(no).append('\t');
        stringbuilder.append("password：").append(password).append('\n');
        return stringbuilder.toString();
    }
}
