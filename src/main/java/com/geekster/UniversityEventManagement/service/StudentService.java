package com.geekster.UniversityEventManagement.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geekster.UniversityEventManagement.model.Student;
import com.geekster.UniversityEventManagement.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    IStudentRepository studentRepository;

    public Iterable<Student> getAllStudentRecords() {
        Iterable<Student> students=studentRepository.findAll();
        return students;
    }

    public Optional<Student> getStudentBasedOnId(String id) {
        int studentId=Integer.parseInt(id);
        Optional<Student> student=studentRepository.findById(studentId);
        if(student!=null)
            return student;
        else
            return null;
    }

    public String addStudentData(Student student) {
        Student students=studentRepository.save(student);
        if(students!=null)
            return "Student Saved Successfully...!!!";
        else
            return "Failed to save Student";
    }

    public String updateStudentData(int id,Student student) {
        Iterable<Student> students=studentRepository.findAll();
        for(Student student1:students){
            if(student1.getStudentId()==(id)){
                 student1.setFirstName(student.getFirstName());
                 student1.setLastName(student.getLastName());
                 student1.setAge(student.getAge());
                 student1.setDepartment(student.getDepartment());
                 return "Student updated Successfully..!!!";
            }
        }
        return "Cannot update Student";
    }

    public String deleteStudentData(String id) {
        int studentId=Integer.parseInt(id);
        if(id!=null){
            studentRepository.deleteById(studentId);
            return "Student with "+id+" has been deleted";
        }
        else
           return "Deletion with "+id+" id not possible";
    }
}
