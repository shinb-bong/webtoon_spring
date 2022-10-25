package com.example.webtoon.repository;

import com.example.webtoon.domain.Webtoon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WebtoonRepository extends JpaRepository<Webtoon,Long> {

    List<Webtoon> findByToonName(String toonName);

    @Query("select w from Webtoon w where w.toonDetail like %:toonDetail% order by w.regTime desc")
    List<Webtoon> findByWebToonDetail(@Param("toonDetail") String toonDetail);

    List<Webtoon> findByAuthor(String author);
}
