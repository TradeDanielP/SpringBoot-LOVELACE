package com.riwi.events.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.events.entites.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, String>{

    public List<Event> findByName(String name);

}