package table;

import tools.Handler.BeanHandler;
import tools.Handler.ScalarHandler;
import tools.JDBCTemplate;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(类名): News
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 23:13
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class News
{
    /**
     * 私有化构造函数，不能创建对象
     */
    private News()
    {
    }

    /**
     * 查询新闻
     *
     * @param new_no 新闻编号
     * @return data.News对象
     */
    public static data.News getNews(Long new_no)
    {
        //sql语句
        String sql = "SELECT * FROM news WHERE new_no=?";
        //参数
        Object[] objects = {new_no};
        //查询
        data.News news = JDBCTemplate.queryForObject(sql, new BeanHandler<>(data.News.class), objects);
        //返回
        if (news.getNew_no() == null)
        {
            //新闻编号为空，返回null
            return null;
        }
        return news;
    }

    /**
     * 获得新闻的总数量
     *
     * @return 总条数
     */
    public static Long getNewsCount()
    {
        //sql语句
        String sql = "SELECT COUNT(new_no) FROM news";
        //查询
        Long news_count = JDBCTemplate.queryForScalar(sql, new ScalarHandler<>());
        //返回
        return news_count;
    }


}
