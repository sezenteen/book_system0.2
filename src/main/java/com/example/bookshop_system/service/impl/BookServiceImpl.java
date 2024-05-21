package com.example.bookshop_system.service.impl;

import com.example.bookshop_system.entity.Book;
import com.example.bookshop_system.entity.EditionType;
import com.example.bookshop_system.repository.BookRepository;
import com.example.bookshop_system.repository.CategoryRepository;
import com.example.bookshop_system.service.BookService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;

    private static final String TEXT_FILE = "src/main/resources/files/books.txt";

    public BookServiceImpl(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }
        Files.readAllLines(Path.of(TEXT_FILE)).stream()
                .filter(line -> !line.isEmpty())
                .forEach(bookName -> {
                    String[] bookValues = bookName.split(" ");
                    Book book = getBook(bookValues);

                    bookRepository.save(book);
                });
    }

    private Book getBook(String[] bookValues){
        Book book = new Book();
        book.setEditionType(EditionType.valueOf(bookValues[0]));
        book.setReleaseDate(LocalDateTime.parse(bookValues[1]));
        book.setCopies(Integer.valueOf(bookValues[2]));
        book.setCategories(categoryService.getRandomCategories());
        return book;
    }
}
