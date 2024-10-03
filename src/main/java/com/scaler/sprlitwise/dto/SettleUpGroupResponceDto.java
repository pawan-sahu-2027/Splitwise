package com.scaler.sprlitwise.dto;


import com.scaler.sprlitwise.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class SettleUpGroupResponceDto {
    private List<Expense> expenseUsers;
}
