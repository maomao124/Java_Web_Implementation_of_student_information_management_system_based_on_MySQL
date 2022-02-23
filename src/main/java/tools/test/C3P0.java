package tools.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.SQLException;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): tools.test
 * Class(类名): C3P0
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/7
 * Time(创建时间)： 22:53
 * Version(版本): 1.0
 * Description(描述)： 此包下的所有类主要用于测试druid连接池、C3P0连接池、自定义连接池适配器设计模式、自定义连接池动态代理方式、不使用数据库连接池这五个之间的性能差距
 * 除了测试，实际上并没有用到此类。测试方法：插入100条学生数据、100条学生密码数据、1200条成绩的时间消耗，精确到微秒。
 */
public class C3P0
{
    private static final ComboPooledDataSource dataSource = new ComboPooledDataSource();

    /**
     * Gets connection.
     *
     * @return the connection
     */
    public static java.sql.Connection getConnection()
    {
        java.sql.Connection connection = null;
        try
        {
            connection = dataSource.getConnection();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return connection;
    }
}
