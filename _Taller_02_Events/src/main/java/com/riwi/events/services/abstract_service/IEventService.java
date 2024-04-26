package com.riwi.events.services.abstract_service;

import java.util.List;
import com.riwi.events.entites.Event;

public interface IEventService {

    public Event save(Event objEvent);

    public List<Event> getAll();

    public Event getById(String id);

    public void delete(String id);

    public Event update(Event objEvent);

    
}
