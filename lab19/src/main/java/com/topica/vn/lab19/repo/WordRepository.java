package com.topica.vn.lab19.repo;

import com.topica.vn.lab19.model.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    @Query(value = "SELECT * FROM word WHERE word LIKE CONCAT((:inputWord), '%')", nativeQuery = true)
    Page<Word> findByWord(@Param("inputWord") String type, Pageable pageable);

    @Query(value = "SELECT * FROM dictionary WHERE word = :word limit 1", nativeQuery = true)
    Word findByWord(String word);

    @Modifying
    @Query(value = "INSERT INTO dictionary (word, mean) VALUES (:word, :mean)",
            nativeQuery = true)
    void insertToDictionary(@Param("word") String word, @Param("mean") String mean);
}
