package com.scaler.sprlitwise.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private String Description ;
    private Group group;
    private List<ExpenseUser> expenseUsersList;
    private double amount;
    private User createdBy;
    private ExpenseType expenseType;
}




