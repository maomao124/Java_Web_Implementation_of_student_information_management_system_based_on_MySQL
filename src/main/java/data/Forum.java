package data;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): data
 * Class(类名): Forum
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 22:07
 * Version(版本): 1.0
 * Description(描述)： 论坛
 */

public class Forum
{
    //论坛编号，楼层
    private Long forum_no;
    //论坛发布者的学号或职工号，当发布不当言论时，可以通过此消息定位到某个人，不对外显示，和其它表独立
    private Long forum_people_no;
    //论坛发布者姓名
    private String forum_name;
    //论坛发布者身份，学生，老师或者管理员
    private String forum_identity;
    //论坛发布时间，这里用程序填充时间
    private String forum_time;
    //论坛文字内容，最大长度255字
    private String forum_content;

    /**
     * 无参构造
     */
    public Forum()
    {
    }

    /**
     * 全参构造
     *
     * @param forum_no        论坛编号，楼层
     * @param forum_people_no 论坛发布者的学号或职工号，当发布不当言论时，可以通过此消息定位到某个人，不对外显示，和其它表独立
     * @param forum_name      论坛发布者姓名
     * @param forum_identity  论坛发布者身份，学生，老师或者管理员
     * @param forum_time      论坛发布时间，这里用程序填充时间
     * @param forum_content   论坛文字内容，最大长度255字
     */
    public Forum(Long forum_no, Long forum_people_no, String forum_name, String forum_identity, String forum_time, String forum_content)
    {
        if (forum_no >= 0)
        {
            this.forum_no = forum_no;
        }
        else
        {
            this.forum_no = 0L;
        }
        if (forum_people_no >= 0)
        {
            this.forum_people_no = forum_people_no;
        }
        else
        {
            this.forum_people_no = 0L;
        }
        this.forum_name = forum_name;
        this.forum_identity = forum_identity;
        this.forum_time = forum_time;
        this.forum_content = forum_content;
    }

    public Long getForum_no()
    {
        return forum_no;
    }

    public void setForum_no(Long forum_no)
    {
        if (forum_no >= 0)
        {
            this.forum_no = forum_no;
        }
        else
        {
            this.forum_no = 0L;
        }
    }

    public Long getForum_people_no()
    {
        return forum_people_no;
    }

    public void setForum_people_no(Long forum_people_no)
    {
        if (forum_people_no >= 0)
        {
            this.forum_people_no = forum_people_no;
        }
        else
        {
            this.forum_people_no = 0L;
        }
    }

    public String getForum_name()
    {
        return forum_name;
    }

    public void setForum_name(String forum_name)
    {
        this.forum_name = forum_name;
    }

    public String getForum_identity()
    {
        return forum_identity;
    }

    public void setForum_identity(String forum_identity)
    {
        this.forum_identity = forum_identity;
    }

    public String getForum_time()
    {
        return forum_time;
    }

    public void setForum_time(String forum_time)
    {
        this.forum_time = forum_time;
    }

    public String getForum_content()
    {
        return forum_content;
    }

    public void setForum_content(String forum_content)
    {
        this.forum_content = forum_content;
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
        stringbuilder.append("forum_no：").append(forum_no).append('\t');
        stringbuilder.append("forum_people_no：").append(forum_people_no).append('\t');
        stringbuilder.append("forum_name：").append(forum_name).append('\t');
        stringbuilder.append("forum_identity：").append(forum_identity).append('\t');
        stringbuilder.append("forum_time：").append(forum_time).append('\t');
        stringbuilder.append("forum_content：").append(forum_content).append('\t');
        return stringbuilder.toString();
    }
}
