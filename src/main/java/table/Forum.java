package table;

import data.LoginLog;
import tools.Handler.BeanListHandler;
import tools.Handler.ScalarHandler;
import tools.JDBCTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(类名): Forum
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 23:13
 * Version(版本): 1.0
 * Description(描述)： 论坛
 */

public class Forum
{
    //格式时间
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
    //页大小,当前为50条一页
    private static final int PageSize = 50;

    /**
     * 私有化构造函数，目的是不让创建对象
     */
    public Forum()
    {
    }

    /**
     * 获得论坛总数量
     *
     * @return 论坛总数量
     */
    public static Long getForumCount()
    {
        //sql语句
        String sql = "select count(forum_no) from forum";
        //参数
        Object[] objects = {};
        //执行sql
        Long result = JDBCTemplate.queryForScalar(sql, new ScalarHandler<>(), objects);
        //返回结果
        return result;
    }

    /**
     * 插入一条论坛信息
     *
     * @param forum_people_no 论坛发布者的学号或职工号，当发布不当言论时，可以通过此消息定位到某个人，不对外显示，和其它表独立
     * @param forum_name      论坛发布者姓名
     * @param forum_identity  论坛发布者身份，学生，老师或者管理员
     * @param forum_content   论坛文字内容，最大长度255字
     * @return 成功，返回true，失败返回false
     */
    public static boolean insert(Long forum_people_no, String forum_name, String forum_identity, String forum_content)
    {
        //获得时间
        Date date = new Date();
        //格式化时间
        String formatDate = simpleDateFormat.format(date);
        //sql语句
        String sql = "INSERT INTO forum (forum.forum_people_no,forum.forum_name,forum.forum_identity,forum.forum_time,forum.forum_content)" +
                " VALUES(?,?,?,?,?)";
        //参数
        Object[] objects = {forum_people_no, forum_name, forum_identity, formatDate, forum_content};
        //执行sql
        int result = JDBCTemplate.update(sql, objects);
        //判断返回值
        if (result > 0)
        {
            return true;
        }
        return false;
    }

    /**
     * 删除一条论坛信息
     *
     * @param forum_no 楼层或者编号
     * @return 成功，返回true，失败返回false
     */
    public static boolean delete(Long forum_no)
    {
        //sql语句
        String sql = "delete from forum where forum_no=?";
        //参数
        Object[] objects = {forum_no};
        //执行sql
        int result = JDBCTemplate.update(sql, objects);
        //判断返回值
        if (result > 0)
        {
            return true;
        }
        return false;
    }

    /**
     * 根据总条数获取页面的总大小，用于分页
     *
     * @param count 总条数
     * @return 页面的总大小
     */
    public static long getPageCount(Long count)
    {
        long PageCount = count % PageSize == 0 ? (count / PageSize) : (count / PageSize + 1);
        //相当于
//        long PageCount = 0;
//        if (count % PageSize == 0)
//        {
//            PageCount = count / PageSize;
//        }
//        else
//        {
//            PageCount = count / PageSize + 1;
//        }
        return PageCount;
    }

    /**
     * 获得当前页的集合
     *
     * @param PageCount 页总数
     * @param currPage  当前页的序号
     * @return List<data.LoginLog>对象
     */
    public static List<data.Forum> getThisPageList(Long PageCount, Long currPage)
    {
        //当前页比总数还大，直接返回
        if (currPage > PageCount)
        {
            return null;
        }
        //sql语句
        String sql = "SELECT * FROM forum order by forum_no desc  LIMIT " + ((currPage - 1) * PageSize) + "," + PageSize;
        //参数
        Object[] objects = {};
        //执行sql
        List<data.Forum> list = JDBCTemplate.queryForList(sql, new BeanListHandler<>(data.Forum.class), objects);
        //返回
        return list;
    }
}
