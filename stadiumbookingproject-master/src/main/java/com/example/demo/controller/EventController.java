package com.example.demo.controller;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.entity.Event;
import com.example.demo.service.EventService;


@RestController
@CrossOrigin
public class EventController {
	@Autowired
	private EventService eventService;
	
	@PostMapping("/createEvent")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<Event> createEvent(@RequestBody Event event)
	{
		eventService.createEvent(event); 
		return new ResponseEntity<Event>(eventService.createEvent(event),HttpStatus.CREATED);
	}
	 @GetMapping("/viewEvent")
	 @PreAuthorize("hasAnyRole('Admin','User')")
	 public Iterable<Event> viewEvent(){
	        return eventService.viewEvent();
	 }
	 
	 @DeleteMapping("/deleteEvent/{id}")
	 @PreAuthorize("hasRole('Admin')")
	 public void deleteEvent(@PathVariable("Eventid") int id) {
		 eventService.deleteEvent(id);
	 }
	 
	 @PostMapping("/UpdateEvent")
	 @PreAuthorize("hasRole('Admin')")
	 public Event UpdateEvent(@RequestBody Event event) {
		 eventService.Update(event);
		return event;
	 }
	
}
