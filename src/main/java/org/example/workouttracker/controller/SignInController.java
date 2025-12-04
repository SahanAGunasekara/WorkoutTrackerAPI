package org.example.workouttracker.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.http.HttpSession;
import org.example.workouttracker.Util.ResponseObject;
import org.example.workouttracker.dto.UserDTO;
import org.example.workouttracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/SignIn")
@CrossOrigin
public class SignInController {

    @Autowired
    private UserService userService;

    @PostMapping("/SignInUser")
    public String signIn(@RequestBody UserDTO userDTO, HttpSession session){

        ResponseObject responseObject = userService.loginUser(userDTO,session);

        if (responseObject.isStatus()){
           // session.setAttribute("User",userDTO);
            return "User Login Success";
        }
        return responseObject.getMessage();
    }

}
