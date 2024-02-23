package com.xersky.springblog.service;

import com.xersky.springblog.entity.BlogPost;
import com.xersky.springblog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public List<BlogPost> getBlogPosts() {
        return blogPostRepository.findAll();
    }

    public BlogPost getBlogPostById(int id) {
        return blogPostRepository.findById(id).orElse(null);
    }

    public BlogPost createBlogPost(BlogPost blogPost) {
       return blogPostRepository.save(blogPost);
    }

    public void updateBlogPost(int id, String title, String content) {
        //Checking if the blogPost desired to be updated exists
        boolean blogPostExists = blogPostRepository.existsById(id);

        if(!blogPostExists) {
            throw new IllegalStateException("Blog Post Update Failed - Blog Post with id=" + id + " doesn't exist");
        }
        //Updating the blogPost with information set
        BlogPost blogPost = getBlogPostById(id);
        blogPost.setTitle(title);
        blogPost.setContent(content);
        //changing the publicationDate to current time because the post got updated (business logic :D)
        //might also consider adding another attribute to differentiate between the creationDate and the lastEditedDate
        blogPost.setPublicationDate(LocalDate.now());
        blogPostRepository.save(blogPost);
    }

    public void deleteBlogPost(int id) {
        //Checking if the blogPost desired to be deleted exists
        boolean blogPostExists = blogPostRepository.existsById(id);
        //Throwing an exception if it doesn't exist
        if(!blogPostExists) {
            throw new IllegalStateException("Blog Post Deletion Failed - Blog Post with id=" + id + " doesn't exist");
        }
        blogPostRepository.deleteById(id);
    }


}
