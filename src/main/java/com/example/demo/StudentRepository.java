package com.example.demo;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, String> {
    @Query("SELECT id,name,sex,classroom FROM student WHERE name=:name")
    Optional<Student> findByName(@Param("name") String name);
}
