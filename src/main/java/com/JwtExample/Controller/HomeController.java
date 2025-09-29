package com.JwtExample.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/home")
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/users")
    public String getUsers() {
      System.out.println("Getting Users");
        return "Users";
    }


}