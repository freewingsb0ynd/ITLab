package com.topica.vn.lab16.service;

import com.topica.vn.lab16.model.Type;

import java.util.List;

public interface TypeService {
    List<Type> findByName(String name, int pageIndex, int pageSize);
}
