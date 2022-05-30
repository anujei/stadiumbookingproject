package com.example.demo.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
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
    
    //Order detail relationship
    
    
	public Event(int eventid, String title, String description, String dateTime, Boolean status, String venue,
			int totalSeats, Set<Category> category) {
		super();
		Eventid = eventid;
		Title = title;
		Description = description;
		DateTime = dateTime;
		Status = status;
		Venue = venue;
		TotalSeats = totalSeats;
		this.category = category;
	}
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Set<Category> getCategory() {
		return category;
	}
	public void setCategory(Set<Category> category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Event [Eventid=" + Eventid + ", Title=" + Title + ", Description=" + Description + ", DateTime="
				+ DateTime + ", Status=" + Status + ", Venue=" + Venue + ", TotalSeats=" + TotalSeats + ", category="
				+ category + "]";
	}
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

}

