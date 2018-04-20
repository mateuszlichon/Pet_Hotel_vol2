package com.pethotel.service;

import org.springframework.validation.BindingResult;

import com.pethotel.entity.UserAccount;
import com.pethotel.response.RegisterResponse;

public interface AccountService {

    RegisterResponse register(UserAccount userAccount, BindingResult bindingResult);
}
