package com.pethotel.service;

import com.pethotel.entity.UserAccount;
import com.pethotel.entity.wrapper.CustomUserDetails;
import com.pethotel.enums.Role;
import com.pethotel.repository.UserAccountRepository;
import com.pethotel.repository.UserRoleRepository;
import com.pethotel.response.RegisterResponse;
import com.pethotel.validation.RegisterValidation;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {

    @Autowired
    RegisterValidation registerValidation;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    UserAccountRepository userAccountRepository;

    @Override
    public RegisterResponse register(UserAccount userAccount, BindingResult bindingResult) {
        if (registerValidation.validRegister(userAccount, bindingResult)) {
            userAccount.setPassword(BCrypt.hashpw(userAccount.getPassword(), BCrypt.gensalt()));
            userAccount.setUserRole(userRoleRepository.findByRole(Role.USER));
            userAccountRepository.save(userAccount);
        }
        return registerValidation.getRegisterResponse();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new CustomUserDetails(userAccountRepository.findByUsername(s));
    }
}
