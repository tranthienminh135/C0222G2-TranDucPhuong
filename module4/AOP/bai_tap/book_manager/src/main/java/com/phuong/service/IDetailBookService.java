package com.phuong.service;

import com.phuong.model.DetailBook;

import java.util.List;

public interface IDetailBookService {
    List<DetailBook> findAll();

    void setStatus(Integer id);

    void returnBook(Integer bookCode) throws Exception;
}
