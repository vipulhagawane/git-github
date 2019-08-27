package com.dps.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dps.model.EventDetails;

@Repository
public interface EventDetailsRepo extends CrudRepository<EventDetails, Long> {

}
