package com.appstore.service;

import com.appstore.dto.SignupDto;
import com.appstore.entity.SignupEntity;

public interface SignupService {
    SignupEntity saveUser(SignupDto signupDto);

    boolean isEmailExist(String email);

    SignupEntity updateUser(int id,SignupDto signupDto);
}
