package com.example.demo.Model;

import java.util.Date;
import java.util.List;
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
import javax.transaction.Transactional;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Table(name = "user")
public class User {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column
	 	private int Userid;	
	 	@Column
	 	private String Password;
	 	@Column
	 	private String Name;
		@Column
	 	private String EmailId;
		@Column
	 	private int MobileNo;
		@Column
		private String DateOfBirth;
	 	
	 	private String Address;
		@Column
	 	private int PinCode;
		@Column
	 	private String State;
	 	@Column
	 	private String City;
		public int getUserid() {
			return Userid;
		}
		
		
		
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}



		public User(int userid, String password, String name, String emailId, int mobileNo, String dateOfBirth,
				String address, int pinCode, String state, String city, Set<Event> event) {
			super();
			Userid = userid;
			Password = password;
			Name = name;
			EmailId = emailId;
			MobileNo = mobileNo;
			DateOfBirth = dateOfBirth;
			Address = address;
			PinCode = pinCode;
			State = state;
			City = city;
			this.event = event;
		}


		public void setUserid(int userid) {
			Userid = userid;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getEmailId() {
			return EmailId;
		}
		public void setEmailId(String emailId) {
			EmailId = emailId;
		}
		public int getMobileNo() {
			return MobileNo;
		}
		public void setMobileNo(int mobileNo) {
			MobileNo = mobileNo;
		}
		public String getDateOfBirth() {
			return DateOfBirth;
		}
		public void setDateOfBirth(String dateOfBirth) {
			DateOfBirth = dateOfBirth;
		}
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			Address = address;
		}
		public int getPinCode() {
			return PinCode;
		}
		public void setPinCode(int pinCode) {
			PinCode = pinCode;
		}
		public String getState() {
			return State;
		}
		public void setState(String state) {
			State = state;
		}
		public String getCity() {
			return City;
		}
		public void setCity(String city) {
			City = city;
		}
	 	
	 	
	    
		public Set<Event> getEvent() {
			return event;
		}

		public void setEvent(Set<Event> event) {
			this.event = event;
		}


		@Override
		public String toString() {
			return "User [Userid=" + Userid + ", Password=" + Password + ", Name=" + Name + ", EmailId=" + EmailId
					+ ", MobileNo=" + MobileNo + ", DateOfBirth=" + DateOfBirth + ", Address=" + Address + ", PinCode="
					+ PinCode + ", State=" + State + ", City=" + City + ", event=" + event + "]";
		}
	    
//		//unidirectional one-to-many
//	    @OneToMany(mappedBy = "user" ,cascade = CascadeType. ALL, fetch=FetchType.LAZY)
//	   
//	    private Set<Event> event;
	    
	  //unidirectional one-to-many
	    @OneToMany(targetEntity =  Event.class ,cascade = CascadeType. ALL, fetch=FetchType.LAZY)
	   @JoinColumn(name= "fk_id",referencedColumnName = "Userid")
	    private Set<Event> event;

}
