package com.scaler.sprlitwise.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Group extends BaseModel{
    private  String name;
    private List<User> userList;
    private List<Expense> expenceList;
    private User admin;
}
