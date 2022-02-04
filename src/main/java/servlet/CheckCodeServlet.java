package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): servlet
 * Class(类名): CheckCodeServlet
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/3
 * Time(创建时间)： 23:47
 * Version(版本): 1.0
 * Description(描述)： 验证码类
 */

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int width = 120;
        int height = 35;
        // 在内存中生成图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 先获取画笔对象
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();
        // 设置灰色
        graphics2D.setColor(Color.GRAY);
        // 画填充的矩形
        graphics2D.fillRect(0, 0, width, height);
        // 设置颜色
        graphics2D.setColor(Color.BLUE);
        // 画边框
        graphics2D.drawRect(0, 0, width - 1, height - 1);
        // 准备数据，随机获取4个字符
        String words = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        // 设置颜色
        graphics2D.setColor(Color.YELLOW);
        // 设置字体
        graphics2D.setFont(new Font("隶书", Font.BOLD, 20));
        StringBuilder code = new StringBuilder();
        //构造存储字符的数组
        char[] a = {};
        //构造存储字符串的集合
        ArrayList<String> list = new ArrayList<>();
        Random random = new Random();
        int x = 20;
        int y = 20;
        for (int i = 0; i < 4; i++)
        {
            // void rotate(double theta, double x, double y)
            // theta 弧度
            // hudu = jiaodu * Math.PI / 180;
            // 获取正负30之间的角度
            int jiaodu = random.nextInt(60) - 30;
            double hudu = jiaodu * Math.PI / 180;
            graphics2D.rotate(hudu, x, y);
            // 获取下标
            int index = random.nextInt(words.length());
            // 返回指定下标位置的字符，随机获取下标
            char ch = words.charAt(index);
            //将字符存入字符数组中
            char[] chc = {ch};
            //使用字符数组构造字符串
            String string = new String(chc);
            //将构造好的字符串添加进list集合中
            list.add(string);
            // 写字符串
            graphics2D.drawString("" + ch, x, y);
            graphics2D.rotate(-hudu, x, y);
            x += 20;
        }
        for (String s : list)
        {
            code.append(s);
        }
        //将验证码存入session中
        HttpSession session = request.getSession();
        session.setAttribute("code", code.toString());
        // 设置颜色
        graphics2D.setColor(Color.GREEN);
        int x1, x2, y1, y2;
        // 画干扰线
        for (int i = 0; i < 4; i++)
        {
            x1 = random.nextInt(width);
            y1 = random.nextInt(height);
            x2 = random.nextInt(width);
            y2 = random.nextInt(height);
            graphics2D.drawLine(x1, y1, x2, y2);
        }
        // 输出到客户端
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}
