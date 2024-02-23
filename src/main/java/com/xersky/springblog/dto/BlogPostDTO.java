package com.xersky.springblog.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BlogPostDTO {
    private int id;
    private String title;
    private String content;
    private AuthorDTO author;
    private LocalDate publicationDate;
}
