package com.xersky.springblog.controller;

import com.xersky.springblog.dto.BlogPostDTO;
import com.xersky.springblog.entity.BlogPost;
import com.xersky.springblog.service.BlogPostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class BlogPostPageController {

    private final BlogPostService blogPostService;
    private final ModelMapper modelMapper;

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable int id, Model model) {
        BlogPost blogPost = blogPostService.getBlogPostById(id);
        BlogPostDTO blogPostDTO = modelMapper.map(blogPost, BlogPostDTO.class);
        model.addAttribute("blogPost", blogPostDTO);
        return "post";
    }

}
