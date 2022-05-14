package vn.techmaster.myfirstweb.model;

public class Student {
    String id_student;
    String full_name;
    int age;

    public Student(String id_student, String full_name, int age) {
        this.id_student = id_student;
        this.full_name = full_name;
        this.age = age;
    }

    public String getId_student() {
        return id_student;
    }

    public void setId_student(String id_student) {
        this.id_student = id_student;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
