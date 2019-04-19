package com.topica.vn.lab16.service;

import com.topica.vn.lab16.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findByType(String type, int pageIndex, int pageSize);

    void updateCategory(Long id, String name);
}
