package tools.test;

import tools.test.ConnectionAdapter;

import java.sql.SQLException;
import java.util.List;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): tools.test
 * Class(类名): Connection
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/7
 * Time(创建时间)： 22:38
 * Version(版本): 1.0
 * Description(描述)： 此包下的所有类主要用于测试druid连接池、C3P0连接池、自定义连接池适配器设计模式、自定义连接池动态代理方式、不使用数据库连接池这五个之间的性能差距
 * 除了测试，实际上并没有用到此类。测试方法：插入100条学生数据、100条学生密码数据、1200条成绩的时间消耗，精确到微秒。
 */

public class Connection extends ConnectionAdapter
{
    //连接对象
    private final java.sql.Connection connection;
    //连接池
    private final List<java.sql.Connection> pool;

    /**
     * 构造方法对成员变量赋值
     *
     * @param connection 连接对象
     * @param pool       连接池
     */
    public Connection(java.sql.Connection connection, List<java.sql.Connection> pool)
    {
        super(connection);
        this.connection = connection;
        this.pool = pool;
    }

    //重写close方法

    /**
     * 重写close方法 完成归还连接操作
     *
     * @throws SQLException 抛出异常
     */
    @Override
    public void close() throws SQLException
    {
        connection.setAutoCommit(true);     //重新将连接设置为自动提交
        pool.add(connection);               //归还连接
    }
}
