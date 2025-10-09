package com.vovo.croche.model.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class UserRequestDTO {

    private String fullName;
    private String email;
    private String password;
    private String phone;
}
