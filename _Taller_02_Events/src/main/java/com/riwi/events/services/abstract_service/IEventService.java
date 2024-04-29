package com.riwi.events.services.abstract_service;

import org.springframework.data.domain.Page;

import com.riwi.events.entites.Event;

public interface IEventService {

    public Event save(Event objEvent);

    public Page<Event> getAll(int page, int size);

    public Event getById(String id);

    public void delete(String id);

    public Event update(Event objEvent);

    
}
