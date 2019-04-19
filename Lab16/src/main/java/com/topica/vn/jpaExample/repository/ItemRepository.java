package com.topica.vn.jpaExample.repository;

import com.topica.vn.jpaExample.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("select c.items from Category c where c.name = :category")
    Page<Item> findByCategory(@Param("category") String category, Pageable pageable);
}
