package com.vovo.croche.model.dto.admin;

import com.vovo.croche.model.Address;
import com.vovo.croche.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersResponseAdminDTO {
    private String fullName;
    private String email;
    private String phone;
    private Address address;
    private Set<Role> roles;
}
