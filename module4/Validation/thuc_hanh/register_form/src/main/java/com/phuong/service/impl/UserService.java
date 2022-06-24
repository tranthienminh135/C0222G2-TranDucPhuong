package com.phuong.service.impl;

import com.phuong.model.User;
import com.phuong.repository.IUserRepository;
import com.phuong.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override
    public void save(User user) {
        this.repository.save(user);
    }
}
