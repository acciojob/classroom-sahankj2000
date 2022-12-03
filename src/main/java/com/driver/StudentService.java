package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class StudentService {

    @Autowired
    StudentRepository repo;

    public void addStudentService(Student student){
        repo.addStudentDB(student);
    }

    public void addTeacherService(Teacher teacher){
        repo.addTeacherDB(teacher);
    }

    public void addStudentTeacherPairService(String studentName,String teacherName){
        repo.addStudentTeacherPairDB(studentName,teacherName);
    }

    public Student getStudentByNameService(String studentName){
        return repo.getStudentByNameDB(studentName);
    }

    public Teacher getTeacherByNameService(String teacherName){
        return repo.getTeacherByNameDB(teacherName);
    }

    public List<String> getStudentsByTeacherNameService(String teacherName){
        return repo.getStudentsByTeacherNameDB(teacherName);
    }

    public List<String> getAllStudentsService(){
        return repo.getAllStudentsDB();
    }

    public void deleteTeacherByNameService(String teacherName){
        repo.deleteTeacherByNameDB(teacherName);
    }

    public void deleteAllTeachersService(){
        repo.deleteAllTeachersDB();
    }
}
