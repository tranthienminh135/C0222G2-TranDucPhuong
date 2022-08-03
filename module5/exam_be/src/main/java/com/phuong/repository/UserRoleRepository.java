package com.phuong.repository;

import com.phuong.model.AppUser;
import com.phuong.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findAllByAppUser(AppUser appUser);
}
