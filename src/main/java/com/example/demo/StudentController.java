package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class StudentController {
    public List<Student> students = new ArrayList();

    @PostMapping()
    public String add(@RequestBody Student student) {
        if (students.contains(student)) {
            return "姓名重复";
        }
        students.add(student);
        return "添加成功";
    }

    @GetMapping("/student/all")
    public List<Student> queryAllStudent() {
        return this.students;
    }

    @GetMapping("/student/{name}")
    public Student queryStudentByName(@PathVariable String name) {
        return students.stream()
                .filter(student -> Objects.equals(student.getName(), name))
                .findAny()
                .orElse(new Student());
    }

    @DeleteMapping()
    public String delete(@RequestBody String name) {
        for (Student student:students) {
            if (Objects.equals(student.getName(), name)) {
                students.remove(student);
                return "删除成功";
            }
        }
        return "该学生不存在";
    }
}
