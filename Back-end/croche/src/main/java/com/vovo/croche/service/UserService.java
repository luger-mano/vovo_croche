package com.vovo.croche.service;

import com.vovo.croche.exceptions.UserEmailAlreadyExistException;
import com.vovo.croche.mappers.address.AddressMapper;
import com.vovo.croche.mappers.user.UserMapper;
import com.vovo.croche.model.Address;
import com.vovo.croche.model.Role;
import com.vovo.croche.model.User;
import com.vovo.croche.model.dto.address.AddressRequestDTO;
import com.vovo.croche.model.dto.address.AddressResponseDTO;
import com.vovo.croche.model.dto.admin.UsersResponseAdminDTO;
import com.vovo.croche.model.dto.user.UserNewPasswordRequestDTO;
import com.vovo.croche.model.dto.user.UserRequestDTO;
import com.vovo.croche.model.dto.user.UserResponseDTO;
import com.vovo.croche.repository.RoleRepository;
import com.vovo.croche.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {

    private final UserMapper mapper;
    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserMapper mapper, UserRepository repository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserResponseDTO saveUser(UserRequestDTO dto) {
        try {
            Role clientRole = roleRepository.findByName(Role.Values.CLIENT.name());

            if (this.repository.existsByEmail(dto.getEmail())) {
                throw new UserEmailAlreadyExistException("E-mail já cadastrado.");
            }
            User userMapp = mapper.userRequestDTOtoUser(dto);
            userMapp.setPassword(passwordEncoder.encode(dto.getPassword()));
            userMapp.setRoles(Set.of(clientRole));

            User saveUser = repository.save(userMapp);

            return mapper.usertoUserResponseDTO(saveUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<UsersResponseAdminDTO> getUsers() {
        try {
            List<User> listUsers = repository.findAll();

            return listUsers.stream().map(mapper::usertoUsersResponseAdminDTO).toList();
        } catch (ResponseStatusException r) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Nenhum usuário encontrado.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public UserResponseDTO getUserByEmail(String email) {
        Optional<User> user = repository.findByEmail(email);
        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return mapper.usertoUserResponseDTO(user.get());
    }

    @Transactional
    public UserResponseDTO updatePassword(UserNewPasswordRequestDTO user) {
        try {
            User userExist = repository.findByEmail(user.getEmail())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT,
                            "Usuário com o e-mail " + user.getEmail() + " não encontrado"));

            userExist.setPassword(user.getNewPassword());
            repository.save(userExist);

            return mapper.usertoUserResponseDTO(userExist);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public String deleteUser(UUID id, JwtAuthenticationToken token){
        try {
            User userOpp = this.repository.findById(UUID.fromString(token.getName()))
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

            var isAdmin = userOpp.getRoles()
                    .stream()
                    .anyMatch(role ->
                            role.getName().equalsIgnoreCase(Role.Values.ADMIN.name()));

            if (isAdmin || userOpp.getId().equals(UUID.fromString(token.getName()))) {
                repository.deleteById(id);
                return "Usuário deletado com sucesso.";
            }
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
