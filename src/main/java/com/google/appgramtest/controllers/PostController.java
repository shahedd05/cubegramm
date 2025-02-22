package com.google.appgramtest.controllers;

import com.google.appgramtest.models.Post;
import com.google.appgramtest.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    PostService postService;
@Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

@PostMapping("/post/create")
    public String savePost(@Valid @RequestBody Post post){
        return postService.savePost(post);
}
    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable int id){
        return postService.getPost(id);
    }
    @PostMapping("/post/update/{id}")
   public String updatePost(@RequestBody Post post,@Valid@PathVariable int id){
    return postService.updatePost(post,id);
    }
@DeleteMapping("/post/delete/{id}")
    public String deletePost(@PathVariable int id){
    return postService.deletePost(id);
}
@GetMapping("/posts")
    public List<Post> getALlPosts(){
    return postService.getAllPosts();
}
@GetMapping("/user/{id}/posts")
    public List<Post> findByUser_Id(@PathVariable int id){
    return postService.findByUser_Id(id);
}

}
