package com.google.appgramtest.repo;
import com.google.appgramtest.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo  extends JpaRepository<Post,Integer> {
List<Post>findByUser_id(int userId);
}
