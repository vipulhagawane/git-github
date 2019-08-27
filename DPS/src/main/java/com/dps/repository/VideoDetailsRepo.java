package com.dps.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dps.model.VideoDetails;

@Repository
public interface VideoDetailsRepo extends CrudRepository<VideoDetails, Long> {

}
