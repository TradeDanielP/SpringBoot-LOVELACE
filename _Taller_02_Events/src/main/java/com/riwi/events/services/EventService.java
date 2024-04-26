package com.riwi.events.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.events.entites.Event;
import com.riwi.events.repositories.EventRepository;
import com.riwi.events.services.abstract_service.IEventService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService implements IEventService{

    @Autowired
    private final EventRepository objRepository;
    
    @Override
    public Event save(Event objEvent) {
      return this.objRepository.save(objEvent);
    }

    @Override
    public List<Event> getAll() {
        return this.objRepository.findAll();
    }

    @Override
    public Event getById(String id) {
        return this.objRepository.findById(id).orElseThrow(null);
    }

    @Override
    public void delete(String id) {
        Event event = this.objRepository.findById(id).orElseThrow();

        this.objRepository.delete(event);
    }

    @Override
    public Event update(Event objEvent) {
        return this.objRepository.save(objEvent);
    }
    
    
}
