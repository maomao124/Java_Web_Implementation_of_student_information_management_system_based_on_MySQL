package tools.test;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): tools.test
 * Class(类名): JDBC
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/7
 * Time(创建时间)： 22:33
 * Version(版本): 1.0
 * Description(描述)： 此包下的所有类主要用于测试druid连接池、C3P0连接池、自定义连接池适配器设计模式、自定义连接池动态代理方式、不使用数据库连接池这五个之间的性能差距
 * 除了测试，实际上并没有用到此类。测试方法：插入100条学生数据、100条学生密码数据、1200条成绩的时间消耗，精确到微秒。
 */


public class JDBC
{

    /*
    config.properties文件内容：

    driverClass=com.mysql.cj.jdbc.Driver
    url=jdbc:mysql://localhost:3306/student1
    username=root
    password=20010713

     */

    @SuppressWarnings("all")
    private static String driverClass;              //驱动程序类
    private static String url;                      //url
    private static String username;                 //用户名
    private static String password;                 //密码

    private JDBC()
    {

    }

    static
    {
        InputStream inputStream;
        Properties properties;
        try
        {
            //src目录下,maven 资源路径下
            inputStream = JDBC.class.getClassLoader().getResourceAsStream("config.properties");
            properties = new Properties();
            properties.load(inputStream);
            driverClass = properties.getProperty("driverClass");      //读取驱动程序类
            url = properties.getProperty("url");                       //读取url
            username = properties.getProperty("username");           //读取用户名
            password = properties.getProperty("password");          //读取密码

            //System.out.println(driverClass);
            //System.out.println(url);
            //System.out.println(username);
            //System.out.println(password);

            //注册驱动
            Class.forName(driverClass);                             //新版
            //旧版：com.mysql.jdbc.Driver
        }
        catch (IOException e)
        {
            Toolkit.getDefaultToolkit().beep();
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("驱动程序类加载失败!");
            System.err.println(e.getMessage());
        }
    }

    //连接方法

