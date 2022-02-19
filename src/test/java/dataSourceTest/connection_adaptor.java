package dataSourceTest;

import data.Administrators;
import org.junit.jupiter.api.Test;
import tools.Druid;
import tools.Handler.BeanHandler;
import tools.Handler.ResultSetHandler;
import tools.test.ConnectionPool;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): dataSourceTest
 * Class(类名): connection_adaptor
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/19
 * Time(创建时间)： 21:16
 * Version(版本): 1.0
 * Description(描述)： 自定义数据库连接池适配器设计模式
 * 结果：
 * 1000次查询：662毫秒；
 * 10000次查询：3441毫秒
 */

public class connection_adaptor
{
    private static final ConnectionPool connectionPool = new ConnectionPool();

    /**
     * 查询方法，此方法用于将一条记录封装成一个自定义对象并返回，如果resultSetHandler中参数传人的是Student.class,
     * 则返回的是一个Student类的对象
     *
     * @param sql              sql查询语句，建议通过主键查找，如果查询的sql语句有多条记录，则返回第一条记录
     *                         sql语句实例：select * from table where primaryKey=?
     * @param resultSetHandler ResultSetHandler<T>对象，使用：new BeanHandler<>(自定义对象.class)
     * @param objs             sql中的问号占位符，数量和顺序一定要一致
     * @param <T>              泛型，自定义对象
     * @return 返回自定义对象
     */
    public static <T> T queryForObject(String sql, ResultSetHandler<T> resultSetHandler, Object... objs)
    {
        //定义泛型变量
        T object = null;
        //连接对象
        Connection connection = null;
        //预编译执行者对象
        PreparedStatement preparedStatement = null;
        //结果集对象
        ResultSet resultSet = null;
        try
        {
            //获取连接对象(Druid连接池)
            //connection = Druid.getConnection();
            //或者(自定义数据库连接池)：
            connection = connectionPool.getConnection();
            //或者直接获取(自定义JDBC工具类)：
            //connection = JDBC.getConnection();

            //预编译sql，返回执行者对象
            preparedStatement = connection.prepareStatement(sql);
            //获取参数的源信息对象
            ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
            //获取参数个数
            int count = parameterMetaData.getParameterCount();
            //判断参数是否一致，如果不一致，异常抛出
            if (objs.length != count)
            {
                throw new RuntimeException("queryForObject方法中参数个数不一致!");
            }
            //为问号占位符赋值
            for (int i = 0; i < count; i++)
            {
                preparedStatement.setObject(i + 1, objs[i]);
            }
            //执行sql语句,返回结果集
            resultSet = preparedStatement.executeQuery();
            //通过beanHandler类中的handler方法对结果集进行处理
            object = resultSetHandler.handler(resultSet);
        }
        catch (Exception e)
        {
            e.printStackTrace();
//            final Writer writer = new StringWriter();
//            final PrintWriter printWriter = new PrintWriter(writer);
//            e.printStackTrace(printWriter);
//            String stackTraceStr = writer.toString();
//            ErrorLog.write(stackTraceStr);
        }
        finally
        {
            //释放资源
            Druid.close(connection, preparedStatement, resultSet);
            //或者：
            //JDBC.close(connection, preparedStatement);
        }
        //返回结果
        return object;
    }

    public static data.Administrators select()
    {
        //sql语句
        String sql = "select * from administrators where administrator_no=10001";
        //查询
        Administrators administrator = queryForObject(sql, new BeanHandler<>(Administrators.class));
        //返回
        if (administrator.getAdministrator_idcard() == null)
        {
            return null;
        }
        return administrator;
    }

    @Test
    void start()
    {

        //查询一次，启动
        Administrators result = select();
        if (result == null)
        {
            throw new RuntimeException("异常");
        }
        //开始计时
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        for (int i = 0; i < 10000; i++)
        {
            select();
        }
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
    }
}
