package com.scaler.sprlitwise.repository;

import com.scaler.sprlitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository {

    Optional<User> findById(int userId);
}
