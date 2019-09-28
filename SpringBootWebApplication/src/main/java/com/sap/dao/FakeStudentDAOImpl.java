package com.sap.dao;

import com.sap.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Qualifier("fake")
public class FakeStudentDAOImpl implements StudentDAO {
    private static Map<Integer, Student> students;

    static{
        students    =   new HashMap<>();
        students.put(1, new Student(1,"Sachin", "Learning"));
        students.put(2, new Student(2,"Himanshu", "CS"));
        students.put(3, new Student(3,"Rohan", "EC"));
    }

    @Override
    public List<Student> getAllStudents(){
        return (List<Student>) this.students.values();
    }

    @Override
    public Student getStudent(int id){
        return this.students.get(id);
    }

    @Override
    public void deleteStudent(@PathVariable("id") int id){
        this.students.remove(id);
    }

    @Override
    public Student updateStudent(Student student) {
       /* Student studentExist    =   students.get(student.getId());
        studentExist.setCourse(student.getCourse());
        studentExist.setName(student.getName());*/
        students.put(student.getId(), student);

        return students.get(student.getId());
    }

    @Override
    public Student insertStudent(Student student) {
        this.students.put(student.getId(),student);
        return  this.students.get(student.getId());
    }
}
