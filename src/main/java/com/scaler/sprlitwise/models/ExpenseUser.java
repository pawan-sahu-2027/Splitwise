package com.scaler.sprlitwise.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExpenseUser extends BaseModel {
    private Expense expence;
    private User user;
    private ExpenseUserType expenseUserType;
    private double amount;
}
