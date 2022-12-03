package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Repository
public class StudentRepository {

    private Map<String,Student> studentMap = new HashMap<>();
    private Map<String,Teacher> teacherMap = new HashMap<>();
    private Map<Teacher, List<Student>> pairMap = new HashMap<>();

    public void addStudentDB(Student student){
        studentMap.put(student.getName(),student);
    }

    public void addTeacherDB(Teacher teacher){
        teacherMap.put(teacher.getName(),teacher);
    }

    public void addStudentTeacherPairDB(String studentName,String teacherName){
        Teacher teacher = teacherMap.get(teacherName);
        if(pairMap.containsKey(teacher)){
            pairMap.get(teacher).add(studentMap.get(studentName));
        }else{
            List<Student> list = new ArrayList<>();
            list.add(studentMap.get(studentName));
            pairMap.put(teacher,list);
        }
    }

    public Student getStudentByNameDB(String studentName){
        return studentMap.get(studentName);
    }

    public Teacher getTeacherByNameDB(String teacherName){
        return teacherMap.get(teacherName);
    }

    public List<String> getStudentsByTeacherNameDB(String teacherName){
        List<String> list = new ArrayList<>();
        for(Student student:pairMap.get(teacherMap.get(teacherName))){
            list.add(student.getName());
        }
        return list;
    }

    public List<String> getAllStudentsDB(){
        List<String> list = new ArrayList<>();
        for(Student student: studentMap.values()){
            list.add(student.getName());
        }
        return list;
    }

    public void deleteTeacherByNameDB(String teacherName){
        Teacher teacher = teacherMap.get(teacherName);
        teacherMap.remove(teacherName);
        List<Student> list = pairMap.get(teacher);
        pairMap.remove(teacher);
        for(Student student:list){
            studentMap.remove(student.getName());
        }
    }

    public void deleteAllTeachersDB(){
        for(String teacherName:teacherMap.keySet()) {
            deleteTeacherByNameDB(teacherName);
        }
    }
}
