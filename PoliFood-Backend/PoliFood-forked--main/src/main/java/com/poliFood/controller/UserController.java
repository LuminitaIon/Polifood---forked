package com.poliFood.controller;

import com.poliFood.dto.UserDTO;
import com.poliFood.dto.convertor.UserConvertor;
import com.poliFood.model.User;
import com.poliFood.projection.UserBarView;
import com.poliFood.projection.UserView;
import com.poliFood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(path = "/add")
    public ResponseEntity<User> save(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<UserView> getAllUsers(){
        return userService.findAll();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody UserDTO userDTO) throws ParseException {
        User user = UserConvertor.convertToEntity(userDTO);
        if(user.getPassword() != null)
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
    }

//    @GetMapping(path = "/login")
//    public UserDTO getLoginUser(@RequestBody UserLoginDTO userLoginDTO) throws ParseException {
//        return UserConvertor.convertToDto(UserConvertor.convertUserLoginToEntity(userLoginDTO));
//    }

    @GetMapping("/getCurrentUser")
    public UserBarView getCurrentUser(){
        return userService.getCurrentUser();
    }

}
