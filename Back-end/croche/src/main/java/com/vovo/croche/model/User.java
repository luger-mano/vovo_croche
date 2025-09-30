package com.vovo.croche.model;


import com.vovo.croche.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
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
    @GeneratedValue(generator = "UUID")
    @Column(updatable = false, nullable = false, columnDefinition = "CHAR(36)")
    private UUID id;
    private String name;
    private String middleName;
    private String email;
    private String password;
    private String cpf;
    private String phone;
    private LocalDate birth;
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
