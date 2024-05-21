package com.example.bookshop_system;

import com.example.bookshop_system.service.AuthorService;
import com.example.bookshop_system.service.BookService;
import com.example.bookshop_system.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private CategoryService categoryService;
    private AuthorService authorService;
    private BookService bookService;

    public ConsoleRunner(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String ... args) throws Exception{
        categoryService.seedCategories();
        bookService.seedBooks();
        authorService.seedAuthors();
    }

}
