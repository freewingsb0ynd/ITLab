package com.topica.vn.lab19.service.impl;

import com.topica.vn.lab19.model.Word;
import com.topica.vn.lab19.repo.WordRepository;
import com.topica.vn.lab19.service.FindWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindWordImpl implements FindWord {
    @Autowired
    WordRepository wordRepo;

    @Override
    public List<Word> findWord(String key, int pageIndex, int pageSize) {
        return wordRepo.findByWord(key, new PageRequest(pageIndex, pageSize)).getContent();
    }
}
