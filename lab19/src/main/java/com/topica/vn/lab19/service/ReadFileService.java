package com.topica.vn.lab19.service;

import com.topica.vn.lab19.model.Word;
import com.topica.vn.lab19.repo.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@Service
public class ReadFileService {
    @Autowired
    WordRepository wordRepository;

    public void importFromFile(String fileName) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                Word w = new Word();
                String[] tokens = line.split(":");
                if(tokens.length == 2){
//                    w.setType(typeDict);

                    w.setWord(tokens[0].trim());
                    try {
                        w.setMeaning(tokens[1].trim());
                    } catch (ArrayIndexOutOfBoundsException e ) {
                        w.setMeaning("");
                    }

                }
                wordRepository.save(w);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
