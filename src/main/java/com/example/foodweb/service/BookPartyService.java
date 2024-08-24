package com.example.foodweb.service;

import com.example.foodweb.Model.BookParty;
import com.example.foodweb.repository.BookPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookPartyService {

    @Autowired
    private BookPartyRepository bookPartyRepository;

    public BookParty saveBookParty(BookParty bookParty) {
        return bookPartyRepository.save(bookParty);
    }
}
