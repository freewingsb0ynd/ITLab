package com.topica.vn.lab16.service.impl;

import com.topica.vn.lab16.model.Category;
import com.topica.vn.lab16.repository.CategoryRepository;
import com.topica.vn.lab16.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findByType(String type, int pageIndex, int pageSize) {
        return categoryRepository.findByType(type, new PageRequest(pageIndex, pageSize)).getContent();
    }

    @Override
    public void updateCategory(Long id, String name) {
        categoryRepository.updateCategory(id, name);
    }
}
