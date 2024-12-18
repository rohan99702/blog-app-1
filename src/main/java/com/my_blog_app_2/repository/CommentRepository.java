package com.my_blog_app_2.repository;

import com.my_blog_app_2.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long>
{

    List<Comment> findByPostId(long id);
}
