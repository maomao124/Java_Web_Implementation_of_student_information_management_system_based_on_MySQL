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
    //管理员性别
    private String administrator_sex;
    //管理员手机号码
    private String administrator_telephone_number;
    //管理员职务
    private String administrator_job;
    //管理员身份证号码
    private String administrator_idcard;

    /**
     * 无参构造
     */
    public Administrators()
    {
    }

    /**
     * 全参构造
     *
     * @param administrator_no               管理员编号
     * @param administrator_name             管理员姓名
     * @param administrator_sex              管理员性别
     * @param administrator_telephone_number 管理员电话号码
     * @param administrator_job              管理员职务
     * @param administrator_idcard           管理员身份证号码
     */
    public Administrators(Long administrator_no, String administrator_name, String administrator_sex,
                          String administrator_telephone_number, String administrator_job, String administrator_idcard)
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
        this.administrator_sex = administrator_sex;
        this.administrator_telephone_number = administrator_telephone_number;
        this.administrator_job = administrator_job;
        this.administrator_idcard = administrator_idcard;
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
     * Gets administrator name.
     *
     * @return the administrator name
     */
    public String getAdministrator_name()
    {
        return administrator_name;
    }

    /**
     * Sets administrator name.
     *
     * @param administrator_name the administrator name
     */
    public void setAdministrator_name(String administrator_name)
    {
        this.administrator_name = administrator_name;
    }

    /**
     * Gets administrator sex.
     *
     * @return the administrator sex
     */
    public String getAdministrator_sex()
    {
        return administrator_sex;
    }

    /**
     * Sets administrator sex.
     *
     * @param administrator_sex the administrator sex
     */
    public void setAdministrator_sex(String administrator_sex)
    {
        this.administrator_sex = administrator_sex;
    }

    /**
     * Gets administrator telephone number.
     *
     * @return the administrator telephone number
     */
    public String getAdministrator_telephone_number()
    {
        return administrator_telephone_number;
    }

    /**
     * Sets administrator telephone number.
     *
     * @param administrator_telephone_number the administrator telephone number
     */
    public void setAdministrator_telephone_number(String administrator_telephone_number)
    {
        this.administrator_telephone_number = administrator_telephone_number;
    }

    /**
     * Gets administrator job.
     *
     * @return the administrator job
     */
    public String getAdministrator_job()
    {
        return administrator_job;
    }

    /**
     * Sets administrator job.
     *
     * @param administrator_job the administrator job
     */
    public void setAdministrator_job(String administrator_job)
    {
        this.administrator_job = administrator_job;
    }

    /**
     * Gets administrator idcard.
     *
     * @return the administrator idcard
     */
    public String getAdministrator_idcard()
    {
        return administrator_idcard;
    }

    /**
     * Sets administrator idcard.
     *
     * @param administrator_idcard the administrator idcard
     */
    public void setAdministrator_idcard(String administrator_idcard)
    {
        this.administrator_idcard = administrator_idcard;
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
        stringbuilder.append("administrator_sex：").append(administrator_sex).append('\t');
        stringbuilder.append("administrator_telephone_number：").append(administrator_telephone_number).append('\t');
        stringbuilder.append("administrator_job：").append(administrator_job).append('\t');
        stringbuilder.append("administrator_idcard：").append(administrator_idcard).append('\n');
        return stringbuilder.toString();
    }
}
