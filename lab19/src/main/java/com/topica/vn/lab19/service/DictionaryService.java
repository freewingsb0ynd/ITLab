package com.topica.vn.lab19.service;

import com.topica.vn.lab19.model.Word;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public interface DictionaryService {
    List<Word> findByWord (String word, int pageIndex, int pageSize);
    Word findByWord(String word);
    void insertToDictionary(String word,String mean);
}
