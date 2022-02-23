package data;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): data
 * Class(类名): AdministratorsPassword
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 21:52
 * Version(版本): 1.0
 * Description(描述)： 管理员密码
 */
public class AdministratorsPassword
{
    //管理员编号
    private Long administrator_no;
    //管理员密码
    private String administrator_password;

    /**
     * 无参构造
     */
    public AdministratorsPassword()
    {
    }

    /**
     * 全参构造
     *
     * @param administrator_no       管理员编号
     * @param administrator_password 管理员密码
     */
    public AdministratorsPassword(Long administrator_no, String administrator_password)
    {
        if (administrator_no < 0)
        {
            this.administrator_no = 0L;
        }
        else
        {
            this.administrator_no = administrator_no;
        }
        this.administrator_password = administrator_password;
    }

    //对应的getter方法和setter方法


    /**
     * Gets administrator no.
     *
     * @return the administrator no
     */
    public Long getAdministrator_no()
    {
        return administrator_no;
    }

    /**
     * Sets administrator no.
     *
     * @param administrator_no the administrator no
     */
    public void setAdministrator_no(Long administrator_no)
    {
        if (administrator_no < 0)
        {
            this.administrator_no = 0L;
        }
        else
        {
            this.administrator_no = administrator_no;
        }
    }

    /**
     * Gets administrator password.
     *
     * @return the administrator password
     */
    public String getAdministrator_password()
    {
        return administrator_password;
    }

    /**
     * Sets administrator password.
     *
     * @param administrator_password the administrator password
     */
    public void setAdministrator_password(String administrator_password)
    {
        this.administrator_password = administrator_password;
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
        stringbuilder.append("administrator_no：").append(administrator_no).append('\t');
        stringbuilder.append("administrator_password：").append(administrator_password).append('\n');
        return stringbuilder.toString();
    }
}
