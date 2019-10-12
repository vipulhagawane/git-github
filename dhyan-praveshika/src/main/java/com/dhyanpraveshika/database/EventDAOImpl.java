package com.dhyanpraveshika.database;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.dhyanpraveshika.entity.DPSEvent;

@Repository
public class EventDAOImpl extends GenericDAOImpl<DPSEvent, Long> implements EventDAO {

	@Override
	public List<DPSEvent> getEventsByDesc() {
		String hql = "select e from DPSEvent e order by e.eventDate desc";
		Query query = entityManager.createQuery(hql);
		return query.getResultList();
	}
}
