package com.example.demo.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@Table(name = "event")
public class Event {
 	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="eventid")
 	private int Eventid;	
 	@Column(name="title")
 	private String Title;
 	@Column(name="description")
 	private String Description;
	@Column(name="DateTime")
	String DateTime;
 	@Column(name="status")
 	private Boolean Status;
	@Column(name="venue")
 	private String Venue;
	@Column(name="totalseats")
 	private int TotalSeats;
 	
	//unidirectional one-to-many
	//Entity detail relationship
    @OneToMany(targetEntity =  Category.class ,cascade = CascadeType. ALL, fetch=FetchType.LAZY)
    @JoinColumn(name= "fk_eventid",referencedColumnName = "Eventid")
    private Set<Category> category;

//	public Event(int eventid, String title, String description, String dateTime, Boolean status, String venue,
//			int totalSeats, Set<Category> category) {
//		super();
//		Eventid = eventid;
//		Title = title;
//		Description = description;
//		DateTime = dateTime;
//		Status = status;
//		Venue = venue;
//		TotalSeats = totalSeats;
//		this.category = category;
//	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(int eventid, String title, String description, String dateTime, boolean status, String venue,
			int totalSeats, Category category) {
		// TODO Auto-generated constructor stub
	}
    
    //Order detail relationship
    
    
    

}

