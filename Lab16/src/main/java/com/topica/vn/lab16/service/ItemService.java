package com.topica.vn.lab16.service;

import com.topica.vn.lab16.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> findByCategory(String category, int pageIndex, int pageSize);
}
