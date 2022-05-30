package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Event;
import com.example.demo.Model.User;
import com.example.demo.Service.EventService;
import com.example.demo.Service.UserService;

@RestController
@CrossOrigin
public class EventController {
	@Autowired
	private EventService eventService;
	
	@PostMapping("/createEvent")
	public ResponseEntity<Event> createEvent(@RequestBody Event event)
	{
		eventService.createEvent(event); 
		return new ResponseEntity<Event>(eventService.createEvent(event),HttpStatus.CREATED);
	}
	 @GetMapping("/viewEvent")
	 public Iterable<Event> viewEvent(){
	        return eventService.findAll();
	 }
	 
	 @DeleteMapping("/deleteEvent/{id}")
	 public void deleteEvent(@PathVariable("Eventid") int id) {
		 eventService.deleteEvent(id);
	 }
	 
//	 	@PostMapping("/deleteEvent/{id}")
//		@ResponseBody
//		public Event deleteEvent (@PathVariable("Eventid") int id)
//		{
//			return eventService.deleteEvent(id);
//		}
}
