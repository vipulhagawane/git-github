package com.dhyanpraveshika.database;

import org.springframework.stereotype.Repository;

import com.dhyanpraveshika.model.DPSEvent;

@Repository
public class EventDAOImpl extends GenericDAOImpl<DPSEvent, Long> implements EventDAO {

}
