package com.coffee.repository;

import com.coffee.model.account.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findAppUserByUserName(String username);
}
