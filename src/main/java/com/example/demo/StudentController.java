package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping()
    public String add(@RequestBody Student student) {
        Iterable<Student> students = queryAllStudent();
        AtomicReference<String> res = new AtomicReference<>("");
        students.forEach(student1 -> {
            if (Objects.equals(student1.getName(), student.getName())) {
                res.set("姓名重复");
            }
        });
        if (!Objects.equals(res.toString(), "姓名重复")) {
            studentRepository.save(student);
            res.set("添加成功");
        }
    return res.toString();
    }

    @GetMapping("/student/all")
    public Iterable<Student> queryAllStudent() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{name}")
    public Student queryStudentByName(@PathVariable String name) {
        return studentRepository.findByName(name).orElse(null);
    }

    @DeleteMapping()
    public String delete(@RequestBody String name) {
        Student student = queryStudentByName(name);
        if (student == null) {
            return "该学生不存在";
        }
        studentRepository.delete(student);
        return "删除成功";
    }
}
