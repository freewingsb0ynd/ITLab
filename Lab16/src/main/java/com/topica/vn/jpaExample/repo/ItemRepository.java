package com.topica.vn.jpaExample.repo;

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
    @Query(value = "SELECT * FROM item i JOIN item_category ic ON i.id = ic.item_id JOIN category c ON c.id = ic.category_id WHERE c.name = :category", nativeQuery = true)
    Page<Item> findByCategory(@Param("category") String category, Pageable pageable);

}
