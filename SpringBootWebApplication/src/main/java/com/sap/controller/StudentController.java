package com.sap.controller;

import com.sap.entity.Student;
import com.sap.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService  studentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){
        return this.studentService.getAllStudents();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Student getStudnt(@PathVariable("id") int id){
        return this.studentService.getStudent(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable("id") int id){
        this.studentService.deleteStudent(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Student updateStudent(@RequestBody Student student){
        return this.studentService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Student insertStudent(@RequestBody Student student){
        return this.studentService.insertStudent(student);
    }

}
