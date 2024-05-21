package com.example.bookshop_system.service.impl;

import com.example.bookshop_system.entity.Author;
import com.example.bookshop_system.repository.AuthorRepository;
import com.example.bookshop_system.service.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;
    private static final String TEXT_FILE = "src/main/resources/files/authors.txt";

    @Override
    public void seedAuthors() throws IOException {
        if(authorRepository.count()>0) {
            return;
        }

        Files.readAllLines(Path.of(TEXT_FILE)).stream()
                .filter(line -> !line.isEmpty())
                .forEach(authorName -> {
                    String[] names = authorName.split(" ");
                    Author author = new Author(names[0], names[1]);
                    authorRepository.save(author);
                });
    }

    public Author getRandomAuthor() {
        Random random = new Random();
        return authorRepository.getById(random.longs(1, 30)
                .findFirst().getAsLong());
    }
}
