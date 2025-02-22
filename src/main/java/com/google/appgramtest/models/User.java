package com.google.appgramtest.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 2,max = 20,message = "The Naame Must Be At Least 2 Letters And Maximam 20 Letters")
    @NotBlank(message = "The Name Must Not Be Blank")
    @UniqueElements
    private String name;
    private String bio;
    @Email(message = "Invalid Email Format")
    @NotBlank(message ="The Email Must Not Be Blank" )
    private String email;
    @Size(min = 8,message = "Password Must Be At Least 8 Characters")
    @NotBlank(message = "The Password Must Not Be Blank")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}",message = "Password Must Contain Capital Character And Spechial Sympole And At Least 8 Charcter Long")
    private String password;
    private int followers;
    private int following;
    private int postNum;
    @OneToMany(mappedBy ="user",cascade =CascadeType.ALL,orphanRemoval = true)
    private List<Post> post;
}

