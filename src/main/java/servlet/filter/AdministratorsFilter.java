package servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): ${PACKAGE_NAME}
 * Class(类名): ${NAME}
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/2
 * Time(创建时间)： 14:00
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@WebFilter(filterName = "AdministratorsFilter")
public class AdministratorsFilter implements Filter
{
    public void init(FilterConfig config) throws ServletException
    {
    }

    public void destroy()
    {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException
    {
        chain.doFilter(request, response);
    }
}
