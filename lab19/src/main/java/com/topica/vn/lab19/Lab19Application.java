package com.topica.vn.lab19;

import com.topica.vn.lab19.service.ReadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab19Application implements CommandLineRunner {
    @Autowired
    ReadFileService readFileService;

    public static void main(String[] args) {
        SpringApplication.run(Lab19Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Import external file
//        readFileService.importFromFile("E:\\Programming\\Projects Java\\lab19\\src\\main\\java\\com\\topica\\vn\\lab19\\vnedict.txt");

    }
}
