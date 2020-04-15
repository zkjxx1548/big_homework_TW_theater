package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("student")
public class Student {
    @Id
    private Integer id;
    @Column("name")
    private String name;
    @Column("sex")
    private String sex;
    @Column("classroom")
    private String classroom;

    public Student() {
    }

    public Student(String name, String sex, String classroom) {
        this.name = name;
        this.sex = sex;
        this.classroom = classroom;
    }

    public Student(Integer id, String name, String sex, String classroom) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.classroom = classroom;
    }

    public Integer getId() {
        return id;
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

    public void setId(Integer id) {
        this.id = id;
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
