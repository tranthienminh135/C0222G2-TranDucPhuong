package com.phuong.repository;

public interface ILoginRepository {
    boolean checkLogin(String email, String password);
}
