package com.example.webtoon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDto {

    @Not
    private String name;
    private String email;
    private String nickName;
    private String password;
    private String zipcode;
    private String streetAdr;
    private String detailAdr;
}
