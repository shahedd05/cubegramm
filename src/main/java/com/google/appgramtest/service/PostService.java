package com.google.appgramtest.service;


import com.google.appgramtest.models.Post;

import java.util.List;

public interface PostService {
Post getPost(int id);
String savePost(Post post);
String updatePost(Post post,int id);
String deletePost (int id);
List<Post> getAllPosts();
}
