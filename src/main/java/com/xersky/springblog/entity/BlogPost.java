package com.xersky.springblog.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="blog_posts")
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;


    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private Author author;

    private LocalDate publicationDate;

    public BlogPost(String title, String content, Author author, LocalDate publicationDate) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.publicationDate = publicationDate;
    }

}
