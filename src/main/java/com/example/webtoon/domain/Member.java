package com.example.webtoon.domain;

import com.example.webtoon.dto.MemberFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter @Setter
@ToString
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String nickName;

    private String password;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberFormDto memberFormDto,
                                      PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setNickName(memberFormDto.getNickName());
        member.setEmail(memberFormDto.getEmail());
        String password = passwordEncoder.encode(memberFormDto.getPassword());
        member.setPassword(password);
        member.setRole(Role.USER);
        Address address = new Address(memberFormDto.getZipcode(), memberFormDto.getStreetAdr(), memberFormDto.getStreetAdr());
        member.setAddress(address);
        return member;
    }

}
