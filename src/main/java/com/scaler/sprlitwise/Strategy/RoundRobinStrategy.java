package com.scaler.sprlitwise.Strategy;

import com.scaler.sprlitwise.models.Expense;

import java.util.List;

public class RoundRobinStrategy implements SettleUpStrategy{
    @Override
    public List<Expense> settleUp(List<Expense> expenses) {
        return List.of();
    }
}
