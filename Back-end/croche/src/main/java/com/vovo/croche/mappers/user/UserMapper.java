package com.vovo.croche.mappers.user;

import com.vovo.croche.model.User;
import com.vovo.croche.model.dto.admin.UsersResponseAdminDTO;
import com.vovo.croche.model.dto.user.UserRequestDTO;
import com.vovo.croche.model.dto.user.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { RoleMapper.class })
public interface UserMapper {

    User userRequestDTOtoUser(UserRequestDTO dto);
    UserResponseDTO usertoUserResponseDTO(User user);

    UsersResponseAdminDTO usertoUsersResponseAdminDTO(User user);
}
