package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping()
    public String add(@RequestBody Student student) {
        try {
            studentService.add(student);
            return "添加成功";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/student/all")
    public Iterable<Student> queryAllStudent() {
        return studentService.queryAllStudent();
    }

    @GetMapping("/student/{name}")
    public Student queryStudentByName(@PathVariable String name) {
        return studentService.queryStudentByName(name);
    }

    @DeleteMapping()
    public String delete(@RequestBody String name) {
        try {
            studentService.delete(name);
            return "删除成功";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
}
