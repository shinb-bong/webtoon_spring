package com.example.webtoon.service;

import com.example.webtoon.domain.Member;
import com.example.webtoon.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    public Member saveMember(Member member){
        validateMember(member);
        return memberRepository.save(member);
    }

    private void validateMember(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember!=null){
            throw new IllegalStateException("이메일이 중복되었습니다.");
        }
        findMember = memberRepository.findByNickName(member.getNickName());
        if(findMember!=null){
            throw new IllegalStateException("닉네임이 중복되었습니다.");
        }
    }
}
