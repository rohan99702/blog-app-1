package com.my_blog_app_2.services.impl;

import com.my_blog_app_2.entity.Post;
import com.my_blog_app_2.payload.ListPostDto;
import com.my_blog_app_2.payload.PostDto;
import com.my_blog_app_2.repository.PostRepository;
import com.my_blog_app_2.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceimpl implements PostService
{
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    Post mapToEntity (PostDto postDto){return modelMapper.map(postDto,Post.class);}
    PostDto mapToDto(Post post){return modelMapper.map(post,PostDto.class);}

    @Override
    public PostDto createPost(PostDto postDto)
    {
        return mapToDto(postRepository.save(mapToEntity(postDto)));
    }

    @Override
    public ListPostDto getAllPost(int pageNo, int pageSize, String sortBy, String sortDir)
    {
        Sort sort=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBy).ascending():Sort.by(sortBy).descending();

        Pageable pageable= PageRequest.of(pageNo,pageSize,sort);
        Page<Post> posts=postRepository.findAll(pageable);
        List<Post> post=posts.getContent();
        List<PostDto> postdto=post.stream().map(n->mapToDto(n)).collect(Collectors.toList());

        ListPostDto listPostDto=new ListPostDto();

         listPostDto.setPostDtoList(postdto);
         listPostDto.setFirst(posts.isFirst());
         listPostDto.setLast(posts.isLast());
         listPostDto.setPageSize(posts.getSize());
         listPostDto.setPageNo(posts.getNumber());
         listPostDto.setTotalPage(posts.getTotalPages());

         return listPostDto;
    }

}
