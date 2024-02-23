package com.xersky.springblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="authors")
public class Author{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    List<BlogPost> blogPosts;

}
