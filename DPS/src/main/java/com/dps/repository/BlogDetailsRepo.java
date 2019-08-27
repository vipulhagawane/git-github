package com.dps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dps.model.BlogDetails;

@Repository
public interface BlogDetailsRepo extends CrudRepository<BlogDetails, Long>{

	
	@Query("SELECT b FROM BlogDetails b WHERE b.author=:searchParam OR b.category =:searchParam OR b.title=:searchParam") 
    BlogDetails searchByParam(@Param("searchParam")String searchParam);
	
}
