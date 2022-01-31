package data;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): data
 * Class(类名): TeacherPassword
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 22:50
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class TeacherPassword
{
    //老师编号
    private Long teacher_no;
    //老师登录密码
    private String teacher_password;

    /**
     * 无参构造
     */
    public TeacherPassword()
    {
    }

    /**
     * 全参构造
     *
     * @param teacher_no       老师编号
     * @param teacher_password 老师登录密码
     */
    public TeacherPassword(Long teacher_no, String teacher_password)
    {
        if (teacher_no >= 0)
        {
            this.teacher_no = teacher_no;
        }
        else
        {
            this.teacher_no = 0L;
        }
        this.teacher_password = teacher_password;
    }

    //对应的getter方法和setter方法

    public Long getTeacher_no()
    {
        return teacher_no;
    }

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

    public String getTeacher_password()
    {
        return teacher_password;
    }

    public void setTeacher_password(String teacher_password)
    {
        this.teacher_password = teacher_password;
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
        stringbuilder.append("teacher_no：").append(teacher_no).append('\t');
        stringbuilder.append("teacher_password：").append(teacher_password).append('\n');
        return stringbuilder.toString();
    }
}
