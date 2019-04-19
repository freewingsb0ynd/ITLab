package com.topica.vn.lab16;

import com.topica.vn.lab16.model.Category;
import com.topica.vn.lab16.model.Item;
import com.topica.vn.lab16.service.CategoryService;
import com.topica.vn.lab16.service.ItemService;
import com.topica.vn.lab16.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private TypeService typeService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemService itemService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        List<Category> categories = categoryService.findByType("Device", 0, 100);
        for (Category category : categories) {
            System.out.println(category.getId() + ", " + category.getName());
        }

        List<Item> items = itemService.findByCategory("Laptop", 0, 100);
        for (Item item : items) {
            System.out.println(item.getId() + ", " + item.getName());
        }

        categoryService.updateCategory(1L, "Phone");
    }
}