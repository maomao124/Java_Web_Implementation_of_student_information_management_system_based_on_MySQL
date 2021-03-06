package table;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): table
 * Class(测试类名): ScoreTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/6
 * Time(创建时间)： 20:58
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */
class ScoreTest
{

    /**
     * Gets final score.
     */
    @Test
    void getFinalScore()
    {
        System.out.println(table.Score.getFinalScore("考试", 100f, 50f));
        System.out.println(table.Score.getFinalScore("考查", 100f, 50f));
        System.out.println(table.Score.getFinalScore("考查", 80f, 70f));

    }

    /**
     * Gets grade point.
     */
    @Test
    void getGradePoint()
    {
        System.out.println(table.Score.getGradePoint(20f));
        System.out.println(table.Score.getGradePoint(59f));
        System.out.println(table.Score.getGradePoint(68f));
        System.out.println(table.Score.getGradePoint(73f));
        System.out.println(table.Score.getGradePoint(87f));
        System.out.println(table.Score.getGradePoint(99.5f));
        System.out.println(table.Score.getGradePoint(100f));
    }

    /**
     * Gets score list.
     */
    @Test
    void getScoreList()
    {
        List<data.Score> list = Score.getScoreList();
        for (data.Score score : list)
        {
            System.out.print(score);
        }
    }

    /**
     * Gets score count.
     */
    @Test
    void getScoreCount()
    {
        Long scoreCount = Score.getScoreCount();
        System.out.println(scoreCount);
    }

    /**
     * Gets student score count.
     */
    @Test
    void getStudentScoreCount()
    {
        System.out.println(table.Score.getStudentScoreCount(20L));
    }

    /**
     * Gets course score count.
     */
    @Test
    void getCourseScoreCount()
    {
        System.out.println(table.Score.getCourseScoreCount(50L));
    }

    /**
     * Insert.
     */
    @Test
    void insert()
    {
        boolean b = Score.insert(100011111L, 100001L, 89f, 74f, "2019下学期");
        System.out.println(b);
    }

    /**
     * Update.
     */
    @Test
    void update()
    {
        boolean b = Score.update(100011111L, 100001L, 89f, 74f, "2019下学期");
        System.out.println(b);
    }

    /**
     * Delete.
     */
    @Test
    void delete()
    {
        boolean b = Score.delete(100011111L, 100001L);
        System.out.println(b);
    }

    /**
     * Delete student all score.
     */
    @Test
    void deleteStudentAllScore()
    {
        int b = Score.deleteStudentAllScore(202012340101L);
        System.out.println(b);
    }

    /**
     * Delete course all score.
     */
    @Test
    void deleteCourseAllScore()
    {
        int b = Score.deleteCourseAllScore(100001L);
        System.out.println(b);
    }

    /**
     * Gets student score array.
     */
    @Test
    void getStudentScoreArray()
    {
        Object[][] studentArray = table.Score.getStudentScoreArray(202012340101L);
        System.out.println("数量：" + (studentArray.length - 1));
        for (int i = 0; i < studentArray.length; i++)
        {
            for (int j = 0; j < studentArray[i].length; j++)
            {
                System.out.print(studentArray[i][j] + "    ");
            }
            System.out.println();
        }
    }

    /**
     * Verification.
     */
    @Test
    void verification()
    {
        boolean b = Score.verification(202012340101L, 200001L);
        System.out.println(b);
    }

    /**
     * Gets student score.
     */
    @Test
    void getStudentScore()
    {
        data.Score score = Score.getStudentScore(202012340101L, 200001L);
        System.out.println(score);
    }
}