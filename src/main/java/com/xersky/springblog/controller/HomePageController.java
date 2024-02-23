package com.xersky.springblog.controller;

import com.xersky.springblog.dto.BlogPostDTO;
import com.xersky.springblog.entity.BlogPost;
import com.xersky.springblog.service.BlogPostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomePageController {

    private final BlogPostService blogPostService;
    private final ModelMapper modelMapper;

    @GetMapping("/")
    public String homePage(Model model) {
        List<BlogPost> blogPosts = blogPostService.getBlogPosts();
        List<BlogPostDTO> blogPostDTOs = blogPosts.stream()
                .map(blogPost -> modelMapper.map(blogPost, BlogPostDTO.class))
                .toList();
        model.addAttribute("blogPosts", blogPostDTOs);
        return "index";
    }
}
