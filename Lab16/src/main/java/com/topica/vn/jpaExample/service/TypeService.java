package com.topica.vn.jpaExample.service;

import com.topica.vn.jpaExample.model.Type;

import java.util.List;

public interface TypeService {
    List<Type> findByName(String name, int pageIndex, int pageSize);
}
