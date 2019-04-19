package com.topica.vn.jpaExample.service.impl;

import com.topica.vn.jpaExample.model.Category;
import com.topica.vn.jpaExample.repository.CategoryRepository;
import com.topica.vn.jpaExample.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public void updateCategory(Long id, String name) {
        categoryRepository.updateCategory(id, name);
    }
}
