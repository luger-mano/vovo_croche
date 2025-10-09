package com.vovo.croche.mappers;

import com.vovo.croche.model.User;
import com.vovo.croche.model.dto.user.UserRequestDTO;
import com.vovo.croche.model.dto.user.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userRequestDTOtoUser(UserRequestDTO dto);
    UserResponseDTO usertoUserResponseDTO(User user);
}
