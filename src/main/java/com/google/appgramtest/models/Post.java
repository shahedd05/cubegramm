package com.google.appgramtest.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int share;
    @Column(name = "likeCount")
    private int likeCount;
    private String description;
    private String loction;
    private String image;

}
