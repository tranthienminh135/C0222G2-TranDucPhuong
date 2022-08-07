package com.coffee.service.impl.impl;

import com.coffee.model.account.AppUser;
import com.coffee.repository.IAppUserRepository;
import com.coffee.service.impl.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements IAppUserService {

    @Autowired
    private IAppUserRepository IAppUserRepository;

    @Override
    public AppUser findAppUserByUsername(String username) {
        return this.IAppUserRepository.findAppUserByUserName(username);
    }

    @Override
    public void save(AppUser appUser) {
        this.IAppUserRepository.save(appUser);
    }
}
