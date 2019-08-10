package com.dhyanpraveshika.database;

import org.springframework.stereotype.Repository;

import com.dhyanpraveshika.model.Donation;

@Repository
public class DonationDAOImpl extends GenericDAOImpl<Donation, Long> implements DonationDAO {

}
