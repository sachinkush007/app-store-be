package com.appstore.service.impl;

import com.appstore.convertor.dto2entity.SignupConverterDtoToEntity;
import com.appstore.dto.SignupDto;
import com.appstore.entity.SignupEntity;
import com.appstore.repository.SignupRepository;
import com.appstore.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SignupImpl implements SignupService {

    @Autowired
    SignupRepository signupRepository;

    @Override
    public SignupEntity saveUser(SignupDto signupDto) {
        SignupEntity signupEntity = SignupConverterDtoToEntity.convertDtoToEntity(signupDto);
        return signupRepository.save(signupEntity);
    }

    public boolean isEmailExist(String email) {
        return signupRepository.findByEmail(email).isPresent();
    }

    @Override
    public SignupEntity updateUser(int id, SignupDto signupDto) {
        Optional<SignupEntity> signupEntity = signupRepository.findById(id);
        if (signupEntity.isPresent()) {
            SignupEntity user = signupEntity.get();
            SignupEntity entity = SignupConverterDtoToEntity.convertDtoToEntityUsingID(user, signupDto);
            return signupRepository.save(entity);
        } else {
            throw new NoSuchElementException("User Not Found" + id);
        }
    }
}
