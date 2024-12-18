package com.my_blog_app_2.services;

import com.my_blog_app_2.payload.CommentDto;
import com.my_blog_app_2.payload.PostWithCommentDto;

import javax.validation.Valid;
import java.util.List;

public interface CommentService
{
    CommentDto createComment(CommentDto commentDto,long id);

    PostWithCommentDto getCommentByPost(long id);
}
