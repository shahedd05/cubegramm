package com.google.appgramtest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
@RestController
public class MainController {
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome to spring boot!";

    }
}
