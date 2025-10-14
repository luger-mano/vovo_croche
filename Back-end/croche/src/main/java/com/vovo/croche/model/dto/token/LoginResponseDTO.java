package com.vovo.croche.model.dto.token;

import lombok.Getter;

@Getter
public class LoginResponseDTO {

    private String accessToken;
    private Long expireIn;

    public LoginResponseDTO(String accessToken, Long expireIn) {
        this.accessToken = accessToken;
        this.expireIn = expireIn;
    }
}
