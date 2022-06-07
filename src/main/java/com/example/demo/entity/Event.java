package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "event")
public class Event {
 	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="eventid")
 	private int Eventid;
 	
 	@NotNull
 	@Column(name="title")
 	private String Title;
 	
 	@NotNull
 	@Column(name="description")
 	private String Description;
 	
 	@NotEmpty
	@Pattern(regexp="^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$",
	message="invalid Date format it should be dd/mm/yyyy format")
	@Column(name="DateTime")
	String DateTime;
 	
 	@NotNull
 	@Column(name="status")
 	private Boolean Status;
 	
 	@NotNull
	@Column(name="venue")
 	private String Venue;
 	
 	@NotNull
 	@Pattern(regexp="(^$|[0-9]{10})", message="only numeric allowed")
	@Column(name="totalseats")
 	private int TotalSeats;
 	
	//unidirectional one-to-many
	//Entity detail relationship
    @OneToMany(targetEntity =  Category.class ,cascade = CascadeType. ALL, fetch=FetchType.LAZY)
    @JoinColumn(name= "fk_eventid",referencedColumnName = "Eventid")
    private Set<Category> category;
}

