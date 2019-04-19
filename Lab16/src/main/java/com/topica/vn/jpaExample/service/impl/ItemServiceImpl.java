package com.topica.vn.jpaExample.service.impl;

import com.topica.vn.jpaExample.model.Category;
import com.topica.vn.jpaExample.model.Item;
import com.topica.vn.jpaExample.repo.ItemRepository;
import com.topica.vn.jpaExample.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> findByCategory(String category, int pageIndex, int pageSize) {
        return itemRepository.findByCategory(category, new PageRequest(pageIndex, pageSize)).getContent();
    }
    @Override
    public List<Category> findByType(String type, int pageIndex, int pageSize) {
        return itemRepository.findByType(type, new PageRequest(pageIndex, pageSize)).getContent();
    }
}
