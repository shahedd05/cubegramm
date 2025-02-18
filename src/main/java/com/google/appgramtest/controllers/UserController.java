package com.google.appgramtest.controllers;

import com.google.appgramtest.models.User;
import com.google.appgramtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/create")
    public String saveUser(@RequestBody User user){
       return userService.saveUser(user);

   }
   @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id){
       return userService.getUser(id);
   }
   @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user){
   return userService.updateUser(user,id);
   }
@DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
}
@GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUseres();
}
}
