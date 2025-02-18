package com.google.appgramtest.service.impl;

import com.google.appgramtest.exception.ResourceNotFoundException;
import com.google.appgramtest.models.User;
import com.google.appgramtest.repo.UserRepo;
import com.google.appgramtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    UserRepo userRepo;
    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User getUser(int id) {
        User user=userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));
        return user;
    }
    @Override
    public String saveUser(User user) {
        userRepo.save(user);
        return "user created successfully";
    }

    @Override
    public String updateUser(User user, int id) {
        User person=userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));
        person.setName(user.getName());
        person.setBio(user.getBio());
        person.setEmail(user.getEmail());
        person.setFollowing(user.getFollowing());
        person.setFollowers(user.getFollowers());
        person.setPassword(user.getPassword());
        person.setPostNum(user.getPostNum());
        userRepo.save(person);
        return " User Updated Successfully -_-";
    }

    @Override
    public String deleteUser(int id) {
        userRepo.deleteById(id);
        return "User Deleted Successfuly!";
    }

    @Override
    public List<User> getAllUseres() {
        List<User> persons=userRepo.findAll();
        return persons;
    }


}
