package com.my_blog_app_2.payload;

import java.util.List;

public class PostWithCommentDto
{
    private PostDto postDto;
    private List<CommentDto> commentDto;

    public PostDto getPostDto() {
        return postDto;
    }

    public void setPostDto(PostDto postDto) {
        this.postDto = postDto;
    }

    public List<CommentDto> getCommentDto() {
        return commentDto;
    }

    public void setCommentDto(List<CommentDto> commentDto) {
        this.commentDto = commentDto;
    }
}
