package com.vovo.croche.repository;

import com.vovo.croche.model.Address;
import com.vovo.croche.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address,Long> {
    Optional<Address> findByUserId(UUID id);
}
