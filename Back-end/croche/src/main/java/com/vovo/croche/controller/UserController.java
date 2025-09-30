package com.vovo.croche.controller;

import com.vovo.croche.model.dto.user.UserNewPasswordRequestDTO;
import com.vovo.croche.model.dto.user.UserRequestDTO;
import com.vovo.croche.model.dto.user.UserResponseDTO;
import com.vovo.croche.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody UserRequestDTO dto){
        UserResponseDTO user = service.saveUser(dto);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        List<UserResponseDTO> listUser = service.getUsers();
        return ResponseEntity.ok(listUser);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserResponseDTO> getUserByEmail(@PathVariable String email){
        UserResponseDTO user = service.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/new-password")
    public ResponseEntity<UserResponseDTO> updatePasswordUser(@RequestBody UserNewPasswordRequestDTO user){
        UserResponseDTO userPass = service.updatePassword(user);
        return ResponseEntity.ok(userPass);
    }

}
