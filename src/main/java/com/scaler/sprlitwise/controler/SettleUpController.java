package com.scaler.sprlitwise.controler;

import com.scaler.sprlitwise.Exception.UserNotFoundException;
import com.scaler.sprlitwise.dto.SettleUpUserRequestDto;
import com.scaler.sprlitwise.dto.SettleUpUserResponceDto;
import com.scaler.sprlitwise.models.Expense;
import com.scaler.sprlitwise.service.SettleUpService;

import java.util.List;

public class SettleUpController {
    private SettleUpService settleUpService;

    public SettleUpController (SettleUpService settleUpService){
        this.settleUpService = settleUpService;
    }

    private SettleUpUserResponceDto settleUpUser (SettleUpUserRequestDto settleUpUserRequestDto) throws UserNotFoundException {
        List<Expense> settleUpExpence =  settleUpService.settleUpUser(settleUpUserRequestDto.getUserid());
        SettleUpUserResponceDto settleUpUserResponceDto = new SettleUpUserResponceDto();
        settleUpUserResponceDto.setExpenseList(settleUpExpence);
        return settleUpUserResponceDto;
    }
}
