package com.phuong.repository.impl;

import com.phuong.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@Repository
public class IDictionaryRepositoryImpl implements IDictionaryRepository {
    private static Map<String, String> dictionaryMap = new HashMap<>();

    static {
        dictionaryMap.put("Dog", "Tài");
        dictionaryMap.put("Cat", "Con mèo");
        dictionaryMap.put("Chick", "Con gà con");
        dictionaryMap.put("Turkey", "Gà Tây");
        dictionaryMap.put("Duck", "Vịt");
        dictionaryMap.put("Parrot", "Con vẹt");
        dictionaryMap.put("Fox", "Con cáo");
        dictionaryMap.put("Lion", "Con sư tử");
        dictionaryMap.put("Panda", "Con gấu trúc");
        dictionaryMap.put("Hello", "Xin Chào");
    }

    @Override
    public String translation(String english) {
        Set<String> key = dictionaryMap.keySet();
        for (String k: key) {
            if (k.toLowerCase(Locale.ROOT).equals(english.toLowerCase())) {
                return dictionaryMap.get(k);
            }
        }
        return null;
    }
}
