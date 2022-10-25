package com.example.webtoon.dto;

import com.example.webtoon.domain.SerialStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
public class WebtoonDto {
    private Long id;
    private String toonNm;
    private String author;
    private String url;
    private String toonDetail;
    private String toonStatCd;
    private LocalDateTime regTime;
    private LocalDateTime updateTime;
}
