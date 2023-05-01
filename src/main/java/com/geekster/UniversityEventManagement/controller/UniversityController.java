package com.geekster.UniversityEventManagement.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.geekster.UniversityEventManagement.Util.UniversityValidation;
import com.geekster.UniversityEventManagement.model.Event;
import com.geekster.UniversityEventManagement.model.Student;
import com.geekster.UniversityEventManagement.service.EventService;
import com.geekster.UniversityEventManagement.service.StudentService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UniversityController {

    @Autowired
    EventService eventService;
    @Autowired
    StudentService studentService;

    @GetMapping(value = "/getAllStudents")
    public Iterable<Student> getAllStudents(){
        return studentService.getAllStudentRecords();
    }

    @GetMapping(value = "/getStudentById/{id}")
    public Optional<Student> getStudentById(@PathVariable String id){
        return studentService.getStudentBasedOnId(id);
    }

    @PostMapping(value = "/addStudentDetails")
    public String addStudentRecords(@RequestBody Student student) throws JsonProcessingException {
        JSONObject json=new JSONObject(student);
        List<String> validationList = UniversityValidation.EventValidation(json);
        if (validationList.isEmpty()) {
            Student students = UniversityValidation.setStudent(json);
            studentService.addStudentData(students);
            return "Student Saved Successfully";
        } else {
            return validationList.toString();
        }
    }

    @PutMapping(value = "/updateStudentRecordById/{id}")
    public String updateStudentRecord(@PathVariable int id,@RequestBody Student student){
//        JSONObject json=new JSONObject(student);
//        List<String> validationList = UniversityValidation.EventValidation(json);
//        if (validationList.isEmpty()) {
//            Student students = UniversityValidation.setStudent(json);
//           return studentService.updateStudentData(id,students);
//        } else {
//            return validationList.toString();
//        }
        return studentService.updateStudentData(id,student);
    }

    @DeleteMapping(value = "/deleteStudentRecordById/{id}")
    public String deleteStudentRecord(@PathVariable String id){
        return studentService.deleteStudentData(id);
    }


    //---------------------------------Event COntrolling---------------------------------------------------------


    @GetMapping(value = "/getAllEvents")
    public List<Event> getAllEvents(){
        return eventService.getAllEventsRecords();
    }

    @PostMapping(value = "/AddEventDetails")
    public String addEventRecords(@RequestBody Event event){
        return eventService.addEventsData(event);
    }

    @PutMapping(value = "/updateEventRecordById/{id}")
    public String updateEventRecord(@PathVariable String id,@RequestBody Event event){
        return eventService.updateEventData(id,event);
    }

    @DeleteMapping(value = "/deleteEventRecordById/{id}")
    public String deleteEventRecord(@PathVariable String id){
        return eventService.deleteEventData(id);
    }
}
