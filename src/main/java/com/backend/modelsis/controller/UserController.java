package com.backend.modelsis.controller;

import com.backend.modelsis.entites.UserCustomer;
import com.backend.modelsis.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/login")
    public UserCustomer getUser(@RequestBody UserCustomer user) {
        return userService.getUser(user);
    }
    @PostMapping("/registration")
    public UserCustomer postUser(@RequestBody UserCustomer user){
        return userService.postUser(user);
    }

}
