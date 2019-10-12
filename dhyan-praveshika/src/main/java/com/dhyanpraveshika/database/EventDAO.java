package com.dhyanpraveshika.database;

import java.util.List;

import com.dhyanpraveshika.entity.DPSEvent;

public interface EventDAO extends GenericDAO<DPSEvent, Long> {

	List<DPSEvent> getEventsByDesc();

}
