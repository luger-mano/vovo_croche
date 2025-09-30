package com.vovo.croche.model.dto.user;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNewPasswordRequestDTO {
     private String email;
     private String newPassword;
}
