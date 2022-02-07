package data;

/**
 * Project name(项目名称)：Database_course_design_Java_Web_Implementation_of_student_information_management_system_based_on_MySQL
 * Package(包名): data
 * Class(类名): Student
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/31
 * Time(创建时间)： 21:28
 * Version(版本): 1.0
 * Description(描述)： 学生类数据
 */

public class Student
{
    //学号
    private Long student_no;
    //学生姓名
    private String name;
    //学生性别
    private String sex;
    //电话号码
    private String telephone_number;
    //家庭电话号码，或者紧急联系人
    private String family_telephone_number;
    //生日
    private String birthday;
    //家庭地址
    private String address;
    //身份证号
    private String id_card;
    //电子邮箱
    private String email;
    //寝室号
    private String dormitory_number;
    //所属班级号
    private Long class_no;
    //状态，在读、毕业或者退学
    private String state;
    //备注
    private String remarks;


    /**
     * 无参构造
     */
    public Student()
    {

    }

    /**
     * 全参构造
     *
     * @param student_no              学号
     * @param name                    学生姓名
     * @param sex                     学生性别
     * @param telephone_number        电话号码
     * @param family_telephone_number 家庭电话号码，或者紧急联系人
     * @param birthday                生日
     * @param address                 家庭地址
     * @param id_card                 身份证号
     * @param email                   电子邮箱
     * @param dormitory_number        寝室号
     * @param class_no                所属班级号
     * @param state                   状态，在读、毕业或者退学
     * @param remarks                 备注
     */
    public Student(Long student_no, String name, String sex, String telephone_number, String family_telephone_number, String birthday,
                   String address, String id_card, String email, String dormitory_number, Long class_no, String state, String remarks)
    {
        if (student_no <= 0)
        {
            this.student_no = 0L;
        }
        else
        {
            this.student_no = student_no;
        }
        this.name = name;
        this.sex = sex;
        this.telephone_number = telephone_number;
        this.family_telephone_number = family_telephone_number;
        this.birthday = birthday;
        this.address = address;
        this.id_card = id_card;
        this.email = email;
        this.dormitory_number = dormitory_number;
        if (class_no < 0)
        {
            this.class_no = 0L;
        }
        else
        {
            this.class_no = class_no;
        }
        this.state = state;
        this.remarks = remarks;
    }

    //对应的getter方法和setter方法

    public long getStudent_no()
    {
        return student_no;
    }

    public void setStudent_no(Long student_no)
    {
        this.student_no = student_no;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getTelephone_number()
    {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number)
    {
        this.telephone_number = telephone_number;
    }

    public String getFamily_telephone_number()
    {
        return family_telephone_number;
    }

    public void setFamily_telephone_number(String family_telephone_number)
    {
        this.family_telephone_number = family_telephone_number;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getId_card()
    {
        return id_card;
    }

    public void setId_card(String id_card)
    {
        this.id_card = id_card;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getDormitory_number()
    {
        return dormitory_number;
    }

    public void setDormitory_number(String dormitory_number)
    {
        this.dormitory_number = dormitory_number;
    }

    public long getClass_no()
    {
        return class_no;
    }

    public void setClass_no(Long class_no)
    {
        if (class_no < 0)
        {
            this.class_no = 0L;
        }
        else
        {
            this.class_no = class_no;
        }
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    /**
     * toString方法
     *
     * @return 打印属性的字符串
     */
    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("no：").append(student_no).append('\t');
        stringbuilder.append("name：").append(name).append('\t');
        stringbuilder.append("sex：").append(sex).append('\t');
        stringbuilder.append("telephone_number：").append(telephone_number).append('\t');
        stringbuilder.append("family_telephone_number：").append(family_telephone_number).append('\t');
        stringbuilder.append("birthday：").append(birthday).append('\t');
        stringbuilder.append("address：").append(address).append('\t');
        stringbuilder.append("id_card：").append(id_card).append('\t');
        stringbuilder.append("email：").append(email).append('\t');
        stringbuilder.append("dormitory_number：").append(dormitory_number).append('\t');
        stringbuilder.append("class_no：").append(class_no).append('\t');
        stringbuilder.append("state：").append(state).append('\t');
        stringbuilder.append("remarks：").append(remarks).append('\t');
        return stringbuilder.toString();
    }
}
