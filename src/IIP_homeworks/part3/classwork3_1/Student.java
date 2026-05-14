package IIP_homeworks.part3.classwork3_1;

import com.sun.source.tree.BreakTree;

public class Student {
    private int id;
    private String name;
    private int age;
    private String group;

    public Student(int id, String name, int age, String group){
        this.id = id;
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Student: Id=" + id + ", Name=" + name + ", Age=" + age + ", Group=" + group;
    }
}
