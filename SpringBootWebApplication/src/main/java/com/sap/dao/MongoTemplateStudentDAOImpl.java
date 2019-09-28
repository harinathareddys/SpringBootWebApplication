package com.sap.dao;

import com.sap.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("mongo")
public class MongoTemplateStudentDAOImpl implements StudentDAO{

    @Autowired
    MongoTemplate   mongoTemplate;
    @Override
    public List<Student> getAllStudents() {
        return mongoTemplate.findAll(Student.class);
    }

    @Override
    public Student getStudent(int id) {
        return  mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),Student.class);
    }


    @Override
    public Student insertStudent(Student student) {
        return mongoTemplate.save(student);
    }
    @Override
    public void deleteStudent(int id) {
        mongoTemplate.remove(new Query(Criteria.where("id").is(id)), Student.class);
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }
}
