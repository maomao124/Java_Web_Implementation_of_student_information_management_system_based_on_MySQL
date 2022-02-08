package table;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(测试类名): LoginLogTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/8
 * Time(创建时间)： 13:49
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class LoginLogTest
{

    @Test
    void getLogList()
    {
        List<data.LoginLog> logList = LoginLog.getLogList();
        for (data.LoginLog log : logList)
        {
            System.out.print(log);
        }
    }

    @Test
    void getPeopleLogList()
    {
        List<data.LoginLog> logList = LoginLog.getPeopleLogList(10001L);
        for (data.LoginLog log : logList)
        {
            System.out.print(log);
        }
    }

    @Test
    void insert()
    {
        boolean b = LoginLog.insert(10002L, "张三");
        System.out.println(b);
    }

    @Test
    void getLogCount()
    {
        Long logCount = LoginLog.getLogCount();
        System.out.println(logCount);
    }

    @Test
    void getPageCount()
    {
        Long logCount = LoginLog.getLogCount();
        System.out.println(logCount);
        long pageCount = LoginLog.getPageCount(logCount);
        System.out.println(pageCount);
    }

    @Test
    void getThisPageList()
    {
        Long logCount = LoginLog.getLogCount();
        System.out.println(logCount);
        long pageCount = LoginLog.getPageCount(logCount);
        System.out.println(pageCount);
        List<data.LoginLog> list = LoginLog.getThisPageList(pageCount, 1L);
        if (list == null)
        {
            System.out.println("空");
            return;
        }
        for (data.LoginLog log : list)
        {
            System.out.print(log);
        }
    }
}