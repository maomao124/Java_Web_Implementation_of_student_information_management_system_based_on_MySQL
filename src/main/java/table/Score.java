package table;

import tools.Handler.BeanHandler;
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
     * 私有化构造函数，目的是不让创建对象
     */
    public Score()
    {
    }

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

    /**
     * 获得成绩列表
     *
     * @return List<data.Score>对象
     */
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

    /**
     * 获得成绩总数
     *
     * @return 成绩总数
     */
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

    /**
     * 获得学生的成绩总数量
     *
     * @param no 学生学号
     * @return 学生的成绩总数
     */
    public static Long getStudentScoreCount(Long no)
    {
        //sql语句
        String sql = "select count(no) from score where no=?";
        //参数
        Object[] objects = {no};
        //执行sql
        Long result = JDBCTemplate.queryForScalar(sql, new ScalarHandler<>(), objects);
        //返回
        return result;
    }

    /**
     * 获得某科目成绩的总数
     *
     * @param course_no 课程编号
     * @return 该课程编号科目成绩的总数
     */
    public static Long getCourseScoreCount(Long course_no)
    {
        //sql语句
        String sql = "select count(no) from score where course_no=?";
        //参数
        Object[] objects = {course_no};
        //执行sql
        Long result = JDBCTemplate.queryForScalar(sql, new ScalarHandler<>(), objects);
        //返回
        return result;
    }

    /**
     * 插入一条成绩信息
     *
     * @param no          学生学号
     * @param course_no   课程编号
     * @param usual_score 平时成绩
     * @param end_score   期末成绩，或者考试成绩
     * @param semester    学期
     * @return 成功，返回true，失败返回false
     */
    public static boolean insert(Long no, Long course_no, Float usual_score, Float end_score, String semester)
    {
        //根据课程编号查询课程信息
        data.Course courseInformation = Course.getCourseInformation(course_no);
        //应该要存在此课程才能插入
        //如果不存在，直接返回
        if (courseInformation == null)
        {
            return false;
        }
        //课程存在
        //计算最终成绩
        Float final_score = getFinalScore(courseInformation.getCourse_mode(), usual_score, end_score);
        //计算绩点
        Float gradePoint = getGradePoint(final_score);
        //sql语句
        String sql = "insert into score values(?,?,?,?,?,?,?)";
        //参数
        Object[] objects = {no, course_no, usual_score, end_score, final_score, gradePoint, semester};
        //执行sql
        int result = JDBCTemplate.update(sql, objects);
        //返回结果
        if (result > 0)
        {
            return true;
        }
        return false;
    }

    /**
     * 修改成绩，应该只能管理员能修改，老师只有插入权
     *
     * @param no          要修改成绩的学生学号
     * @param course_no   要修改成绩的学生课程号
     * @param usual_score 平时成绩
     * @param end_score   期末成绩
     * @param semester    学期
     * @return 成功，返回true，失败返回false
     */
    public static boolean update(Long no, Long course_no, Float usual_score, Float end_score, String semester)
    {
        //根据课程编号查询课程信息
        data.Course courseInformation = Course.getCourseInformation(course_no);
        //应该要存在此课程才能插入
        //如果不存在，直接返回
        if (courseInformation == null)
        {
            return false;
        }
        //课程存在
        //计算最终成绩
        Float final_score = getFinalScore(courseInformation.getCourse_mode(), usual_score, end_score);
        //计算绩点
        Float gradePoint = getGradePoint(final_score);
        //sql语句
        String sql = "update score set usual_score=?,end_score=?,final_score=?,grade_point=?,semester=? where no=? and course_no=?";
        //参数
        Object[] objects = {usual_score, end_score, final_score, gradePoint, semester, no, course_no};
        //执行sql
        int result = JDBCTemplate.update(sql, objects);
        //返回结果
        if (result > 0)
        {
            return true;
        }
        return false;
    }

    /**
     * 删除一条成绩(一名学生的一名成绩)
     *
     * @param no        学生学号
     * @param course_no 课程编号
     * @return 成功，返回true，失败返回false
     */
    public static boolean delete(Long no, Long course_no)
    {
        //sql语句
        String sql = "delete from score where no=? and course_no=?";
        //参数
        Object[] objects = {no, course_no};
        //执行sql
        int result = JDBCTemplate.update(sql, objects);
        //判断返回值
        if (result > 0)
        {
            return true;
        }
        return false;
    }

    /**
     * 删除学生的全部成绩(一名学生的所有成绩) ，谨慎使用！
     *
     * @param no 学生学号
     * @return 删除的成绩条数
     */
    public static int deleteStudentAllScore(Long no)
    {
        //sql语句
        String sql = "delete from score where no=?";
        //参数
        Object[] objects = {no};
        //执行sql
        int result = JDBCTemplate.update(sql, objects);
        //返回
        return result;
    }

    /**
     * 删除一门课程的所有学生的成绩(所有学生的某门成绩)，谨慎使用！
     *
     * @param course_no 课程编号
     * @return 删除的成绩条数
     */
    public static int deleteCourseAllScore(Long course_no)
    {
        //sql语句
        String sql = "delete from score where course_no=?";
        //参数
        Object[] objects = {course_no};
        //执行sql
        int result = JDBCTemplate.update(sql, objects);
        //返回
        return result;
    }

    /**
     * 获得某个学生的成绩信息，包含课程信息
     *
     * @param no 学生学号
     * @return 二维数组
     */
    public static Object[][] getStudentScoreArray(Long no)
    {
        //sql语句
        String sql = "SELECT course.*,score.usual_score,score.end_score,score.final_score,score.grade_point," +
                "score.semester FROM course,score WHERE course.course_no=score.course_no AND score.`no`=?" +
                " ORDER BY score.grade_point DESC";
        //参数
        Object[] objects = {no};
        //执行sql
        Object[][] array = JDBCTemplate.queryForArray(sql, objects);
        //返回
        return array;
    }

    /**
     * 验证学生的成绩是否已经存在
     *
     * @param no        学生学号
     * @param course_no 课程号
     * @return 存在，则返回true，不存在，返回false
     */
    public static boolean verification(Long no, Long course_no)
    {
        //sql语句
        String sql = "select * from score where no=? and course_no=?";
        //参数
        Object[] objects = {no, course_no};
        //执行sql
        data.Score score = JDBCTemplate.queryForObject(sql, new BeanHandler<>(data.Score.class), objects);
        if (score.getNo() == null)
        {
            //不存在
            return false;
        }
        else
        {
            //存在
            return true;
        }
    }

    /**
     * 获得某一个学生的某一个科目的成绩
     *
     * @param no        学生学号
     * @param course_no 课程号
     * @return data.Score对象
     */
    public static data.Score getStudentScore(Long no, Long course_no)
    {
        //sql语句
        String sql = "select * from score where no=? and course_no=?";
        //参数
        Object[] objects = {no, course_no};
        //执行sql
        data.Score score = JDBCTemplate.queryForObject(sql, new BeanHandler<>(data.Score.class), objects);
        //返回
        if (score.getNo() == null)
        {
            return null;
        }
        return score;
    }
}
