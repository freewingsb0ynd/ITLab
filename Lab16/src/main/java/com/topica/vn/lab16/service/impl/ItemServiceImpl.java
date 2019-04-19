package com.topica.vn.lab16.service.impl;

import com.topica.vn.lab16.model.Item;
import com.topica.vn.lab16.repository.ItemRepository;
import com.topica.vn.lab16.service.ItemService;
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
}
