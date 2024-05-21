package com.example.bookshop_system.service;

import com.example.bookshop_system.entity.Author;

import java.io.IOException;

public interface AuthorService {

    void seedAuthors() throws IOException;

    Author getRandomAuthor();
}
