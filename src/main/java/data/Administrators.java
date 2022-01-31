package data;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): data
 * Class(类名): Administrators
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 21:43
 * Version(版本): 1.0
 * Description(描述)： 管理员类数据
 */

public class Administrators
{
    //管理员编号
    private Long administrator_no;
    //管理员姓名
    private String administrator_name;
    //管理员职务
    private String administrator_job;

    /**
     * 无参构造
     */
    public Administrators()
    {
    }

    /**
     * 全参构造
     *
     * @param administrator_no   管理员编号
     * @param administrator_name 管理员姓名
     * @param administrator_job  管理员职务
     */
    public Administrators(Long administrator_no, String administrator_name, String administrator_job)
    {
        if (administrator_no < 0)
        {
            this.administrator_no = 0L;
        }
        else
        {
            this.administrator_no = administrator_no;
        }
        this.administrator_name = administrator_name;
        this.administrator_job = administrator_job;
    }

    //对应的getter方法和setter方法


    public Long getAdministrator_no()
    {
        return administrator_no;
    }

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

    public String getAdministrator_name()
    {
        return administrator_name;
    }

    public void setAdministrator_name(String administrator_name)
    {
        this.administrator_name = administrator_name;
    }

    public String getAdministrator_job()
    {
        return administrator_job;
    }

    public void setAdministrator_job(String administrator_job)
    {
        this.administrator_job = administrator_job;
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
        stringbuilder.append("administrator_name：").append(administrator_name).append('\t');
        stringbuilder.append("administrator_job：").append(administrator_job).append('\n');
        return stringbuilder.toString();
    }
}
