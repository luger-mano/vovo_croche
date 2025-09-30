package com.vovo.croche.service;

import com.vovo.croche.enums.UserType;
import com.vovo.croche.exceptions.UserEmailAlreadyExistException;
import com.vovo.croche.mappers.UserMapper;
import com.vovo.croche.model.User;
import com.vovo.croche.model.dto.user.UserNewPasswordRequestDTO;
import com.vovo.croche.model.dto.user.UserRequestDTO;
import com.vovo.croche.model.dto.user.UserResponseDTO;
import com.vovo.croche.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;
    @Autowired
    private UserRepository repository;

    @Transactional
    public UserResponseDTO saveUser(UserRequestDTO dto){
        try{
            if (this.repository.existsByEmail(dto.getEmail())){

                throw new UserEmailAlreadyExistException("E-mail já cadastrado.");
            }
            User userMapp = mapper.userRequestDTOtoUser(dto);
            User saveUser = repository.save(userMapp);
            saveUser.setUserType(UserType.CLIENT);

            return mapper.usertoUserResponseDTO(saveUser);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<UserResponseDTO> getUsers(){
        try{
            List<User> listUsers = repository.findAll();
            return listUsers.stream().map(mapper::usertoUserResponseDTO).toList();
        }catch (ResponseStatusException r){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Nenhum usuário encontrado.");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public UserResponseDTO getUserByEmail(String email){
        Optional<User> user = repository.findByEmail(email);
        if (user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return mapper.usertoUserResponseDTO(user.get());
    }

    @Transactional
    public UserResponseDTO updatePassword(UserNewPasswordRequestDTO user){
        User userExist = repository.findByEmail(user.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT,
                        "Usuário com o e-mail " + user.getEmail() + " não encontrado"));

        userExist.setPassword(user.getNewPassword());
        repository.save(userExist);

        return mapper.usertoUserResponseDTO(userExist);
    }
}
