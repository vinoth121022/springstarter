package com.dash.rest.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class WrapperDto implements Serializable {

	private static final long serialVersionUID = 1L;
	String response;
	List<MyGuestsDto> myGuestDtoList=new ArrayList<MyGuestsDto>();
	public List<MyGuestsDto> getMyGuestDtoList() {
		return myGuestDtoList;
	}
	public void setMyGuestDtoList(List<MyGuestsDto> myGuestDtoList) {
		this.myGuestDtoList = myGuestDtoList;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
}
