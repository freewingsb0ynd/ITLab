package com.topica.vn.jpaExample.service.impl;

import com.topica.vn.jpaExample.repo.CategoryRepository;
import com.topica.vn.jpaExample.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public void updateCategory(Long id, String name) {
        categoryRepository.updateCategory(id, name);
    }
}
