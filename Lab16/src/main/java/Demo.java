import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import model.Item;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class Demo implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(Demo.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        List<Item> items = new ArrayList<>();

        System.out.println("hello");
//        List<Category> categories = categoryService.findByType("type1",0,5);
//        for(Category category : categories){
//            System.out.println("Category name is: "+category.getName());
//        }
//
//        List<Item> items = itemService.findByCategory("cat1",0,5);
//        for (Item i : items){
//            System.out.println("Item name is: "+i.getName());
//        }
//
//        categoryService.updateCategory((long) 2,"category2");


    }
}
