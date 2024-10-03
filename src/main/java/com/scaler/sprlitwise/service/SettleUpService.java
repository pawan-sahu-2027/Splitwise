package com.scaler.sprlitwise.service;

import com.scaler.sprlitwise.Exception.UserNotFoundException;
import com.scaler.sprlitwise.Strategy.SettleUpStrategy;
import com.scaler.sprlitwise.models.Expense;
import com.scaler.sprlitwise.models.ExpenseUser;
import com.scaler.sprlitwise.models.User;
import com.scaler.sprlitwise.repository.ExpenseUserRepository;
import com.scaler.sprlitwise.repository.UserRepository;

import java.util.*;

public class SettleUpService {
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private SettleUpStrategy settleUpStrategy;
    public SettleUpService (UserRepository userRepository , ExpenseUserRepository expenseUserRepository , SettleUpStrategy settleUpStrategy){
        this.userRepository  =userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Expense> settleUpUser(int userId) throws UserNotFoundException {
         Optional< User > user = userRepository.findById(userId);
        if (user.isEmpty()){
            throw new UserNotFoundException(" Invalid user Id " + userId);
        }
         User  user1 = user.get();


         List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user1);
        Set<Expense> expenses = new HashSet<>();
        for (ExpenseUser exp : expenseUsers){
            expenses.add(exp.getExpence());
        }
        List<Expense> expensesToSettle  = settleUpStrategy.settleUp(expenses.stream().toList());
         List<Expense> expensesToReturn = new ArrayList<>();
        for (Expense expense : expensesToSettle){
            for (ExpenseUser expenseUser : expense.getExpenseUsersList()){
                if (expenseUser.equals(user1)){
                    expensesToReturn.add(expense);
                 break;
                }

            }
        }



        return  expensesToReturn;

    }
}
