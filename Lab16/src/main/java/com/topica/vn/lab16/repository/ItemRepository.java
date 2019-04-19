package com.topica.vn.lab16.repository;

import com.topica.vn.lab16.model.Item;
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
