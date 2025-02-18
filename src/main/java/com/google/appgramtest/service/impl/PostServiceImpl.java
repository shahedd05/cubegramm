package com.google.appgramtest.service.impl;

import com.google.appgramtest.exception.ResourceNotFoundException;
import com.google.appgramtest.models.Post;
import com.google.appgramtest.repo.PostRepo;
import com.google.appgramtest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    PostRepo postRepo;
@Autowired
    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;

    }

    @Override
    public Post getPost(int id) {
       Post post=postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
               return post;
    }

    @Override
    public String savePost(Post post) {
        postRepo.save(post);
        return "the post has been uploaded";
    }

    @Override
    public String updatePost(Post post, int id) {
    Post updatepost=postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
    updatepost.setDescription(post.getDescription());
    updatepost.setImage(post.getImage());
    updatepost.setShare(post.getShare());
    updatepost.setLoction(post.getLoction());
    updatepost.setLikeCount(post.getLikeCount());
    postRepo.save(updatepost);
        return "The Post Has Been Updated Successfully -_- ";
    }

    @Override
    public String deletePost(int id) {
    postRepo.deleteById(id);
        return "The Post Has Been Deleted Successfully!";
    }

    @Override
    public List<Post> getAllPosts() {
  List<Post> posts=postRepo.findAll();
        return posts;
    }


}
