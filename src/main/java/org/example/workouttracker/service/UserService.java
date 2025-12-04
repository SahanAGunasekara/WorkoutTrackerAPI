package org.example.workouttracker.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.http.HttpSession;
import org.example.workouttracker.Repo.UserRepo;
import org.example.workouttracker.Util.ResponseObject;
import org.example.workouttracker.dto.UserDTO;
import org.example.workouttracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public boolean registerUser(UserDTO userDto){

        Date date = new Date();

        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCreated_at(date);

        userRepo.save(user);

        return true;
    }

    public ResponseObject loginUser(UserDTO userDTO, HttpSession session){

        ResponseObject responseObject = new ResponseObject();

        responseObject.setStatus(false);


        if(userDTO.getEmail().isEmpty()){
            responseObject.setMessage("please enter Email");
        }else if(!userDTO.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")){
            responseObject.setMessage("please enter valid Email");
        }else if(userDTO.getPassword().isEmpty()){
            responseObject.setMessage("please enter Password");
        }else{
            List<User> userList = userRepo.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
            if(!userList.isEmpty()){
                User user = userList.get(0);
                session.setAttribute("User",user);
                responseObject.setMessage("Invalid email address or Password");

            }else{
                responseObject.setMessage("Succefully loggedIn");
            }
        }

        responseObject.setStatus(true);

        return responseObject;

    }
}
