package com.dash.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dash.rest.dto.MyGuestsDto;
import com.dash.rest.dto.WrapperDto;
import com.dash.rest.entity.MyGuests;
import com.dash.rest.repository.MyGuestsRepository;
import com.dash.rest.util.ObjectConverter;

@Service
public class MyGuestsService {

	@Autowired
	MyGuestsRepository myGuestsRepository;
	
	public WrapperDto addMyGuest(MyGuestsDto guest) {
		WrapperDto reponse = new WrapperDto();
		try {
			myGuestsRepository.save(ObjectConverter.myguestsDtotoMyguest(guest));
			reponse.setResponse("Guest Sucessfully Added");
		} catch (Exception e) {
			reponse.setResponse("Problem while adding Guest"+e);
			e.printStackTrace();
		}
		return reponse;
	}
	
	public WrapperDto getGuestList() {
		WrapperDto reponse = new WrapperDto();
		List<MyGuests> entityList = new ArrayList<MyGuests>();
		List<MyGuestsDto> dtoList = new ArrayList<MyGuestsDto>();
		try {
			entityList = myGuestsRepository.findAll();
			for (MyGuests guest : entityList) {
				MyGuestsDto obj = new MyGuestsDto();
				obj = ObjectConverter.myGueststoMyguestDto(guest);
				dtoList.add(obj);
			}
			reponse.setResponse("Guest List Sucessfully Fetched");
			reponse.setMyGuestDtoList(dtoList);
		} catch (Exception e) {
			reponse.setResponse("Problem while Fetching Guest" + e);
			e.printStackTrace();
		}
		return reponse;
	}
}
