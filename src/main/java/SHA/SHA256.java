package SHA;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): SHA
 * Class(类名): SHA256
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/2/2
 * Time(创建时间)： 14:10
 * Version(版本): 1.0
 * Description(描述)： 散列算法，SHA256，用于转换老师密码和验证老师密码
 */

public class SHA256
{
    private static String SHA(final String strText)
    {
        String strResult = null;
        if (strText != null && strText.length() > 0)
        {
            try
            {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(strText.getBytes());
                byte[] byteBuffer = messageDigest.digest();
                StringBuilder strHexString = new StringBuilder();
                for (int i = 0; i < byteBuffer.length; i++)
                {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1)
                    {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                strResult = strHexString.toString();
            }
            catch (NoSuchAlgorithmException e)
            {
                e.printStackTrace();
            }
        }
        return strResult;
    }

    /**
     * 获得字符串对应的散列值，SHA256，小写
     *
     * @param strText 要转换的字符串
     * @return 字符串对应的SHA256码，小写
     */
    public static String getSHA256(String strText)
    {
        return SHA(strText);
    }

    /**
     * 获得字符串对应的散列值，SHA256，大写
     *
     * @param strText 要转换的字符串
     * @return 字符串对应的SHA256码，大写
     */
    public static String getSHA256toUpperCase(String strText)
    {
        return SHA(strText).toUpperCase();
    }
}

