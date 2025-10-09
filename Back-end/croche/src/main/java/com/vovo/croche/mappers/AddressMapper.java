package com.vovo.croche.mappers;


import com.vovo.croche.model.Address;
import com.vovo.croche.model.dto.address.AddressRequestDTO;
import com.vovo.croche.model.dto.address.AddressResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address addressRequestDTOtoAddress(AddressRequestDTO dto);

//    @Mapping(source = "cep", target = "cep")
//    @Mapping(source = "logradouro", target = "logradouro")
//    @Mapping(source = "complemento", target = "complemento")
//    @Mapping(source = "localidade", target = "localidade")
//    @Mapping(source = "bairro", target = "bairro")
//    @Mapping(source = "uf", target = "uf")
//    @Mapping(source = "estado", target = "estado")
    AddressResponseDTO addressToAddressResponseDTO(Address address);
}
