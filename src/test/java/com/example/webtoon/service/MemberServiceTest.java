package com.example.webtoon.service;

import com.example.webtoon.domain.Member;
import com.example.webtoon.dto.MemberFormDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    // Controller에서 post로올때 MemberFormDto로 받을예정
    public Member createMember(){
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setEmail("test@email.com");
        memberFormDto.setName("신봉규");
        memberFormDto.setNickName("짱짱맨");
        memberFormDto.setAddress("서대문구 창천동");
        memberFormDto.setPassword("1234");
        return Member.createMember(memberFormDto,passwordEncoder);
    }

    @Test
    @DisplayName("닉네임 중복 테스트")
    void vaildateTest(){
        Member member1 = createMember();
        Member member2 = createMember();
        member2.setEmail("daoh98@naver.com");

        memberService.saveMember(member1);

        Throwable e = assertThrows(IllegalStateException.class, () -> {
            memberService.saveMember(member2);
        });

        assertEquals("닉네임이 중복되었습니다.", e.getMessage());
    }


}