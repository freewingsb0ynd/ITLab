package com.topica.vn.lab16.service.impl;

import com.topica.vn.lab16.model.Type;
import com.topica.vn.lab16.repository.TypeRepository;
import com.topica.vn.lab16.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Type> findByName(String name, int pageIndex, int pageSize) {
        return typeRepository.findByName(name, new PageRequest(pageIndex, pageSize)).getContent();
    }
}
