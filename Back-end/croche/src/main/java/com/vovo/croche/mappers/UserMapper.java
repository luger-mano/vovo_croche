package com.vovo.croche.mappers;

import com.vovo.croche.model.User;
import com.vovo.croche.model.dto.user.UserRequestDTO;
import com.vovo.croche.model.dto.user.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "middleName", target = "middleName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "birth", target = "birth")
    User userRequestDTOtoUser(UserRequestDTO dto);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "middleName", target = "middleName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "birth", target = "birth")
    UserResponseDTO usertoUserResponseDTO(User user);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "middleName", target = "middleName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "birth", target = "birth")
    User userResponseToUser(UserResponseDTO dto);
}
