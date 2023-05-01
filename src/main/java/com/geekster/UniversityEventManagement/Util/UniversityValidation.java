package com.geekster.UniversityEventManagement.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geekster.UniversityEventManagement.model.Department;
import com.geekster.UniversityEventManagement.model.Event;
import com.geekster.UniversityEventManagement.model.Student;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class UniversityValidation {


    public static List<String> EventValidation(JSONObject json) {
        List<String> errors = new ArrayList<>();

        if (json.getInt("age")<18 || json.getInt("age")>25) {
            errors.add("AGE:- age is not between 18 to 25");
        }
        if (json.getString("firstName").charAt(0)>='a' && json.getString("firstName").charAt(0)<='z') {
            errors.add("FIRSTNAME:- first letter should be capital");
        }
        return  errors;
    }

    public static Event setEvent(JSONObject json) {
        Event event = new Event();
        event.setEventName(json.getString("eventName"));
        event.setLocationOfEvent(json.getString("locationOfEvent"));
        String date=json.getString("date");
        LocalDate date1=LocalDate.parse(date);
        event.setDate(date1);
        String time=json.getString("startTime");
        LocalTime time1=LocalTime.parse(time);
        event.setStartTime(time1);
        String time2=json.getString("endTime");
        LocalTime time3=LocalTime.parse(time2);
        event.setEndTime(time3);
        return event;
    }

    public static Student setStudent(JSONObject json) throws JsonProcessingException {
        Student student = new Student();
        student.setFirstName(json.getString("firstName"));
        student.setLastName(json.getString("lastName"));
        student.setAge(json.getInt("age"));
        student.setDepartment(json.getEnum(Department.class,"department"));
        return student;
    }
}
