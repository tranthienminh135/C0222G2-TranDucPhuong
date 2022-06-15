package com.phuong.service.impl;

import com.phuong.repository.IDictionaryRepository;
import com.phuong.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    IDictionaryRepository dictionaryRepository;

    @Override
    public String translation(String english) {
        return dictionaryRepository.translation(english);
    }
}
