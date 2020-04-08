package com.dash.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.dash.rest.dto.MyGuestsDto;
import com.dash.rest.dto.WrapperDto;
import com.dash.rest.service.MyGuestsService;
import lombok.extern.log4j.Log4j2;


@Log4j2
@RestController
@RequestMapping("/myguestscontroller")
public class MyGuestsController {
	
	//private Logger log = Logger.getLogger(MyGuestsController.class);
	 
	@Autowired
	MyGuestsService myguestsservice;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public WrapperDto addGuest(@RequestBody MyGuestsDto guest) {
		//logger.info("hERE wE gO ");
		return myguestsservice.addMyGuest(guest);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public WrapperDto getGuestList() {		
		return myguestsservice.getGuestList();
	}
	
	
}
