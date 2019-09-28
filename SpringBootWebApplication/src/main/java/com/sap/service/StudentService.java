package com.sap.service;

import com.sap.dao.FakeStudentDAOImpl;
import com.sap.dao.StudentDAO;
import com.sap.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    @Qualifier("mongo")
    private StudentDAO studentDAO;

    public Collection<Student> getAllStudents(){
        return this.studentDAO.getAllStudents();
    }

    public Student getStudent(int id){
        return this.studentDAO.getStudent(id);
    }

    public void deleteStudent(@PathVariable("id") int id){
        this.studentDAO.deleteStudent(id);
    }

    public Student updateStudent(Student student) {
        return this.studentDAO.updateStudent(student);
    }

    public Student insertStudent(Student student) {
        return this.studentDAO.insertStudent(student);
    }
}
