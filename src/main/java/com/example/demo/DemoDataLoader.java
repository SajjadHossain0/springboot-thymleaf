package com.example.demo;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemoDataLoader implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            Category cat1 = new Category();
            cat1.setName("Programming");

            Category cat2 = new Category();
            cat2.setName("Fiction");

            Category cat3 = new Category();
            cat3.setName("Science");

            categoryRepository.saveAll(List.of(cat1, cat2, cat3));

            System.out.println("Default categories inserted.");
        }
    }
}
