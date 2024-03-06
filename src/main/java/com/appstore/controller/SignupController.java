package com.appstore.controller;

import com.appstore.dto.SignupDto;
import com.appstore.entity.SignupEntity;
import com.appstore.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class SignupController {
    @Autowired
    SignupService signupService;

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody SignupDto signupDto) {

        if (signupService.isEmailExist(signupDto.getEmail())) {
            return new ResponseEntity<>("User Already Exist", HttpStatus.BAD_REQUEST);
        } else if (signupDto.getEmail() == null) {
            return new ResponseEntity<>("Mail Should not be Null", HttpStatus.BAD_REQUEST);
        }
        SignupEntity response = signupService.saveUser(signupDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable int userId, @RequestBody SignupDto signupDto) {
        try {
            SignupEntity response = signupService.updateUser(userId, signupDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("User not found with id: " + userId, HttpStatus.NOT_FOUND);
        }
    }
}
