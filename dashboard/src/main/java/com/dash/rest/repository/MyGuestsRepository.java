package com.dash.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dash.rest.entity.MyGuests;

public interface MyGuestsRepository extends JpaRepository<MyGuests,Long>{
}
