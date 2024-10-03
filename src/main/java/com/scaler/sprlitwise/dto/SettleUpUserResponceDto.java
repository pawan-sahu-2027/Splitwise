package com.scaler.sprlitwise.dto;

import com.scaler.sprlitwise.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class SettleUpUserResponceDto {
    private List<Expense> expenseList;
}
