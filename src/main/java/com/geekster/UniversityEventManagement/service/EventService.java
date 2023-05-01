package com.geekster.UniversityEventManagement.service;

import com.geekster.UniversityEventManagement.model.Event;
import com.geekster.UniversityEventManagement.model.Student;
import com.geekster.UniversityEventManagement.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    IEventRepository eventRepository;


    public List<Event> getAllEventsRecords() {
        List<Event> events= (List<Event>) eventRepository.findAll();
        return events;
    }


    public String addEventsData(Event event) {
        Event events=eventRepository.save(event);
        if(events!=null)
            return "Event Saved Successfully...!!!";
        else
            return "Failed to save Student";
    }

    public String updateEventData(String id,Event event) {
        List<Event> events= (List<Event>) eventRepository.findAll();
        int eventId=Integer.parseInt(id);
        for(Event event1:events){
            if(event1.getEventId()==(eventId)){
                event1.setEventName(event.getEventName());
                event1.setLocationOfEvent(event.getLocationOfEvent());
                event1.setDate(event.getDate());
                event1.setStartTime(event.getStartTime());
                event1.setEndTime(event.getEndTime());
                return "Event updated Successfully..!!!";
            }
        }
        return "Cannot update Event";
    }

    public String deleteEventData(String id) {
        int eventId=Integer.parseInt(id);
        if(id!=null){
            eventRepository.deleteById(eventId);
            return "Event with "+id+" has been deleted";
        }
        else
            return "Deletion with "+id+" id not possible";
    }
}
