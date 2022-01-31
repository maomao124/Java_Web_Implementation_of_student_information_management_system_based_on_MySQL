package tools;

import tools.Handler.ResultSetHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): tools
 * Class(类名): JDBCTemples
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 23:06
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class JDBCTemplate
{
    /**
     * 私有化构造函数，不能创建对象
     */
    private JDBCTemplate()
    {

    }

    /**
     * JDBC框架 update方法
     *
     * @param sql  sql更新语句,执行此PreparedStatement对象中的SQL语句，该语句必须是SQL数据操作语言(DML)语句，
     *             例如INSERT、UPDATE或DELETE；或不返回任何内容的SQL语句，例如DDL语句。
     * @param objs sql中的问号占位符，数量和顺序一定要一致
     * @return 影响行数
     */
    public static int update(String sql, Object... objs)
    {
        //影响行数,初始值为0
        int result = 0;
        //连接对象
        Connection connection = null;
        //预编译执行者对象
        PreparedStatement preparedStatement = null;
        try
        {
            //获取连接对象(Druid连接池)
            connection = Druid.getConnection();
            //或者(自定义数据库连接池)：
            //connection = connectionPool.getConnection();
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
                throw new RuntimeException("update方法中参数个数不一致!");
            }
            //为问号占位符赋值
            for (int i = 0; i < count; i++)
            {
                preparedStatement.setObject(i + 1, objs[i]);
            }
            //执行sql语句
            result = preparedStatement.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            //释放资源
            Druid.close(connection, preparedStatement);
            //或者：
            //JDBC.close(connection, preparedStatement);
        }
        //返回结果
        return result;
    }


    /**
     * JDBC框架 update方法 用于开启事务处理，私有
     *
     * @param connection 关闭自动提交的连接对象
     * @param sql        sql更新语句,执行此PreparedStatement对象中的SQL语句，该语句必须是SQL数据操作语言(DML)语句，
     *                   例如INSERT、UPDATE或DELETE；或不返回任何内容的SQL语句，例如DDL语句。
     * @param objs       sql中的问号占位符，数量和顺序一定要一致
     * @return 影响行数
     * @throws Exception 所有异常抛出
     */
    private static int update(Connection connection, String sql, Object... objs) throws Exception
    {
        //影响行数,初始值为0
        int result = 0;
        //预编译执行者对象
        PreparedStatement preparedStatement = null;
        try
        {
            //预编译sql，返回执行者对象
            preparedStatement = connection.prepareStatement(sql);
            //获取参数的源信息对象
            ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
            //获取参数个数
            int count = parameterMetaData.getParameterCount();
            //判断参数是否一致，如果不一致，异常抛出
            if (objs.length != count)
            {
                throw new Exception("update方法中参数个数不一致!");
            }
            //为问号占位符赋值
            for (int i = 0; i < count; i++)
            {
                preparedStatement.setObject(i + 1, objs[i]);
            }
            //执行sql语句
            result = preparedStatement.executeUpdate();
        }
        finally
        {
            //释放资源
            Druid.close(preparedStatement);
            //或者：
            //JDBC.close(preparedStatement);
        }
        //返回结果
        return result;
    }


    /**
     * JDBC框架 update方法 用于开启事务处理
     *
     * @param sql  通用的sql更新语句
     * @param objs Object[]... objs，二维数组，根据此二维数组的行长度来判断执行sql更新语句的次数
     *             注意：二维数组的每一列的长度必须要和sql语句的问号占位符的数量要一致
     * @return 影响行数，如果成功，则返回二维数组行长度，失败则返回0
     */
    public static int update(String sql, Object[]... objs)
    {
        int result1 = 0;
        //连接对象
        Connection connection = null;
        //获取连接对象(Druid连接池)
        connection = Druid.getConnection();
        //或者(自定义数据库连接池)：
        //connection = connectionPool.getConnection();
        //或者直接获取(自定义JDBC工具类)：
        //connection = JDBC.getConnection();
        try
        {
            //关闭自动提交
            connection.setAutoCommit(false);
            for (int i = 0; i < objs.length; i++)
            {
                //单独使用
                int result = update(connection, sql, objs[i]);
                if (result == 0)
                {
                    //处理某一条数据的时候出现问题，抛出
                    throw new Exception("处理第" + (i + 1) + "条sql语句时失败(影响行数为0)");
                }
            }
            //提交事务
            connection.commit();
            result1 = objs.length;
        }
        catch (Exception e)
        {
            try
            {
                //回滚事务
                System.out.println("回滚事务");
                connection.rollback();
            }
            catch (SQLException ex)
            {
                System.out.println("回滚失败！");
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //重新设置成自动提交，因为要归还连接而不是关闭连接
                connection.setAutoCommit(true);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            //归还连接
            Druid.close(connection);
        }
        return result1;
    }


    /**
     * JDBC框架 update方法 用于开启事务处理
     *
     * @param sql  sql语句数组，此数组的长度一定要和objs参数的行长度一定要一致，不然会失败
     * @param objs Object[]... objs，二维数组，根据此二维数组的行长度来判断执行sql更新语句的次数
     *             注意：二维数组的每一列的长度必须要和对应的sql语句的对应的问号占位符的数量要一致
     * @return 影响行数，如果成功，则返回二维数组行长度，失败则返回0
     */
    public static int update(String[] sql, Object[]... objs)
    {
        int result1 = 0;
        //连接对象
        Connection connection = null;
        //获取连接对象(Druid连接池)
        connection = Druid.getConnection();
        //或者(自定义数据库连接池)：
        //connection = connectionPool.getConnection();
        //或者直接获取(自定义JDBC工具类)：
        //connection = JDBC.getConnection();
        try
        {
            //判断sql语句数组的长度和传入的二维数组的行长度是否一致
            if (sql.length != objs.length)
            {
                throw new Exception("update方法中sql数组参数个数和objs二维数组的行长度不一致!");
            }
            //关闭自动提交
            connection.setAutoCommit(false);
            for (int i = 0; i < objs.length; i++)
            {
                //单独使用
                int result = update(connection, sql[i], objs[i]);
                if (result == 0)
                {
                    //处理某一条数据的时候出现问题，抛出
                    throw new Exception("处理第" + (i + 1) + "条sql语句时失败(影响行数为0)");
                }
            }
            //提交事务
            connection.commit();
            result1 = objs.length;
        }
        catch (Exception e)
        {
            try
            {
                //回滚事务
                System.out.println("回滚事务");
                connection.rollback();
            }
            catch (SQLException ex)
            {
                System.out.println("回滚失败！");
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //重新设置成自动提交，因为要归还连接而不是关闭连接
                connection.setAutoCommit(true);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            //归还连接
            Druid.close(connection);
        }
        return result1;
    }


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
            connection = Druid.getConnection();
            //或者(自定义数据库连接池)：
            //connection = connectionPool.getConnection();
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


    /**
     * 查询方法，此方法用于将多条记录封装成一个集合对象并返回，如果resultSetHandler中参数传人的是Student.class,
     * 则返回的是一个装有Student类的对象的List集合
     *
     * @param sql              sql查询语句，sql语句实例：select * from table
     * @param resultSetHandler ResultSetHandler<T>对象，使用：new BeanListHandler<>(自定义对象.class)
     * @param objs             sql中的问号占位符，数量和顺序一定要一致
     * @param <T>              泛型，自定义对象
     * @return List集合
     */
    public static <T> List<T> queryForList(String sql, ResultSetHandler<T> resultSetHandler, Object... objs)
    {
        //定义泛型集合
        List<T> list = new ArrayList<>();
        //连接对象
        Connection connection = null;
        //预编译执行者对象
        PreparedStatement preparedStatement = null;
        //结果集对象
        ResultSet resultSet = null;
        try
        {
            //获取连接对象(Druid连接池)
            connection = Druid.getConnection();
            //或者(自定义数据库连接池)：
            //connection = connectionPool.getConnection();
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
                throw new RuntimeException("queryForList方法中参数个数不一致!");
            }
            //为问号占位符赋值
            for (int i = 0; i < count; i++)
            {
                preparedStatement.setObject(i + 1, objs[i]);
            }
            //执行sql语句,返回结果集
            resultSet = preparedStatement.executeQuery();
            //通过BeanListHandler类中的handler方法对结果集进行处理
            list = resultSetHandler.handler(resultSet);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            //释放资源
            Druid.close(connection, preparedStatement, resultSet);
            //或者：
            //JDBC.close(connection, preparedStatement);
        }
        //返回结果
        return list;
    }


    /**
     * 查询方法，用于将聚合函数的查询结果进行返回，注意：结果集中应该要只有一行和一列数据(一个数据),
     * 如果有多行或者多列的数据，将始终返回第一行第一列的数据，如果第一行第一列的数据不能转换为Long型，则返回null
     *
     * @param sql              预编译的sql查询语句，sql语句实例：select count(primaryKey) from table
     * @param resultSetHandler ResultSetHandler<T>对象，使用：new ScalarHandler<>(自定义对象.class)
     * @param objs             sql中的问号占位符，数量和顺序一定要一致
     * @return Long型的对象
     */
    public static Long queryForScalar(String sql, ResultSetHandler<Long> resultSetHandler, Object... objs)
    {
        //定义Long类型的变量
        Long value = null;
        //连接对象
        Connection connection = null;
        //预编译执行者对象
        PreparedStatement preparedStatement = null;
        //结果集对象
        ResultSet resultSet = null;
        try
        {
            //获取连接对象(Druid连接池)
            connection = Druid.getConnection();
            //或者(自定义数据库连接池)：
            //connection = connectionPool.getConnection();
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
                throw new RuntimeException("queryForScalar方法中参数个数不一致!");
            }
            //为问号占位符赋值
            for (int i = 0; i < count; i++)
            {
                preparedStatement.setObject(i + 1, objs[i]);
            }
            //执行sql语句,返回结果集
            resultSet = preparedStatement.executeQuery();
            //通过ScalarHandler类中的handler方法对结果集进行处理
            value = resultSetHandler.handler(resultSet);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            //释放资源
            Druid.close(connection, preparedStatement, resultSet);
            //或者：
            //JDBC.close(connection, preparedStatement);
        }
        //返回结果
        return value;
    }


    /**
     * 查询方法，此方法用于将一条或者多条记录封装成一个Object的二维数组并返回，适用于多表查询
     *
     * @param sql  预编译的sql查询语句，经常使用多表查询，sql语句实例：查询某号学生选修的课程名称和对应课程的分数：
     *             SELECT course.`name`, grade.grade
     *             FROM grade, course WHERE grade.cno = course.cno AND grade.`no`=?
     * @param objs sql中的问号占位符，数量和顺序一定要一致，在上一个例子中，问号的数量为1，数组个数为一个。
     *             例如，查询2号学生的学生选修的课程名称和对应课程的分数：可变数组的值为一个，值为2，
     * @return 返回一个Object类型的二维数组，注意：二维数组的第一行为列的名称，在上一个例子中，
     * 列名有两个则Object[0][0]等于course.`name`的列名，Object[0][1]等于grade.grade的列名，
     * 真正的数据从行下标为1开始。表内容的行数为Object[][]对象.length-1。
     */
    public static Object[][] queryForArray(String sql, Object... objs)
    {
        //定义一个Object类型的二维数组
        Object[][] result = null;
        //连接对象
        Connection connection = null;
        //预编译执行者对象
        PreparedStatement preparedStatement = null;
        //结果集对象
        ResultSet resultSet = null;
        try
        {
            //获取连接对象(Druid连接池)
            connection = Druid.getConnection();
            //或者(自定义数据库连接池)：
            //connection = connectionPool.getConnection();
            //或者直接获取(自定义JDBC工具类)：
            //connection = JDBC.getConnection();

            //预编译sql，返回执行者对象
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //获取参数的源信息对象
            ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
            //获取参数个数
            int count = parameterMetaData.getParameterCount();
            //判断参数是否一致，如果不一致，异常抛出
            if (objs.length != count)
            {
                throw new RuntimeException("queryForArray方法中参数个数不一致!");
            }
            //为问号占位符赋值
            for (int i = 0; i < count; i++)
            {
                preparedStatement.setObject(i + 1, objs[i]);
            }
            //执行sql语句,返回结果集
            resultSet = preparedStatement.executeQuery();
            //定义行数和列数
            int rows;
            int column;
            //通过结果集的对象获取结果源信息对象
            ResultSetMetaData metaData = resultSet.getMetaData();
            //通过源信息对象获取列数
            column = metaData.getColumnCount();
            //获取行数
            //resultSet.afterLast();
            resultSet.last();
            rows = resultSet.getRow();
            //System.out.println(rows + "  " + column);
            //结果集光标移回第一行的前面
            resultSet.beforeFirst();
            //数组创建，因为第一行为列的名称，所以行数要加一
            result = new Object[rows + 1][column];
            //取得列名称，填充数组的第一行
            for (int i = 0; i < column; i++)
            {
                //获取列名
                String columnName = metaData.getColumnName(i + 1);
                result[0][i] = columnName;
            }
            int rowIndex = 1;
            //填充其它数据
            while (resultSet.next())
            {
                //循环遍历列数
                for (int i = 0; i < column; i++)
                {
                    //获取列名
                    String columnName = metaData.getColumnName(i + 1);
                    //通过列名获取数据
                    Object object = resultSet.getObject(columnName);
                    //System.err.print(object+" ");
                    //填充至数组
                    result[rowIndex][i] = object;
                    //或者
                    //result[resultSet.getRow()][i] = object;
                }
                //行索引+1
                rowIndex = rowIndex + 1;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            //释放资源
            Druid.close(connection, preparedStatement, resultSet);
            //或者：
            //JDBC.close(connection, preparedStatement);
        }
        //返回结果
        return result;
    }


    /**
     * 查询方法，此方法用于将一条或者多条记录封装成一个list集合并返回，适用于多表查询
     * 此方法不推荐使用，因为在map集合中，key是列名，重复。但是集合重写了toString方法，可以直接输出字符串。
     *
     * @param sql  预编译的sql查询语句，经常使用多表查询，sql语句实例：查询某号学生选修的课程名称和对应课程的分数：
     *             SELECT course.`name`, grade.grade
     *             FROM grade, course WHERE grade.cno = course.cno AND grade.`no`=?
     * @param objs sql中的问号占位符，数量和顺序一定要一致，在上一个例子中，问号的数量为1，数组个数为一个。
     *             例如，查询2号学生的学生选修的课程名称和对应课程的分数：可变数组的值为一个，值为2，
     * @return 返回一个ArrayList集合，list集合的泛型为HashMap集合，map集合中的键为列名，值为此行的列名对应的值
     * 此方法不推荐使用，因为在map集合中，key是列名，重复。
     */
    public static List<HashMap<String, Object>> queryForListMap(String sql, Object... objs)
    {
        //定义一个List集合
        List<HashMap<String, Object>> list = new ArrayList<>();
        //连接对象
        Connection connection = null;
        //预编译执行者对象
        PreparedStatement preparedStatement = null;
        //结果集对象
        ResultSet resultSet = null;
        try
        {
            //获取连接对象(Druid连接池)
            connection = Druid.getConnection();
            //或者(自定义数据库连接池)：
            //connection = connectionPool.getConnection();
            //或者直接获取(自定义JDBC工具类)：
            //connection = JDBC.getConnection();

            //预编译sql，返回执行者对象
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //获取参数的源信息对象
            ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
            //获取参数个数
            int count = parameterMetaData.getParameterCount();
            //判断参数是否一致，如果不一致，异常抛出
            if (objs.length != count)
            {
                throw new RuntimeException("queryForArray方法中参数个数不一致!");
            }
            //为问号占位符赋值
            for (int i = 0; i < count; i++)
            {
                preparedStatement.setObject(i + 1, objs[i]);
            }
            //执行sql语句,返回结果集
            resultSet = preparedStatement.executeQuery();
            //通过结果集的对象获取结果源信息对象
            ResultSetMetaData metaData = resultSet.getMetaData();
            //通过源信息对象获取列数
            int column = metaData.getColumnCount();
            //定义HashMap集合对象
            HashMap<String, Object> map = null;
            //填充数据
            while (resultSet.next())
            {
                //开辟对象
                map = new HashMap<>();
                //循环遍历列数
                for (int i = 0; i < column; i++)
                {
                    //获取列名
                    String columnName = metaData.getColumnName(i + 1);
                    //通过列名获取数据
                    Object object = resultSet.getObject(columnName);
                    //System.err.print(object+" ");
                    //键值对加入到map集合中
                    map.put(columnName, object);
                }
                //加入到list集合中
                list.add(map);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            //释放资源
            Druid.close(connection, preparedStatement, resultSet);
            //或者：
            //JDBC.close(connection, preparedStatement);
        }
        //返回结果
        return list;
    }
}


