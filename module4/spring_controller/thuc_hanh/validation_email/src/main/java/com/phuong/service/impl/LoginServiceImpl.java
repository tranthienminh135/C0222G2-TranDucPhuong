package com.phuong.service.impl;

import com.phuong.repository.ILoginRepository;
import com.phuong.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private ILoginRepository loginRepository;

    @Override
    public boolean checkLogin(String email, String password) {
        return loginRepository.checkLogin(email,password);
    }
}
