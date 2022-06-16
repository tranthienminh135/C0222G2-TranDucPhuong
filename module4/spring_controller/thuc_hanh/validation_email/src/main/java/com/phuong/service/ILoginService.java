package com.phuong.service;

import org.springframework.stereotype.Service;

public interface ILoginService {
    boolean checkLogin(String email, String password);
}
