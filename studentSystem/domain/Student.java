package studentSystem.domain;

/**
 * 学生类
 * @author itzhuzhu
 * @date 2021/2/9 2:12 下午
 */
public class Student {
    //学号
    private String sid;

    //姓名
    private String name;

    //年龄
    private int age;

    //生日
    private String birthday;

    public Student(String sid, String name, int age, String birthday) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Student() {
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
