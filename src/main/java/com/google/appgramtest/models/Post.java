package com.google.appgramtest.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int share;
    private int likeCount;
    private String description;
    private String loction;
    @NotBlank(message = "The Image Must Not Be Blank")
    private String image;
 @ManyToOne
 @JoinColumn(name = "user_id",nullable = false)
 @JsonBackReference
 private User user;
}
