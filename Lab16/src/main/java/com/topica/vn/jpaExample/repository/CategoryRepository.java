package com.topica.vn.jpaExample.repository;

import com.topica.vn.jpaExample.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select t.categories from Type t where t.name = :typeName")
    Page<Category> findByType(@Param("typeName") String type, Pageable pageable);

    @Transactional
    @Modifying
    @Query("update Category c set c.name = :name where c.id = :id")
    void updateCategory(@Param("id") Long id, @Param("name") String name);
}
