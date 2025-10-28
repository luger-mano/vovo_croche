package com.vovo.croche.model;


import com.vovo.croche.model.dto.token.LoginRequestDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TABLE_USERS")
@Getter
@Setter
@Data
public class User implements Serializable {

    @Serial
    private static final long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", updatable = false, nullable = false, columnDefinition = "CHAR(36)")
    private UUID id;
    private String fullName;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String phone;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "TABLE_USERS_ROLES",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public boolean isLoginCorrect(LoginRequestDTO dto, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(dto.getPassword(), this.password);
    }
}
