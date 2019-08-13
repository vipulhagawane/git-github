package com.dhyanpraveshika.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dhyanpraveshika.database.DonationDAO;
import com.dhyanpraveshika.entity.Donation;

@Service
@Transactional
public class DonationServiceImpl implements DonationService {
	
	private static final Logger logger = LoggerFactory.getLogger(DonationServiceImpl.class);
	
	@Autowired
	private DonationDAO donationDAO;

	@Override
	public List<Donation> getDonations() {
		logger.info("Fetching donation list");
		
		List<Donation> donations = donationDAO.findAll();
		logger.info("donation list :{}",donations);
		
		return donations;
	}

}
