package io;

import tools.test.JDBC;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): io
 * Class(类名): Configuration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/15
 * Time(创建时间)： 19:17
 * Version(版本): 1.0
 * Description(描述)： 配置文件
 */

public class Configuration
{
    //论坛页面分页大小
    private static int forum_pageSize = 50;
    //登录日志页面分页大小
    private static int login_log_pageSize = 50;
    //新闻列表页面分页大小
    private static int new_pageSize = 50;
    //错误日志文件路径
    private static String Error_path = "error.log";


    static
    {
        InputStream inputStream=null;
        Properties properties;
        try
        {
            //src目录下,maven 资源路径下
            inputStream = Configuration.class.getClassLoader().getResourceAsStream("PageSize.properties");
            properties = new Properties();
            properties.load(inputStream);
            //获取论坛分页大小
            forum_pageSize = Integer.parseInt(properties.getProperty("forum"));
            //获取登录日志分页大小
            login_log_pageSize = Integer.parseInt(properties.getProperty("loginLog"));
            //获取登录日志大小
            new_pageSize = Integer.parseInt(properties.getProperty("new"));
            //清除
            properties.clear();
            //关闭流
            if (inputStream != null)
            {
                inputStream.close();
            }
            //加载错误日志的配置文件
            inputStream = Configuration.class.getClassLoader().getResourceAsStream("ErrorLog.properties");
            //从输入字节流中读取属性列表
            properties.load(inputStream);
            //获取错误日志路径
            Error_path = properties.getProperty("path");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            //关闭
            try
            {
                if (inputStream != null)
                {
                    inputStream.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }


    public static int getForum_pageSize()
    {
        return forum_pageSize;
    }

    public static void setForum_pageSize(int forum_pageSize)
    {
        Configuration.forum_pageSize = forum_pageSize;
    }

    public static int getLogin_log_pageSize()
    {
        return login_log_pageSize;
    }

    public static void setLogin_log_pageSize(int login_log_pageSize)
    {
        Configuration.login_log_pageSize = login_log_pageSize;
    }

    public static int getNew_pageSize()
    {
        return new_pageSize;
    }

    public static void setNew_pageSize(int new_pageSize)
    {
        Configuration.new_pageSize = new_pageSize;
    }

    public static String getError_path()
    {
        return Error_path;
    }

    public static void setError_path(String error_path)
    {
        Error_path = error_path;
    }
}
