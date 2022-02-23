package data;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): data
 * Class(类名): Teach
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 22:35
 * Version(版本): 1.0
 * Description(描述)： 教
 */
public class Teach
{
    //编号
    private Long teach_no;
    //老师编号
    private Long teacher_no;
    //老师所教的班级编号
    private Long class_no;
    //老师所教的课程编号
    private Long course_no;
    //学期,比如：2019年下学期
    private String semester;

    /**
     * 无参构造
     */
    public Teach()
    {
    }

    /**
     * 全参构造
     *
     * @param teach_no   编号
     * @param teacher_no 老师编号
     * @param class_no   老师所教的班级编号
     * @param course_no  the course no
     * @param semester   学期,比如：2019年下学期
     */
    public Teach(Long teach_no, Long teacher_no, Long class_no, Long course_no, String semester)
    {
        if (teach_no >= 0)
        {
            this.teach_no = teach_no;
        }
        else
        {
            this.teach_no = 0L;
        }
        if (teacher_no >= 0)
        {
            this.teacher_no = teacher_no;
        }
        else
        {
            this.teacher_no = 0L;
        }
        if (class_no >= 0)
        {
            this.class_no = class_no;
        }
        else
        {
            this.class_no = 0L;
        }
        if (course_no >= 0)
        {
            this.course_no = course_no;
        }
        else
        {
            this.course_no = 0L;
        }
        this.semester = semester;
    }

    //对应的getter方法和setter方法

    /**
     * Gets teach no.
     *
     * @return the teach no
     */
    public Long getTeach_no()
    {
        return teach_no;
    }

    /**
     * Sets teach no.
     *
     * @param teach_no the teach no
     */
    public void setTeach_no(Long teach_no)
    {
        if (teach_no >= 0)
        {
            this.teach_no = teach_no;
        }
        else
        {
            this.teach_no = 0L;
        }
    }

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
     * Gets class no.
     *
     * @return the class no
     */
    public Long getClass_no()
    {
        return class_no;
    }

    /**
     * Sets class no.
     *
     * @param class_no the class no
     */
    public void setClass_no(Long class_no)
    {
        if (class_no >= 0)
        {
            this.class_no = class_no;
        }
        else
        {
            this.class_no = 0L;
        }
    }

    /**
     * Gets course no.
     *
     * @return the course no
     */
    public Long getCourse_no()
    {
        return course_no;
    }

    /**
     * Sets course no.
     *
     * @param course_no the course no
     */
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

    /**
     * Gets semester.
     *
     * @return the semester
     */
    public String getSemester()
    {
        return semester;
    }

    /**
     * Sets semester.
     *
     * @param semester the semester
     */
    public void setSemester(String semester)
    {
        this.semester = semester;
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
        stringbuilder.append("teach_no：").append(teach_no).append('\t');
        stringbuilder.append("teacher_no：").append(teacher_no).append('\t');
        stringbuilder.append("class_no：").append(class_no).append('\t');
        stringbuilder.append("course_no：").append(course_no).append('\t');
        stringbuilder.append("semester：").append(semester).append('\n');
        return stringbuilder.toString();
    }
}
