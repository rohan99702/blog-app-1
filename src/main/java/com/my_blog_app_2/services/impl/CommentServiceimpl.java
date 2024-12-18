package com.my_blog_app_2.services.impl;

import com.my_blog_app_2.entity.Comment;
import com.my_blog_app_2.entity.Post;
import com.my_blog_app_2.payload.CommentDto;
import com.my_blog_app_2.payload.PostDto;
import com.my_blog_app_2.payload.PostWithCommentDto;
import com.my_blog_app_2.repository.CommentRepository;
import com.my_blog_app_2.repository.PostRepository;
import com.my_blog_app_2.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceimpl implements CommentService
{
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PostRepository postRepository;

    Comment mapToEntity(CommentDto commentDto){return modelMapper.map(commentDto,Comment.class);}
    CommentDto mapToDto(Comment comment){return modelMapper.map(comment,CommentDto.class);}
    PostDto mapToPostDto(Post post){return modelMapper.map(post,PostDto.class);}

    @Override
    public CommentDto createComment(CommentDto commentDto,long id)
    {
       Comment comment=mapToEntity(commentDto);
       Post post=postRepository.findById(id).get();
       comment.setPost(post);
       Comment savedComment=commentRepository.save(comment);
       return mapToDto(comment);
    }

    @Override
    public PostWithCommentDto getCommentByPost(long id)
    {
     List<Comment> comments=commentRepository.findByPostId(id);
     List<CommentDto> commentDtos=comments.stream().map(n->mapToDto(n)).collect(Collectors.toList());

     Post post=postRepository.findById(id).get();
     PostDto postDto=mapToPostDto(post);

     PostWithCommentDto postWithCommentDto=new PostWithCommentDto();
     postWithCommentDto.setPostDto(postDto);
     postWithCommentDto.setCommentDto(commentDtos);

     return postWithCommentDto;
    }
}
