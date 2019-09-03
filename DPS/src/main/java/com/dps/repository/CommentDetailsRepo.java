package com.dps.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dps.model.CommentDetails;


@Repository
public interface CommentDetailsRepo extends JpaRepository<CommentDetails, Long>{

//	Page<CommentDetails> findByBlogId(Long blogId, Pageable pageable);
	
}
