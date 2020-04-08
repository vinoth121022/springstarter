package com.dash.rest.util;

import com.dash.rest.dto.MyGuestsDto;
import com.dash.rest.entity.MyGuests;

public class ObjectConverter {

	public static MyGuests myguestsDtotoMyguest(MyGuestsDto obj)
	{
		MyGuests entity=new MyGuests();
		entity.setEmail(obj.getEmail());
		entity.setFirstName(obj.getFirstName());
		entity.setLastName(obj.getLastName());
		entity.setRegDate(obj.getRegDate());
		return entity;
	}
	
	public static MyGuestsDto myGueststoMyguestDto(MyGuests entity)
	{
		MyGuestsDto obj=new MyGuestsDto();
		System.out.println(entity.getFirstName());
		obj.setId(entity.getId());
		obj.setEmail(entity.getEmail());
		obj.setFirstName(entity.getFirstName());
		obj.setLastName(entity.getLastName());
		obj.setRegDate(entity.getRegDate());
		return obj;
	}
}
