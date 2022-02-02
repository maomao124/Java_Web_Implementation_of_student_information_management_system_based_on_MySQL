package table;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(测试类名): AdministratorsTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/1
 * Time(创建时间)： 21:05
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class AdministratorsTest
{

    @Test
    void getAdministrators()
    {
        List<data.Administrators> administrators = Administrators.getAdministrators();
        for (data.Administrators administrator : administrators)
        {
            System.out.print(administrator);
        }
    }

    @Test
    void getAdministrator()
    {
        data.Administrators administrator = Administrators.getAdministrator(20L);
        System.out.println(administrator);
    }

    @Test
    void insert()
    {
        data.Administrators administrator = new data.Administrators(10004L, "王七",
                "副校长", "435588745685891235");
        System.out.println(table.Administrators.insert(administrator));
    }

    @Test
    void update()
    {
        data.Administrators administrator = new data.Administrators(10004L, "王七",
                "副校长", "435588745685891235");
        System.out.println(table.Administrators.update(10004L,"赵六",
                "副校长","435588745685891235"));
    }

    @Test
    void delete()
    {
        System.out.println(table.Administrators.delete(10003L));
    }
}