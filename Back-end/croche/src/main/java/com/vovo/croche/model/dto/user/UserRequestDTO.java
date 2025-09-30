package com.vovo.croche.model.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class UserRequestDTO {

    private String name;
    private String middleName;
    private String email;
    private String password;
    private String cpf;
    private String phone;
    private LocalDate birth;
}
