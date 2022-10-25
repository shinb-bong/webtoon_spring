package com.example.webtoon.repository;

import com.example.webtoon.domain.QWebtoon;
import com.example.webtoon.domain.SerialStatus;
import com.example.webtoon.domain.Webtoon;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WebtoonRepositoryTest {

    @Autowired
    WebtoonRepository webtoonRepository;

    @Test
    @DisplayName("웹툰 저장 테스트")
    public void createToonTest(){
        Webtoon webtoon = new Webtoon();
        webtoon.setToonName("프리드로우");
        webtoon.setAuthor("전선욱");
        webtoon.setUrl("naver.com");
        webtoon.setToonDetail("재밌음");
        webtoon.setToonStatus(SerialStatus.ING);
        webtoon.setRegTime(LocalDateTime.now());
        webtoon.setUpdateTime(LocalDateTime.now());
        Webtoon savedToon = webtoonRepository.save(webtoon);
        System.out.println(savedToon.toString());
    }

    @Test
    @DisplayName("웹툰 작가명 조회 테스트")
    public void findByToonNmTest(){
        this.createToonTest();
        List<Webtoon> findToon = webtoonRepository.findByAuthor("전선욱");
        for (Webtoon webtoon : findToon) {
            System.out.println(webtoon.toString());
        }
    }


    @Autowired
    EntityManager em;

    @Test
    @DisplayName("Querydsl 테스트")
    public void queryDslTest(){
        this.createToonTest();
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QWebtoon qwebtoon = QWebtoon.webtoon;
        JPAQuery<Webtoon> query = queryFactory.selectFrom(qwebtoon)
                .where(qwebtoon.toonStatus.eq(SerialStatus.ING))
                .orderBy(qwebtoon.regTime.desc());
        List<Webtoon> webtoonList = query.fetch();

        for (Webtoon webtoon : webtoonList) {
            System.out.println(webtoon.toString());
        }
    }
}