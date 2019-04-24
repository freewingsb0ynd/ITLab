package com.topica.vn.lab19;

import com.topica.vn.lab19.model.Word;
import com.topica.vn.lab19.service.FindWord;
import com.topica.vn.lab19.service.ReadFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
public class Lab19Application implements CommandLineRunner {
    @Autowired
    ReadFileService readFileService;

    @Autowired
    FindWord findWord;

    public static void main(String[] args) {
        SpringApplication.run(Lab19Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Import external file
//        readFileService.importFromFile("E:\\Programming\\Projects Java\\lab19\\src\\main\\java\\com\\topica\\vn\\lab19\\vnedict.txt");
        List<Word> words = findWord.findWord("Biển Hài Hước", 0, 20);
        log.info(words.toString());
    }
}
