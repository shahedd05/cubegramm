package com.google.appgramtest.repo;
import com.google.appgramtest.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo  extends JpaRepository<Post,Integer> {

}
