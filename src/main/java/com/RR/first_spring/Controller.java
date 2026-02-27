package com.RR.first_spring;


import com.RR.first_spring.app.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/RR")
    public String Hello() {
        return "Hello Rahul";
    }

    @GetMapping("/api")
    public User getUser() {
         User user = new User(1, "Rahul" , "rahul@gmail.com");
         return user;
    }
}
