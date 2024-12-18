package com.my_blog_app_2.repository;

import com.my_blog_app_2.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long>
{

}