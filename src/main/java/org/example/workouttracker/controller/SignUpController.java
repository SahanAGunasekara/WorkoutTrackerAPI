package org.example.workouttracker.controller;

import org.example.workouttracker.dto.UserDTO;
import org.example.workouttracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api/v1/signUp")
@CrossOrigin
public class SignUpController {

    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    public String signUp(@RequestBody UserDTO userDTO){

        boolean b = userService.registerUser(userDTO);

        if (b){
            return "Successfully Registered";
        }

        return "Registration error";

    }
}
