package com.example.demo;

import java.util.Objects;

public class Student {
    private String name;
    private String sex;
    private String classroom;

    public Student() {
    }

    public Student(String name, String sex, String classroom) {
        this.name = name;
        this.sex = sex;
        this.classroom = classroom;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", classroom='" + classroom + '\'' +
                '}';
    }
}
