package com.dhyanpraveshika.database;

import org.springframework.stereotype.Repository;

import com.dhyanpraveshika.entity.Blog;

@Repository
public class BlogDAOImpl extends GenericDAOImpl<Blog, Long> implements BlogDAO {

}
