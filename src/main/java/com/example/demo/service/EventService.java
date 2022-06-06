package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.EventDao;
import com.example.demo.entity.Event;

@Service
public class EventService {

	@Autowired
	EventDao eventDao;
	public Event createEvent(Event event)
	{
		return eventDao.save(event); 
	}
	public Iterable<Event> findAll() {
        return eventDao.findAll();
    }
	public void deleteEvent(int Eventid) {
		eventDao.deleteById(Eventid);
	}
	public Event Update(Event event)
	{
		return eventDao.save(event); 
	}
}
