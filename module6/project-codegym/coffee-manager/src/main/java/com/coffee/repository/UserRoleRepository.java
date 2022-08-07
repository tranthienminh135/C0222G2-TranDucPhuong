package com.coffee.repository;

import com.coffee.model.account.AppUser;
import com.coffee.model.account.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findAllByAppUser(AppUser appUser);
}
