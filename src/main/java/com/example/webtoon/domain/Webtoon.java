package com.example.webtoon.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "webtoon")
@Getter @Setter
@ToString
public class Webtoon {

    @Id
    @GeneratedValue
    @Column(name = "webtoon_id")
    private Long id;

    @Column(nullable = false,length = 50)
    private String toonName;

    @Column(nullable = false,length = 10)
    private String author;

    @Column(nullable = false)
    private String url;

    private String platformNm;

    @Column(nullable = false)
    private String toonDetail;

    @Column(nullable = false)
    private SerialStatus toonStatus;

    private LocalDateTime regTime;
    private LocalDateTime updateTime;
}
