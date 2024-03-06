package com.appstore.convertor.entity2dto;

import com.appstore.dto.SignupDto;
import com.appstore.entity.SignupEntity;

public class SignUpConvertorEntityToDto {
 public static SignupDto convertEntityToDto(SignupEntity signupEntity){
       SignupDto signupDto=new SignupDto();
      signupDto.setId(signupEntity.getId());
      signupDto.setEmail(signupEntity.getEmail());
      String[] username=signupEntity.getUsername().split("_");
      signupDto.setFirstName(username[0]);
      signupDto.setLastName(username[1]);
      signupDto.setPassword(signupEntity.getPassword());
      return signupDto;
   }
}
