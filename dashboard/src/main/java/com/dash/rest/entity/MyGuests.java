package com.dash.rest.entity;

import javax.persistence.Id;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="myguests")
public class MyGuests {
 
	@Id
	@GeneratedValue
	@Getter @Setter
	Long Id;
	
	@Getter
	@Setter
	@Column(name = "firstname")
	String firstName;
	
	@Getter
	@Setter
	@Column(name = "lastname")
	String lastName;
	
	@Getter
	@Setter
	@Column(name = "email")
	String email;
	
	@Getter
	@Setter
	@Column(name = "reg_date")
	Date regDate;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
