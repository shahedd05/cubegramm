package com.google.appgramtest.controllers;

import com.google.appgramtest.models.User;
import com.google.appgramtest.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/create")
    public String saveUser(@ModelAttribute User user, @RequestParam("image") MultipartFile file) {
        return userService.saveUser(user, file);
    }

    @GetMapping("/user/{name}")
    public String getUser(@PathVariable String name, Model model){
       User user=userService.getUserByName(name);
       model.addAttribute("user",user);
        return "profile";
   }
   @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable int id,@Valid @RequestBody User user){
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
