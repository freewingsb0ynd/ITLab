package com.topica.vn.lab16.repository;

import com.topica.vn.lab16.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    Page<Type> findByName(String type, Pageable pageable);
}
