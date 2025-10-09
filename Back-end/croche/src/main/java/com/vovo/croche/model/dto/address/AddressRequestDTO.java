package com.vovo.croche.model.dto.address;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequestDTO {

    private String localidade;
    private String logradouro;
    private String uf;
}
