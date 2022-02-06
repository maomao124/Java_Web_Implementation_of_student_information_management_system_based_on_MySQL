package table;

import tools.Handler.BeanListHandler;
import tools.Handler.ScalarHandler;
import tools.JDBCTemplate;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(类名): Score
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 23:13
 * Version(版本): 1.0
 * Description(描述)： 分数表
 */

public class Score
{
    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    /**
     * 根据模式，平时成绩和考试成绩得到最终成绩
     *
     * @param mode        考核方式，考试或者考察
     * @param usual_score 平时成绩
     * @param end_score   考试成绩
     * @return 最终成绩
     */
    public static Float getFinalScore(String mode, Float usual_score, Float end_score)
    {
        //如果输入的课程是考试模式
        if (mode.equals("考试"))
        {
            //平时成绩和考试成绩四六开
            return usual_score * 0.4f + end_score * 0.6f;
        }
        else
        {
            //考察
            //平时成绩和考试成绩各占一半
            return usual_score * 0.5f + end_score * 0.5f;
        }
    }

    /**
     * 根据最终成绩获得对应的绩点
     *
     * @param final_score 最终成绩
     * @return 绩点
     */
    public static Float getGradePoint(Float final_score)
    {
        //不及格，则绩点为0
        if (final_score < 60)
        {
            return 0f;
        }
        //绩点=分数/10-5
        return Float.valueOf(decimalFormat.format(final_score / 10 - 5));
    }

    public static List<data.Score> getScoreList()
    {
        //sql语句
        String sql = "select * from score";
        //参数，无
        Object[] objects = {};
        //执行sql
        List<data.Score> list = JDBCTemplate.queryForList(sql, new BeanListHandler<>(data.Score.class), objects);
        //返回
        return list;
    }

    public static Long getScoreCount()
    {
        //sql语句
        String sql = "select count(no) from score";
        //参数，无
        Object[] objects = {};
        //执行sql
        Long result = JDBCTemplate.queryForScalar(sql, new ScalarHandler<>(), objects);
        //返回
        return result;
    }
}
