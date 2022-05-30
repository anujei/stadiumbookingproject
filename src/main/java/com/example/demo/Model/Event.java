package com.example.demo.Model;

import javax.persistence.Entity;

import java.util.Date;

import javax.persistence.*;
import javax.persistence.Table;

@Entity

@Table(name = "event")
public class Event {


 	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
 	private int Eventid;	
 	@Column
 	private String Title;
 	@Column
 	private String Description;
	@Column
	String DateTime;
 	@Column
 	private Boolean Status;
	@Column
 	private String Venue;
	@Column
 	private int TotalSeats;
 	
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Event(int eventid, String title, String description, String dateTime, Boolean status, String venue,
			int totalSeats, User user) {
		super();
		Eventid = eventid;
		Title = title;
		Description = description;
		DateTime = dateTime;
		Status = status;
		Venue = venue;
		TotalSeats = totalSeats;
	//	this.user = user;
	}
	

	
	 @Override
	public String toString() {
		return "Event [Eventid=" + Eventid + ", Title=" + Title + ", Description=" + Description + ", DateTime="
				+ DateTime + ", Status=" + Status + ", Venue=" + Venue + ", TotalSeats=" + TotalSeats + "]";
	}

//", user=" + user+ 

	public int getEventid() {
		return Eventid;
	}



	public void setEventid(int eventid) {
		Eventid = eventid;
	}



	public String getTitle() {
		return Title;
	}



	public void setTitle(String title) {
		Title = title;
	}



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}



	public String getDateTime() {
		return DateTime;
	}



	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}



	public Boolean getStatus() {
		return Status;
	}



	public void setStatus(Boolean status) {
		Status = status;
	}



	public String getVenue() {
		return Venue;
	}



	public void setVenue(String venue) {
		Venue = venue;
	}



	public int getTotalSeats() {
		return TotalSeats;
	}



	public void setTotalSeats(int totalSeats) {
		TotalSeats = totalSeats;
	}



//	public User getUser() {
//		return user;
//	}
//
//
//
//	public void setUser(User user) {
//		this.user = user;
//	}




//	@ManyToOne
//	    @JoinColumn(name = "fk_user_id" )
//	    private User user;
	
	
}

