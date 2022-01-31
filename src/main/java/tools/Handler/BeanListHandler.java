package tools.Handler;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): tools.Handler
 * Class(类名): BeanListHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 23:04
 * Version(版本): 1.0
 * Description(描述)： 无
 */

/*
接口：
public interface ResultSetHandler<T>
{
    <T> T handler(ResultSet resultSet);
}
 */

@SuppressWarnings("all")
public class BeanListHandler<T> implements ResultSetHandler<T>
{
    //class对象类型的变量
    private final Class<T> beanClass;

    //构造方法赋值
    public BeanListHandler(Class<T> beanClass)
    {
        this.beanClass = beanClass;
    }

    /**
     * 根据结果集对象返回对应的对象集合
     *
     * @param resultSet 结果集对象
     * @return list集合
     */
    @Override
    public List<T> handler(ResultSet resultSet)
    {
        //声明集合类型
        List<T> list = new ArrayList<>();
        try
        {
            //获取结果集的数据
            while (resultSet.next())
            {
                //为自定义对象进行赋值
                T bean = beanClass.getDeclaredConstructor().newInstance();
                //通过结果集的对象获取结果源信息对象
                ResultSetMetaData metaData = resultSet.getMetaData();
                //通过源信息对象获取列数
                int count = metaData.getColumnCount();
                //循环遍历列数
                for (int i = 1; i <= count; i++)
                {
                    //获取列名
                    String columnName = metaData.getColumnName(i);
                    //通过列名获取数据
                    Object object = resultSet.getObject(columnName);
                    //创建属性描述器对象,对对象的set方法进行赋值
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnName.toLowerCase(), beanClass);
                    //获取set方法
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    //执行set方法,赋值
                    writeMethod.invoke(bean, object);
                }
                //将对象保存到集合中
                list.add(bean);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //返回对象
        return list;
    }
}

