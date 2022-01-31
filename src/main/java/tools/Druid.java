package tools;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): tools
 * Class(类名): Druid
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 22:57
 * Version(版本): 1.0
 * Description(描述)： Druid连接池
 */


public class Druid
{
    /*
    druid.properties文件：

    #可以缺省，会根据url自动识别
    driverClassName=com.mysql.cj.jdbc.Driver
    url=jdbc:mysql://localhost:3306/student1
    username=root
    password=20010713

    ##初始连接数，默认0
    initialSize=10
    #最大连接数，默认8
    maxActive=30
    #最小闲置数
    minIdle=10
    #获取连接的最大等待时间，单位毫秒
    maxWait=3000
    #缓存PreparedStatement，默认false
    poolPreparedStatements=true
    #缓存PreparedStatement的最大数量，默认-1（不缓存）。大于0时会自动开启缓存PreparedStatement，所以可以省略上一句设置
    maxOpenPreparedStatements=20


     */

    //数据源变量
    private static DataSource dataSource;

    static
    {
        try
        {
            //加载配置文件
            InputStream inputStream = Druid.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            //获取数据库连接对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 私有化构造函数，不能创建对象
     */
    private Druid()
    {

    }

    /**
     * 获得一个连接对象，从Druid连接池内
     *
     * @return Connection对象, 如果获取失败，则返回null
     */
    public static Connection getConnection()
    {
        Connection connection = null;
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

    /**
     * 获取数据库连接池对象
     *
     * @return 返回DataSource对象
     */
    public static DataSource getDataSource()
    {
        return dataSource;
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

    /**
     * 关闭连接对象
     *
     * @param connection 连接对象
     */
    public static void close(Connection connection)
    {
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
     * 关闭预编译执行者对象
     *
     * @param preparedStatement 预编译执行者对象
     */
    public static void close(PreparedStatement preparedStatement)
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
    }
}

