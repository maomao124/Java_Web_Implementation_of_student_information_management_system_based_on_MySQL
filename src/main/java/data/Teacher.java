package data;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): data
 * Class(类名): Teacher
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 22:41
 * Version(版本): 1.0
 * Description(描述)： 无
 */
public class Teacher
{
    //老师编号
    private Long teacher_no;
    //老师姓名
    private String teacher_name;
    //老师性别
    private String teacher_sex;
    //老师电话号码
    private String teacher_telephone_number;
    //老师电子邮箱
    private String teacher_email;
    //老师家庭地址
    private String teacher_address;
    //老师身份证号码
    private String teacher_idcard;

    /**
     * 无参构造
     */
    public Teacher()
    {
    }

    /**
     * 全参构造
     *
     * @param teacher_no               老师编号
     * @param teacher_name             老师姓名
     * @param teacher_sex              老师性别
     * @param teacher_telephone_number 老师电话号码
     * @param teacher_email            老师电子邮箱
     * @param teacher_address          老师家庭地址
     * @param teacher_idcard           老师身份证号码
     */
    public Teacher(Long teacher_no, String teacher_name, String teacher_sex, String teacher_telephone_number,
                   String teacher_email, String teacher_address, String teacher_idcard)
    {
        if (teacher_no >= 0)
        {
            this.teacher_no = teacher_no;
        }
        else
        {
            this.teacher_no = 0L;
        }
        this.teacher_name = teacher_name;
        this.teacher_sex = teacher_sex;
        this.teacher_telephone_number = teacher_telephone_number;
        this.teacher_email = teacher_email;
        this.teacher_address = teacher_address;
        this.teacher_idcard = teacher_idcard;
    }

    //对应的getter方法和setter方法

    /**
     * Gets teacher no.
     *
     * @return the teacher no
     */
    public Long getTeacher_no()
    {
        return teacher_no;
    }

    /**
     * Sets teacher no.
     *
     * @param teacher_no the teacher no
     */
    public void setTeacher_no(Long teacher_no)
    {
        if (teacher_no >= 0)
        {
            this.teacher_no = teacher_no;
        }
        else
        {
            this.teacher_no = 0L;
        }
    }

    /**
     * Gets teacher name.
     *
     * @return the teacher name
     */
    public String getTeacher_name()
    {
        return teacher_name;
    }

    /**
     * Sets teacher name.
     *
     * @param teacher_name the teacher name
     */
    public void setTeacher_name(String teacher_name)
    {
        this.teacher_name = teacher_name;
    }

    /**
     * Gets teacher sex.
     *
     * @return the teacher sex
     */
    public String getTeacher_sex()
    {
        return teacher_sex;
    }

    /**
     * Sets teacher sex.
     *
     * @param teacher_sex the teacher sex
     */
    public void setTeacher_sex(String teacher_sex)
    {
        this.teacher_sex = teacher_sex;
    }

    /**
     * Gets teacher telephone number.
     *
     * @return the teacher telephone number
     */
    public String getTeacher_telephone_number()
    {
        return teacher_telephone_number;
    }

    /**
     * Sets teacher telephone number.
     *
     * @param teacher_telephone_number the teacher telephone number
     */
    public void setTeacher_telephone_number(String teacher_telephone_number)
    {
        this.teacher_telephone_number = teacher_telephone_number;
    }

    /**
     * Gets teacher email.
     *
     * @return the teacher email
     */
    public String getTeacher_email()
    {
        return teacher_email;
    }

    /**
     * Sets teacher email.
     *
     * @param teacher_email the teacher email
     */
    public void setTeacher_email(String teacher_email)
    {
        this.teacher_email = teacher_email;
    }

    /**
     * Gets teacher address.
     *
     * @return the teacher address
     */
    public String getTeacher_address()
    {
        return teacher_address;
    }

    /**
     * Sets teacher address.
     *
     * @param teacher_address the teacher address
     */
    public void setTeacher_address(String teacher_address)
    {
        this.teacher_address = teacher_address;
    }

    /**
     * Gets teacher idcard.
     *
     * @return the teacher idcard
     */
    public String getTeacher_idcard()
    {
        return teacher_idcard;
    }

    /**
     * Sets teacher idcard.
     *
     * @param teacher_idcard the teacher idcard
     */
    public void setTeacher_idcard(String teacher_idcard)
    {
        this.teacher_idcard = teacher_idcard;
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("teacher_no：").append(teacher_no).append('\t');
        stringbuilder.append("teacher_name：").append(teacher_name).append('\t');
        stringbuilder.append("teacher_sex：").append(teacher_sex).append('\t');
        stringbuilder.append("teacher_telephone_number：").append(teacher_telephone_number).append('\t');
        stringbuilder.append("teacher_email：").append(teacher_email).append('\t');
        stringbuilder.append("teacher_address：").append(teacher_address).append('\t');
        stringbuilder.append("teacher_idcard：").append(teacher_idcard).append('\n');
        return stringbuilder.toString();
    }
}
