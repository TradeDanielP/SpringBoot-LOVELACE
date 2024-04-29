package com.riwi.events.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.events.entites.Event;
import com.riwi.events.services.abstract_service.IEventService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/event")
@AllArgsConstructor
public class EventController {

    @Autowired
    private final IEventService objIEventService;

    @GetMapping
    public ResponseEntity<Page<Event>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "2") int size){
        return ResponseEntity.ok(this.objIEventService.getAll(page -1, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Event> getById(@PathVariable String id){
        return ResponseEntity.ok(this.objIEventService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Event> insert(@RequestBody Event objEvent){
        LocalDate currentDate = LocalDate.now();
        LocalDate eventDate = objEvent.getDate();

        if (objEvent.getCapacity() < 0){
            return ResponseEntity.badRequest().body(null);
        } else if(eventDate.isBefore(currentDate)){
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(this.objIEventService.save(objEvent));
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Event> update(@RequestBody Event objEvent, @PathVariable String id){
        objEvent.setId(id);
        return ResponseEntity.ok(this.objIEventService.update(objEvent));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.objIEventService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