    /**
     * 获取数据库连接对象
     *
     * @return Connection对象
     * @throws Exception 获取对象失败时抛出
     */
    public static java.sql.Connection getConnection() throws Exception
    {
        java.sql.Connection connection = null;

        //Loading class `com.mysql.jdbc.Driver'. This is deprecated.
        // The new driver class is `com.mysql.cj.jdbc.Driver'.
        // The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    //关闭方法

    /**
     * 关闭数据库连接  3个对象，用于关闭查询的连接 123
     *
     * @param connection 数据库连接对象
     * @param statement  Statement对象
     * @param resultSet  结果集对象
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet)
    {
        if (resultSet != null)
        {
            try
            {
                resultSet.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if (statement != null)
        {
            try
            {
                statement.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if (connection != null)
        {
            try
            {
                connection.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭数据库连接  3个对象，用于关闭查询的连接 132
     *
     * @param connection 数据库连接对象
     * @param statement  Statement对象
     * @param resultSet  结果集对象
     */
    public static void close(Connection connection, ResultSet resultSet, Statement statement)
    {
        close(connection, statement, resultSet);
    }

    /**
     * 关闭数据库连接  3个对象，用于关闭查询的连接 213
     *
     * @param connection 数据库连接对象
     * @param statement  Statement对象
     * @param resultSet  结果集对象
     */
    public static void close(Statement statement, Connection connection, ResultSet resultSet)
    {
        close(connection, statement, resultSet);
    }

    /**
     * 关闭数据库连接  3个对象，用于关闭查询的连接 231
     *
     * @param connection 数据库连接对象
     * @param statement  Statement对象
     * @param resultSet  结果集对象
     */
    public static void close(Statement statement, ResultSet resultSet, Connection connection)
    {
        close(connection, statement, resultSet);
    }

    /**
     * 关闭数据库连接  3个对象，用于关闭查询的连接 312
     *
     * @param connection 数据库连接对象
     * @param statement  Statement对象
     * @param resultSet  结果集对象
     */
    public static void close(ResultSet resultSet, Connection connection, Statement statement)
    {
        close(connection, statement, resultSet);
    }

    /**
     * 关闭数据库连接  3个对象，用于关闭查询的连接 321
     *
     * @param connection 数据库连接对象
     * @param statement  Statement对象
     * @param resultSet  结果集对象
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection)
    {
        close(connection, statement, resultSet);
    }

    /**
     * 关闭数据库连接  3个对象，用于关闭预编译的查询的连接 123
     *
     * @param connection        数据库连接对象
     * @param preparedStatement PreparedStatement对象
     * @param resultSet         结果集对象
     */
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet)
    {
        if (resultSet != null)
        {
            try
            {
                resultSet.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null)
        {
            try
            {
                preparedStatement.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if (connection != null)
        {
            try
            {
                connection.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭数据库连接  3个对象，用于关闭预编译的查询的连接 132
     *
     * @param connection        数据库连接对象
     * @param preparedStatement PreparedStatement对象
     * @param resultSet         结果集对象
     */
    public static void close(Connection connection, ResultSet resultSet, PreparedStatement preparedStatement)
    {
        close(connection, preparedStatement, resultSet);
    }

    /**
     * 关闭数据库连接  3个对象，用于关闭预编译的查询的连接 213
     *
     * @param connection        数据库连接对象
     * @param preparedStatement PreparedStatement对象
     * @param resultSet         结果集对象
     */
    public static void close(PreparedStatement preparedStatement, Connection connection, ResultSet resultSet)
    {
        close(connection, preparedStatement, resultSet);
    }

    /**
     * 关闭数据库连接  3个对象，用于关闭预编译的查询的连接 231
     *
     * @param connection        数据库连接对象
     * @param preparedStatement PreparedStatement对象
     * @param resultSet         结果集对象
     */
    public static void close(PreparedStatement preparedStatement, ResultSet resultSet, Connection connection)
    {
        close(connection, preparedStatement, resultSet);
    }

    /**
     * 关闭数据库连接  3个对象，用于关闭预编译的查询的连接 312
     *
     * @param connection        数据库连接对象
     * @param preparedStatement PreparedStatement对象
     * @param resultSet         结果集对象
     */
    public static void close(ResultSet resultSet, Connection connection, PreparedStatement preparedStatement)
    {
        close(connection, preparedStatement, resultSet);
    }

    /**
     * 关闭数据库连接  3个对象，用于关闭预编译的查询的连接 321
     *
     * @param connection        数据库连接对象
     * @param preparedStatement PreparedStatement对象
     * @param resultSet         结果集对象
     */
    public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection)
    {
        close(connection, preparedStatement, resultSet);
    }


    /**
     * 关闭数据库连接  2个对象，用于关闭更新的连接 12
     *
     * @param connection 数据库连接对象
     * @param statement  Statement对象
     */
    public static void close(Connection connection, Statement statement)
    {
        if (statement != null)
        {
            try
            {
                statement.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if (connection != null)
        {
            try
            {
                connection.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭数据库连接  2个对象，用于关闭更新的连接 21
     *
     * @param connection 数据库连接对象
     * @param statement  Statement对象
     */
    public static void close(Statement statement, Connection connection)
    {
        close(connection, statement);
    }

    /**
     * 关闭数据库连接  2个对象，用于关闭预编译的更新的连接 12
     *
     * @param connection        数据库连接对象
     * @param preparedStatement PreparedStatement对象
     */
    public static void close(Connection connection, PreparedStatement preparedStatement)
    {
        if (preparedStatement != null)
        {
            try
            {
                preparedStatement.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if (connection != null)
        {
            try
            {
                connection.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭数据库连接  2个对象，用于关闭预编译的更新的连接 21
     *
     * @param connection        数据库连接对象
     * @param preparedStatement PreparedStatement对象
     */
    public static void close(PreparedStatement preparedStatement, Connection connection)
    {
        close(connection, preparedStatement);
    }
}

