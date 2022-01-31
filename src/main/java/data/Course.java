package data;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): data
 * Class(类名): Course
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 22:01
 * Version(版本): 1.0
 * Description(描述)： 课程
 */

public class Course
{
    //课程编号
    private Long course_no;
    //课程名称
    private String course_name;
    //课程学分
    private Float course_credit;
    //课程学时
    private Integer course_hour;
    //方式，考试或者考察
    private String course_mode;

    /**
     * 无参构造
     */
    public Course()
    {
    }

    /**
     * 全参构造
     *
     * @param course_no     课程编号
     * @param course_name   课程名称
     * @param course_credit 课程学分
     * @param course_hour   课程学时
     * @param course_mode   方式，考试或者考察
     */
    public Course(Long course_no, String course_name, Float course_credit, Integer course_hour, String course_mode)
    {
        if (course_no >= 0)
        {
            this.course_no = course_no;
        }
        else
        {
            this.course_no = 0L;
        }
        this.course_name = course_name;
        if (course_credit >= 0)
        {
            this.course_credit = course_credit;
        }
        else
        {
            this.course_credit = 0f;
        }
        if (course_hour >= 0)
        {
            this.course_hour = course_hour;
        }
        else
        {
            this.course_hour = 0;
        }
        this.course_mode = course_mode;
    }

    //对应的getter方法和setter方法

    public Long getCourse_no()
    {
        return course_no;
    }

    public void setCourse_no(Long course_no)
    {
        if (course_no >= 0)
        {
            this.course_no = course_no;
        }
        else
        {
            this.course_no = 0L;
        }
    }

    public Float getCourse_credit()
    {
        return course_credit;
    }

    public void setCourse_credit(Float course_credit)
    {
        if (course_credit >= 0)
        {
            this.course_credit = course_credit;
        }
        else
        {
            this.course_credit = 0f;
        }
    }

    public Integer getCourse_hour()
    {
        return course_hour;
    }

    public void setCourse_hour(Integer course_hour)
    {
        if (course_hour >= 0)
        {
            this.course_hour = course_hour;
        }
        else
        {
            this.course_hour = 0;
        }
    }

    public String getCourse_name()
    {
        return course_name;
    }

    public void setCourse_name(String course_name)
    {
        this.course_name = course_name;
    }

    public String getCourse_mode()
    {
        return course_mode;
    }

    public void setCourse_mode(String course_mode)
    {
        this.course_mode = course_mode;
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
        stringbuilder.append("course_no：").append(course_no).append('\t');
        stringbuilder.append("course_name：").append(course_name).append('\t');
        stringbuilder.append("course_credit：").append(course_credit).append('\t');
        stringbuilder.append("course_hour：").append(course_hour).append('\t');
        stringbuilder.append("course_mode：").append(course_mode).append('\n');
        return stringbuilder.toString();
    }
}
