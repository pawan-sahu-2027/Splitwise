package com.scaler.sprlitwise.repository;

import com.scaler.sprlitwise.models.ExpenseUser;
import com.scaler.sprlitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExpenseUserRepository extends JpaRepository {

    List<ExpenseUser> findAllByUser (User user);
}
