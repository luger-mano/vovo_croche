package com.vovo.croche.model.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserResponseDTO {
    
    private String fullName;
    private String email;
    private String password;
    private String phone;
}
