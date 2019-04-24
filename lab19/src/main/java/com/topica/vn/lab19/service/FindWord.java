package com.topica.vn.lab19.service;

import com.topica.vn.lab19.model.Word;

import java.util.List;

public interface FindWord {
    List<Word> findWord(String key, int pageIndex, int pageSize);
}
