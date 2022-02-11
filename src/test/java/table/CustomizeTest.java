package table;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(测试类名): CustomizeTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/11
 * Time(创建时间)： 23:42
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class CustomizeTest
{

    @Test
    void queryForArray()
    {
        String sql = "SELECT * FROM administrators";
        Object[][] objects = Customize.queryForArray(sql);
        if (Customize.isError)
        {
            System.out.println("错误！！！");
            System.out.println(table.Customize.getErrorMessage());
        }
        else
        {
            for (int i = 0; i < objects.length; i++)
            {
                for (int j = 0; j < objects[i].length; j++)
                {
                    System.out.print(objects[i][j]+"   ");
                }
                System.out.println();
            }
        }
    }
}