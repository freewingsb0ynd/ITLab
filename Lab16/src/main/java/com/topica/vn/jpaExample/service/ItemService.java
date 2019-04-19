package com.topica.vn.jpaExample.service;

import com.topica.vn.jpaExample.model.Category;
import com.topica.vn.jpaExample.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> findByCategory(String category, int pageIndex, int pageSize);


}
