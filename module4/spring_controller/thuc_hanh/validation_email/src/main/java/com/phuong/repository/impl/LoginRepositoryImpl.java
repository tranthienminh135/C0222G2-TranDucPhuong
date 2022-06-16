package com.phuong.repository.impl;

import com.phuong.repository.ILoginRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Repository
public class LoginRepositoryImpl implements ILoginRepository {
    private static Map<String, String> account = new HashMap<>();

    static {
        account.put("taingu@gmail.com", "123456");
        account.put("admin@gmail.com", "456789");
        account.put("lethitai@gmail.com", "789789");
        account.put("lethihau@gmail.com", "123123");
        account.put("lethihoan@gmail.com", "456456");
        account.put("lethitri@gmail.com", "789456");
        account.put("lethihung@gmail.com", "123456");
    }
    @Override
    public boolean checkLogin(String email, String password) {
        Set<String> key = account.keySet();
        for (String k: key) {
            if (k.equals(email)) {
                if (account.get(k).equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}
