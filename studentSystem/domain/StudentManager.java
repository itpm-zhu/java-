package studentSystem.domain;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 主界面
 *
 * @author itzhuzhu
 * @date 2021/2/9 2:17 下午
 */
public class StudentManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 创建集合
        ArrayList<Student> list = new ArrayList<>();
        lo:
        while (true) {
            // 1、创建主菜单界面
            System.out.println("----------欢迎来到到学生管理系统----------");
            System.out.println("1、添加学生");
            System.out.println("2、删除学生");
            System.out.println("3、修改学生");
            System.out.println("4、查看学生");
            System.out.println("5、退出");
            System.out.println("请输入您要的选择");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    addStudent(list);
                    break;

                case "2":
                    deleteStudent(list);
                    break;

                case "3":
                    updateStudent(list);
                    break;

                case "4":
                    showStudent(list);
                    break;

                case "5":
                    System.out.println("感谢您的使用");
                    break lo;
                default:
                    System.out.println("您的输入有误");
                    break;
            }
        }
    }

    public static void updateStudent(ArrayList<Student> list) {
        // 提示信息
        System.out.println("请输入要修改的学号");
        // 键盘录入
        Scanner sc = new Scanner(System.in);
        String updateSid = sc.next();
        // 调用getIndex方法，查找学号在集合中出现的索引位置
        int index = getIndex(list, updateSid);
        // 根据索引判断学号是否存在
        if (index == -1) {
            System.out.println("无匹配数据，请重新输入");
        } else {
            System.out.println("请输入新的学生姓名：");
            String name = sc.next();
            System.out.println("请输入新的学生年龄：");
            int age = sc.nextInt();
            System.out.println("请输入新的学生生日：");
            String birthday = sc.next();
            // 封装为新的学生对象
            Student stu = new Student(updateSid, name, age, birthday);
            list.set(index, stu);
            System.out.println("修改成功");
        }
    }


    public static void deleteStudent(ArrayList<Student> list) {
        // 提示信息
        System.out.println("请输入要删除的学号");
        // 键盘录入
        Scanner sc = new Scanner(System.in);
        String deleteSid = sc.next();
        // 调用getIndex方法，查找学号在集合中出现的索引位置
        int index = getIndex(list, deleteSid);
        // 根据索引判断学号是否存在
        if (index == -1) {
            System.out.println("无匹配数据，请重新输入");
        } else {
            list.remove(index);
            System.out.println("删除成功");
        }
    }

    /**
     * 查看学生的方法
     */
    public static void showStudent(ArrayList<Student> list) {
        // 判断集合中是否有数据，不存在 给提示
        if (list.size() == 0) {
            System.out.println("暂无数据，请添加数据");
            // 因为走到这里就不需要执行了，直接return弹栈
            return;
        }
        // 存在展示表头数据
        System.out.println("学号\t姓名\t年龄\t生日");
        // 遍历集合，获取每一个学生对象的信息，打印在控制台
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getSid() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getBirthday());
        }
    }

    /**
     * 添加学生的方法
     */
    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        String sid;
        // 显示录入提示信息
        while (true) {
            System.out.println("请输入学号");
            sid = sc.next();
            int index = getIndex(list, sid);
            if (index == -1) {
                // 不存在就继续
                break;
            }
        }
        System.out.println("请输入姓名");
        String name = sc.next();
        System.out.println("请输入年龄");
        int age = sc.nextInt();
        System.out.println("请输入生日");
        String birthday = sc.next();
        // 键盘录入信息封装成对象
        Student stu = new Student(sid, name, age, birthday);
        // 添加到集合
        list.add(stu);
        // 提示添加状态
        System.out.println("添加成功");
    }

    /**
     * 查找学号在索引的位置方法
     */
    public static int getIndex(ArrayList<Student> list, String sid) {
        // 集合中不存在索引
        int index = -1;
        // 遍历集合，获取每一个学生对象，查找
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            // 获取每一个学生对象的学号
            String id = stu.getSid();
            // 使用获取出的学生学号，和传入的学号进行对比
            if (id.equals(sid)) {
                // 存在：让index遍历记录正确的索引位置
                index = i;
            }
        }
        return index;
    }
}