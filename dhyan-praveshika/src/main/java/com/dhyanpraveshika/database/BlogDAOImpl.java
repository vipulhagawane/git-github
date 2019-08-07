package com.dhyanpraveshika.database;

import org.springframework.stereotype.Repository;

import com.dhyanpraveshika.model.Blog;

@Repository
public class BlogDAOImpl extends GenericDAOImpl<Blog, Long> implements BlogDAO {

}
