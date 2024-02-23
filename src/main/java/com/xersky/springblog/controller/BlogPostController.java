package com.xersky.springblog.controller;

import com.xersky.springblog.dto.BlogPostDTO;
import com.xersky.springblog.entity.BlogPost;
import com.xersky.springblog.service.BlogPostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(path = "api/posts")
public class BlogPostController {

    private final BlogPostService blogPostService;
    private final ModelMapper modelMapper;

    @Autowired
    public BlogPostController(BlogPostService blogPostService, ModelMapper modelMapper) {
        this.blogPostService = blogPostService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<BlogPostDTO> getPosts() {
        List<BlogPost> blogPosts = blogPostService.getBlogPosts();
        return blogPosts.stream()
                .map(blogPost -> modelMapper.map(blogPost, BlogPostDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "{id}")
    public BlogPostDTO getPostById(@PathVariable("id") int id) {
        BlogPost blogPost = blogPostService.getBlogPostById(id);
        return modelMapper.map(blogPost, BlogPostDTO.class);
    }

    @PostMapping()
    public void createPost(@RequestBody BlogPost blogPost) {
        blogPostService.createBlogPost(blogPost);
    }

    @PutMapping(path = "{id}")
    public void updatePost(@PathVariable("id") int id,
                           @RequestBody BlogPost blogPost) {
        blogPostService.updateBlogPost(id, blogPost.getTitle(), blogPost.getContent());
    }

    @DeleteMapping(path = "{id}")
    public void deletePost(@PathVariable("id") int id) {
        blogPostService.deleteBlogPost(id);
    }

}
