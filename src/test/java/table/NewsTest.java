package table;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(测试类名): NewsTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/1
 * Time(创建时间)： 21:18
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */
class NewsTest
{

    /**
     * Gets news.
     */
    @Test
    void getNews()
    {
        data.News news = News.getNews(200L);
        System.out.println(news);
    }

    @Test
    void getNewsCount()
    {
        Long newsCount = News.getNewsCount();
        System.out.println(newsCount);
    }

    /**
     * Insert.
     */
    @Test
    void insert()
    {
        boolean insert = News.insert("张三", "校长", "学校2020年总结", "正文");
        System.out.println(insert);
    }

    /**
     * Gets news list.
     */
    @Test
    void getNewsList()
    {
        List<data.News> list = News.getNewsList();
        for (data.News news : list)
        {
            System.out.print(news);
        }
    }

    /**
     * Gets new.
     */
    @Test
    void getNew()
    {
        data.News news = News.getNew(1L);
        System.out.println(news);
    }

    /**
     * Delete.
     */
    @Test
    void delete()
    {
        boolean result = News.delete(7L);
        System.out.println(result);
    }

    /**
     * Gets page count.
     */
    @Test
    void getPageCount()
    {
        long pageCount = News.getPageCount(News.getNewsCount());
        System.out.println(pageCount);
    }

    /**
     * Gets this page list.
     */
    @Test
    void getThisPageList()
    {
        long pageCount = News.getPageCount(News.getNewsCount());
        List<data.News> thisPageList = News.getThisPageList(pageCount, 2L);
        System.out.println(thisPageList);
    }
}