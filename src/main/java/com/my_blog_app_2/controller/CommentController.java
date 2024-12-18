package com.my_blog_app_2.controller;

import com.my_blog_app_2.payload.CommentDto;
import com.my_blog_app_2.payload.PostWithCommentDto;
import com.my_blog_app_2.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/my-blog-app-2/comment")
public class CommentController
{
    @Autowired
    private CommentService commentService;

    //http://localhost:8080/api/my-blog-app-2/comment/1
    @PostMapping("/{id}")
    public ResponseEntity<?> createComment(@Valid @PathVariable long id,@RequestBody CommentDto commentDto,
                                           BindingResult bindingResult)
    {
        CommentDto commentDtos=commentService.createComment(commentDto,id);
        return new ResponseEntity<>(commentDtos, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCommentsByPost(@PathVariable long id)
    {
        PostWithCommentDto postWithCommentDto=commentService.getCommentByPost(id);
        return new ResponseEntity<>(postWithCommentDto,HttpStatus.OK);
    }
}
