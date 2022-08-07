package com.coffee.service.impl;

import com.coffee.model.account.AppUser;

public interface IAppUserService {

    AppUser findAppUserByUsername(String username);

    void save(AppUser appUser);
}
