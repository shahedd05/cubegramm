package com.google.appgramtest.repo;

import com.google.appgramtest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
   User getUserByName(String name);
}
