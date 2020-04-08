package com.dash.rest.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class MyGuestsDto implements Serializable {

	private static final long serialVersionUID = 1L;
	Long id;
	String firstName;
 	String lastName;
	Date regDate;
	String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
