package com.topica.vn.jpaExample;

import com.topica.vn.jpaExample.model.Category;
import com.topica.vn.jpaExample.model.Item;
import com.topica.vn.jpaExample.service.CategoryService;
import com.topica.vn.jpaExample.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemService itemService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

        List<Item> items = itemService.findByCategory("Apple", 0, 4);
        for (Item item : items) {
            System.out.println(item.getId() + "/" + item.getName());
        }

        List<Category> categories = categoryService.findByType("Phone", 1, 2);
        for (Category category : categories) {
            System.out.println(category.getId() + "/" + category.getName());
        }


        categoryService.updateCategory(6L, "Lenovo");
    }
}