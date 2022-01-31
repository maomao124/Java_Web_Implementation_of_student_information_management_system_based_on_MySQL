package tools.Handler;

import java.sql.ResultSet;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): tools.Handler
 * Interface(接口名): ResultSetHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 22:59
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface ResultSetHandler<T>
{
    <T> T handler(ResultSet resultSet);
}
