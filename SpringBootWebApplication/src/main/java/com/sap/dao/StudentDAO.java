package com.sap.dao;

import com.sap.entity.Student;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents();

    Student getStudent(int id);

    void deleteStudent(@PathVariable("id") int id);

    Student updateStudent(Student student);

    Student insertStudent(Student student);
}
