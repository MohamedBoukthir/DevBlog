package com.mohamed.blog.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    // one user can create multi posts but one post can create by only one user
    @ManyToOne
    private User user;

    private String image;

    private String description;

    private boolean stack;

    private LocalDate createdAt;


    private List<Long> likes = new ArrayList<>();

}
