package com.scaler.sprlitwise.Strategy;

import com.scaler.sprlitwise.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List <Expense> settleUp (List<Expense> expenses);
}
