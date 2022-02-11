package servlet.filter;

import data.Administrators;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

@WebFilter(filterName = "TeacherFilter",urlPatterns = "/teacher/*")
public class TeacherFilter implements Filter
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
        //设置编码
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //获得session对象
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        //从session里获取身份信息
        Object identity = session.getAttribute("identity");
        //判断身份是否存在
        if (identity == null || identity.equals(""))
        {
            //不存在，没登录
//            //重定向
//            HttpServletResponse httpResponse = (HttpServletResponse) response;
//            httpResponse.sendRedirect("error_login.jsp");
            //转发
            request.getRequestDispatcher("../error_login.jsp").forward(request, response);
            return;
        }
        //身份存在
        //判断身份是否为老师
        if (!identity.equals("老师"))
        {
            //转发
            request.getRequestDispatcher("../error_noPermission.jsp").forward(request, response);
            return;
        }
        //从session里取数据验证
        data.Teacher teacher = (data.Teacher) session.getAttribute("teacher");
        //判断是否为空，如果是，身份过期，重新登录
        if (teacher == null)
        {
            //转发
            request.getRequestDispatcher("../error_login.jsp").forward(request, response);
            return;
        }
        //验证通过
        chain.doFilter(request, response);
    }
}
