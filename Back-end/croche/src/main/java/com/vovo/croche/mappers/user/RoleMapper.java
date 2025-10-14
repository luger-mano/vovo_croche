package com.vovo.croche.mappers.user;

import com.vovo.croche.model.Role;
import com.vovo.croche.model.dto.user.RoleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO roleToRoleDTO(Role role);
    Role roleDTOtoRole(RoleDTO roleDTO);
}
