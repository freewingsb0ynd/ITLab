package com.topica.vn.lab19.service.impl;

import com.topica.vn.lab19.model.Word;
import com.topica.vn.lab19.repo.WordRepository;
import com.topica.vn.lab19.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Dictionary;
import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    WordRepository wordRepository;

    @Override
    public List<Word> findByWord(String word, int pageIndex, int pageSize) {
        return wordRepository.findByWord(word, new PageRequest(pageIndex,pageSize)).getContent();
    }

    @Override
    public Word findByWord(String word) {
        Word resultWord;
        try{
            resultWord = wordRepository.findByWord(word);
        } catch (Exception e){
            resultWord = null;
        }
        return resultWord;
    }

    @Override
    @Transactional
    public void insertToDictionary(String word, String mean) {
        wordRepository.insertToDictionary(word,mean);
    }
}
