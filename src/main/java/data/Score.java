package data;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): data
 * Class(类名): Score
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 22:23
 * Version(版本): 1.0
 * Description(描述)： 分数
 */

public class Score
{
    //学生学号
    private Long no;
    //课程编号
    private Long course_no;
    //平时成绩
    private Float usual_score;
    //期末成绩
    private Float end_score;
    //最终分数
    private Float final_score;
    //绩点
    private Float grade_point;
    //学期
    private String semester;

    /**
     * 无参构造
     */
    public Score()
    {
    }

    /**
     * 全参构造
     *
     * @param no          学生学号
     * @param course_no   课程编号
     * @param usual_score 平时成绩
     * @param end_score   期末成绩
     * @param final_score 最终分数
     * @param grade_point 绩点
     * @param semester    学期
     */
    public Score(Long no, Long course_no, Float usual_score, Float end_score, Float final_score, Float grade_point, String semester)
    {
        if (no >= 0)
        {
            this.no = no;
        }
        else
        {
            this.no = 0L;
        }
        if (course_no >= 0)
        {
            this.course_no = course_no;
        }
        else
        {
            this.course_no = 0L;
        }
        if (usual_score >= 0)
        {
            this.usual_score = usual_score;
        }
        else
        {
            this.usual_score = 0f;
        }
        if (end_score >= 0)
        {
            this.end_score = end_score;
        }
        else
        {
            this.end_score = 0f;
        }
        if (final_score >= 0)
        {
            this.final_score = final_score;
        }
        else
        {
            this.final_score = 0f;
        }
        if (grade_point >= 0)
        {
            this.grade_point = grade_point;
        }
        else
        {
            this.grade_point = 0f;
        }
        this.semester = semester;
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

    public Float getUsual_score()
    {
        return usual_score;
    }

    public void setUsual_score(Float usual_score)
    {
        if (usual_score >= 0)
        {
            this.usual_score = usual_score;
        }
        else
        {
            this.usual_score = 0f;
        }
    }

    public Float getEnd_score()
    {
        return end_score;
    }

    public void setEnd_score(Float end_score)
    {
        if (end_score >= 0)
        {
            this.end_score = end_score;
        }
        else
        {
            this.end_score = 0f;
        }
    }

    public Float getFinal_score()
    {
        return final_score;
    }

    public void setFinal_score(Float final_score)
    {
        if (final_score >= 0)
        {
            this.final_score = final_score;
        }
        else
        {
            this.final_score = 0f;
        }
    }

    public Float getGrade_point()
    {
        return grade_point;
    }

    public void setGrade_point(Float grade_point)
    {
        if (grade_point >= 0)
        {
            this.grade_point = grade_point;
        }
        else
        {
            this.grade_point = 0f;
        }
    }

    public String getSemester()
    {
        return semester;
    }

    public void setSemester(String semester)
    {
        this.semester = semester;
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("no：").append(no).append('\t');
        stringbuilder.append("course_no：").append(course_no).append('\t');
        stringbuilder.append("usual_score：").append(usual_score).append('\t');
        stringbuilder.append("end_score：").append(end_score).append('\t');
        stringbuilder.append("final_score：").append(final_score).append('\t');
        stringbuilder.append("grade_point：").append(grade_point).append('\t');
        stringbuilder.append("semester：").append(semester).append('\n');
        return stringbuilder.toString();
    }
}
