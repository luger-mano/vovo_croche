package com.vovo.croche.controller;

import com.vovo.croche.model.dto.admin.UsersResponseAdminDTO;
import com.vovo.croche.model.dto.user.UserNewPasswordRequestDTO;
import com.vovo.croche.model.dto.user.UserRequestDTO;
import com.vovo.croche.model.dto.user.UserResponseDTO;
import com.vovo.croche.service.UserRegistrationService;
import com.vovo.croche.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService service;
    private final UserRegistrationService userRegistrationService;

    public UserController(UserService service, UserRegistrationService userRegistrationService) {
        this.service = service;
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody UserRequestDTO dto) {
        UserResponseDTO user = service.saveUser(dto);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<List<UsersResponseAdminDTO>> getAllUsers() {
        List<UsersResponseAdminDTO> listUser = service.getUsers();
        return ResponseEntity.ok(listUser);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserResponseDTO> getUserByEmail(@PathVariable("email") String email) {
        UserResponseDTO user = service.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }
    /**
     * Necessário enviar email com um token para o usuário
     * para que ele possa redefinir a senha.
     * LÓGICA PARA ENVIAR TOKEN POR EMAIL E REDEFINIR A SENHA
     */
    @PutMapping("/new-password")
    public ResponseEntity<UserResponseDTO> updatePasswordUser(@RequestBody UserNewPasswordRequestDTO user) {
        UserResponseDTO userPass = service.updatePassword(user);
        return ResponseEntity.ok(userPass);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") UUID id,
                                                 JwtAuthenticationToken token) {
        String deletedUser = this.service.deleteUser(id, token);
        return ResponseEntity.status(200).body(deletedUser);
    }

//    @PostMapping("/user-address/{id}")
//    public ResponseEntity<String> saveUserAddress(@PathVariable("id") UUID id,
//                                                    @RequestBody AddressCepRequestDTO dto){
//
//    }

}
