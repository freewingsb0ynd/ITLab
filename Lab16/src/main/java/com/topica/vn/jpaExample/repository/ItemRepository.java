package com.topica.vn.jpaExample.repository;

import com.topica.vn.jpaExample.model.Category;
import com.topica.vn.jpaExample.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("SELECT c.items FROM Category c WHERE c.name = :category")
    Page<Item> findByCategory(@Param("category") String category, Pageable pageable);

    @Query("SELECT t.categories FROM Type t WHERE t.name = :typeName")
    Page<Category> findByType(@Param("typeName") String type, Pageable pageable);
}
