package data;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): data
 * Class(类名): News
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 22:17
 * Version(版本): 1.0
 * Description(描述)： 新闻
 */
public class News
{
    //新闻编号
    private Long new_no;
    //新闻发布者(作者)
    private String new_author;
    //新闻发布者身份
    private String new_identity;
    //新闻发布时间，时间由程序填充
    private String new_time;
    //新闻标题
    private String new_title;
    //新闻内容
    private String new_text;

    /**
     * 无参构造
     */
    public News()
    {
    }

    /**
     * 全参构造
     *
     * @param new_no       新闻编号
     * @param new_author   新闻发布者(作者)
     * @param new_identity 新闻发布者身份
     * @param new_time     新闻发布时间，时间由程序填充
     * @param new_title    新闻标题
     * @param new_text     新闻内容
     */
    public News(Long new_no, String new_author, String new_identity, String new_time, String new_title, String new_text)
    {
        if (new_no >= 0)
        {
            this.new_no = new_no;
        }
        else
        {
            this.new_no = 0L;
        }
        this.new_author = new_author;
        this.new_identity = new_identity;
        this.new_time = new_time;
        this.new_title = new_title;
        this.new_text = new_text;
    }

    //对应的getter方法和setter方法

    /**
     * Gets new no.
     *
     * @return the new no
     */
    public Long getNew_no()
    {
        return new_no;
    }

    /**
     * Sets new no.
     *
     * @param new_no the new no
     */
    public void setNew_no(Long new_no)
    {
        if (new_no >= 0)
        {
            this.new_no = new_no;
        }
        else
        {
            this.new_no = 0L;
        }
    }

    /**
     * Gets new author.
     *
     * @return the new author
     */
    public String getNew_author()
    {
        return new_author;
    }

    /**
     * Sets new author.
     *
     * @param new_author the new author
     */
    public void setNew_author(String new_author)
    {
        this.new_author = new_author;
    }

    /**
     * Gets new identity.
     *
     * @return the new identity
     */
    public String getNew_identity()
    {
        return new_identity;
    }

    /**
     * Sets new identity.
     *
     * @param new_identity the new identity
     */
    public void setNew_identity(String new_identity)
    {
        this.new_identity = new_identity;
    }

    /**
     * Gets new time.
     *
     * @return the new time
     */
    public String getNew_time()
    {
        return new_time;
    }

    /**
     * Sets new time.
     *
     * @param new_time the new time
     */
    public void setNew_time(String new_time)
    {
        this.new_time = new_time;
    }

    /**
     * Gets new title.
     *
     * @return the new title
     */
    public String getNew_title()
    {
        return new_title;
    }

    /**
     * Sets new title.
     *
     * @param new_title the new title
     */
    public void setNew_title(String new_title)
    {
        this.new_title = new_title;
    }

    /**
     * Gets new text.
     *
     * @return the new text
     */
    public String getNew_text()
    {
        return new_text;
    }

    /**
     * Sets new text.
     *
     * @param new_text the new text
     */
    public void setNew_text(String new_text)
    {
        this.new_text = new_text;
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
        stringbuilder.append("new_no：").append(new_no).append('\t');
        stringbuilder.append("new_author：").append(new_author).append('\t');
        stringbuilder.append("new_identity：").append(new_identity).append('\t');
        stringbuilder.append("new_time：").append(new_time).append('\t');
        stringbuilder.append("new_title：").append(new_title).append('\t');
        stringbuilder.append("new_text：").append(new_text).append('\n');
        return stringbuilder.toString();
    }
}
