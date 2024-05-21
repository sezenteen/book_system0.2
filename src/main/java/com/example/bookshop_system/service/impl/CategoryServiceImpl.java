package com.example.bookshop_system.service.impl;

import com.example.bookshop_system.entity.Author;
import com.example.bookshop_system.entity.Category;
import com.example.bookshop_system.repository.CategoryRepository;
import com.example.bookshop_system.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private static final String TEXT_FILE = "src/main/resources/files/categories.txt";

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void seedCategories() throws IOException {
        if(categoryRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(TEXT_FILE)).stream()
                .filter(line -> !line.isEmpty())
                .forEach(categoryName -> {
                    Category category = new Category(categoryName);
                    categoryRepository.save(category);
                });
    }

    @Override
    public Set<Category> getRandomCategories(){
        Random random = new Random();
        Set<Category> categories = new HashSet<>();
        int number = random.ints(1,10).findFirst().getAsInt();
        for (int i = 1; i < number; i++ ) {
            Long id = random.longs(1, categoryRepository.count()).findFirst().getAsLong();
            Category category = categoryRepository.findById(id).orElse(null);
            if (category != null)
                categories.add(category);
       }
        return categories;
    }


}
