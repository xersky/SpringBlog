package com.xersky.springblog;

import com.xersky.springblog.entity.Author;
import com.xersky.springblog.entity.BlogPost;
import com.xersky.springblog.repository.BlogPostRepository;
import com.xersky.springblog.service.BlogPostService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BlogPostServiceTest {

    @InjectMocks
    private BlogPostService blogPostService;

    @Mock
    private BlogPostRepository blogPostRepository;

    @Test
    public void testCreateBlogPost() {

        Author author = new Author();

        BlogPost newBlogPost = new BlogPost("New Blog Post", "Content", author, LocalDate.now());


        when(blogPostRepository.save(any(BlogPost.class))).thenReturn(newBlogPost);


        BlogPost createdBlogPost = blogPostService.createBlogPost(newBlogPost);


        assertNotNull(createdBlogPost);
        assertEquals("New Blog Post", createdBlogPost.getTitle());
        assertEquals("Content", createdBlogPost.getContent());
        verify(blogPostRepository, times(1)).save(any(BlogPost.class));
    }
}