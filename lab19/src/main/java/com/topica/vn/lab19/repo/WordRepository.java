package com.topica.vn.lab19.repo;

import com.topica.vn.lab19.model.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    @Query(value = "SELECT * FROM word WHERE word = :inputWord", nativeQuery = true)
    Page<Word> findByType(@Param("inputWord") String type, Pageable pageable);
}
