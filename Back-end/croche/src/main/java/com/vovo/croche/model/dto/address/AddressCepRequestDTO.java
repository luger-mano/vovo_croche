package com.vovo.croche.model.dto.address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressCepRequestDTO {
    private String cep;
    private String unidade;
    private String complemento;
}
