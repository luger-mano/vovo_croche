package com.vovo.croche.mappers.address;


import com.vovo.croche.model.Address;
import com.vovo.croche.model.dto.address.AddressRequestDTO;
import com.vovo.croche.model.dto.address.AddressResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address addressRequestDTOtoAddress(AddressRequestDTO dto);
    AddressResponseDTO addressToAddressResponseDTO(Address address);
}
