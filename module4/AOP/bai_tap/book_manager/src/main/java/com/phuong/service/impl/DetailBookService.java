package com.phuong.service.impl;

import com.phuong.model.DetailBook;
import com.phuong.repository.IBookRepository;
import com.phuong.repository.IDetailBookRepository;
import com.phuong.service.IDetailBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailBookService implements IDetailBookService {

    @Autowired
    private IDetailBookRepository detailBookRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<DetailBook> findAll() {
        return this.detailBookRepository.findAll();
    }

    @Override
    public void setStatus(Integer id) {
        this.detailBookRepository.setStatus(id);
    }

    @Override
    public void returnBook(Integer bookCode) throws Exception {
        List<DetailBook> detailBooks = this.detailBookRepository.findAll();
        DetailBook detailBook = this.detailBookRepository.getByBookCode(bookCode);
        if (checkBookCodeExists(bookCode,detailBooks)) {
            this.detailBookRepository.updateStatus(detailBook.getId());
            this.bookRepository.updateQuantity(detailBook.getBook().getId());
        } else {
            throw new Exception();
        }
    }

    private boolean checkBookCodeExists(Integer bookCode, List<DetailBook> detailBooks) {
        for (DetailBook detailBook: detailBooks) {
            if (detailBook.getBookCode().equals(bookCode) && detailBook.getStatus()) {
                return true;
            }
        }
        return false;
    }
}
