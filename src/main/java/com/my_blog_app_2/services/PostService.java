package com.my_blog_app_2.services;

import com.my_blog_app_2.payload.ListPostDto;
import com.my_blog_app_2.payload.PostDto;

import java.util.List;

public interface PostService
{
    PostDto createPost(PostDto postDto);
    ListPostDto getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
}
