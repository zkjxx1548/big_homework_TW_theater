package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void add(Student student) {
        Iterable<Student> students = queryAllStudent();
        AtomicReference<String> res = new AtomicReference<>("");
        students.forEach(student1 -> {
            if (Objects.equals(student1.getName(), student.getName())) {
                throw new RuntimeException("姓名重复");
            }
        });
        studentRepository.save(student);
    }

    public Iterable<Student> queryAllStudent() {
        return studentRepository.findAll();
    }

    public Student queryStudentByName(String name) {
        return studentRepository.findByName(name).orElse(null);
    }

    public void delete(String name) {
        Student student = queryStudentByName(name);
        if (student == null) {
            throw new RuntimeException("该学生不存在");
        }
        studentRepository.delete(student);
    }

}
