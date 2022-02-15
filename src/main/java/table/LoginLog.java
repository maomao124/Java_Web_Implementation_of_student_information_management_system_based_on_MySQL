package table;

import tools.Handler.BeanListHandler;
import tools.Handler.ScalarHandler;
import tools.JDBCTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(类名): LoginLog
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/2
 * Time(创建时间)： 20:19
 * Version(版本): 1.0
 * Description(描述)： 登录日志表,不提供修改和删除功能
 */

public class LoginLog
{
    //格式时间
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
    //页大小,默认为100条一页
    private static final int PageSize;

    static
    {
        //加载分页大小
        PageSize = io.Configuration.getLogin_log_pageSize();
    }

    /**
     * 私有化构造函数，目的是不让创建对象
     */
    public LoginLog()
    {
    }

    /**
     * 获得登录日志列表，不推荐使用，因为太多，推荐使用分页的方法
     *
     * @return List<data.LoginLog>对象
     */
    public static List<data.LoginLog> getLogList()
    {
        //sql语句
        String sql = "select * from login_log order by log_no desc";
        //参数，无
        Object[] objects = {};
        //执行sql
        List<data.LoginLog> loginLogs = JDBCTemplate.queryForList(sql, new BeanListHandler<>(data.LoginLog.class), objects);
        //返回参数
        return loginLogs;
    }


    /**
     * 获得某个人的登录日志
     *
     * @param log_login_no 登录人的学号或者编号
     * @return List<data.LoginLog>对象
     */
    public static List<data.LoginLog> getPeopleLogList(Long log_login_no)
    {
        //sql语句
        String sql = "select * from login_log where log_login_no=? order by log_no desc";
        //参数
        Object[] objects = {log_login_no};
        //执行sql
        List<data.LoginLog> loginLogs = JDBCTemplate.queryForList(sql, new BeanListHandler<>(data.LoginLog.class), objects);
        //返回参数
        return loginLogs;
    }

    /**
     * 获得日志总数量
     *
     * @return 日志总数量
     */
    public static Long getLogCount()
    {
        //sql语句
        String sql = "select count(log_no) from login_log";
        //参数
        Object[] objects = {};
        //执行sql
        Long result = JDBCTemplate.queryForScalar(sql, new ScalarHandler<>(), objects);
        //返回结果
        return result;
    }

    /**
     * 插入一条日志，时间和编号由程序填充
     *
     * @param log_login_no 登录人的学号或者编号
     * @param log_name     登录人的姓名
     * @return 成功，返回true，失败返回false
     */
    public static boolean insert(Long log_login_no, String log_name)
    {
        //获得时间
        Date date = new Date();
        //获得格式化的时间
        String dateformat = simpleDateFormat.format(date);
        //sql语句
        String sql = "insert into login_log (log_time,log_login_no,log_name) values(?,?,?)";
        //参数
        Object[] objects = {dateformat, log_login_no, log_name};
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
    public static List<data.LoginLog> getThisPageList(Long PageCount, Long currPage)
    {
        //当前页比总数还大，直接返回
        if (currPage > PageCount)
        {
            return null;
        }
        //反转当前页，目的是排序
        //long reversePage = PageCount - currPage;
        //sql语句
        //String sql = "SELECT * FROM login_log  LIMIT " + (reversePage * PageSize) + "," + PageSize;
        //sql语句
        String sql = "SELECT * FROM login_log order by log_no desc  LIMIT " + ((currPage - 1) * PageSize) + "," + PageSize;
        //参数
        Object[] objects = {};
        //执行sql
        List<data.LoginLog> list = JDBCTemplate.queryForList(sql, new BeanListHandler<>(data.LoginLog.class), objects);
        //返回
        return list;
    }
}
