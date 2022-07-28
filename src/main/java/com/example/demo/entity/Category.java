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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="categoryid")
		private int Categoryid;
		
		@NotNull
		@Column(name="categorytitle")
		private String CategoryTitle;
		
		@NotNull
		@Column(name="price")
		@Pattern(regexp="(^$|[0-9]{10})", message="only numeric allowed")
		private Float price;
		
		@NotNull
		@Column(name="status")
		private boolean status;
		
		@NotNull
		@Column(name="no_of_seat")
		@Pattern(regexp="(^$|[0-9]{10})", message="only numeric allowed")
		private int NoOfSeat;
//		@JsonDeserialize(using = CustomParameterDeserializer.class)
		
		
		@ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="fk_eventid" ,nullable=false)
		@JsonBackReference
	    private Event event;
		
//		@OneToMany(targetEntity =  Event.class ,cascade = CascadeType. ALL, fetch=FetchType.LAZY)
//		@JoinColumn(name= "fk_eventid",referencedColumnName = "Eventid")
//	    private int fk_eventid;
		
		
		@ManyToMany(targetEntity =  OrderDetail.class ,cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	    @JoinColumn(name= "fk_categoryid",referencedColumnName = "Categoryid")
	    private Set<OrderDetail> orderdetail;		
}
