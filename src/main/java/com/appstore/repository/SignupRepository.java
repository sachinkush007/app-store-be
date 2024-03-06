package com.appstore.repository;

import com.appstore.entity.SignupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignupRepository extends JpaRepository<SignupEntity, Integer> {
    Optional<SignupEntity> findByEmail(String email);
}
