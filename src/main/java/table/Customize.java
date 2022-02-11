package table;

import io.ErrorLog;
import tools.Druid;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.*;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(类名): Customize
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/11
 * Time(创建时间)： 23:11
 * Version(版本): 1.0
 * Description(描述)： 自定义查询
 */

public class Customize
{

    //执行一次后，是否错误
    public static boolean isError = false;

    //错误信息
    private static String errorMessage = "";

    public static String getErrorMessage()
    {
        return errorMessage;
    }

    /**
     * 查询方法，此方法用于将一条或者多条记录封装成一个Object的二维数组并返回，适用于多表查询
     *
     * @param sql 预编译的sql查询语句，经常使用多表查询，sql语句实例：查询某号学生选修的课程名称和对应课程的分数：
     *            SELECT course.`name`, grade.grade
     *            FROM grade, course WHERE grade.cno = course.cno AND grade.`no`=?
     * @return 返回一个Object类型的二维数组，注意：二维数组的第一行为列的名称，在上一个例子中，
     * 列名有两个则Object[0][0]等于course.`name`的列名，Object[0][1]等于grade.grade的列名，
     * 真正的数据从行下标为1开始。表内容的行数为Object[][]对象.length-1。
     */
    public static Object[][] queryForArray(String sql)
    {
        //先设置成否
        isError = false;
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
            //产生错误
            e.printStackTrace();
            isError = true;
            //获得错误信息
            errorMessage = e.getMessage();
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
}
