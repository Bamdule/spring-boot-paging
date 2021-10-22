package com.example.springbootpaging.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.springbootpaging.member.dto.MemberDTO;
import com.example.springbootpaging.member.dto.MemberSearchResponse;
import com.example.springbootpaging.member.entity.Member;
import com.example.springbootpaging.member.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public MemberSearchResponse getMembers(String searchText, Pageable pageable) {
        return memberRepository.getMembers(searchText, pageable);
    }

    @Override
    public Member saveMember(String name, String contact) {

        Member savedMember = memberRepository.save(
            Member.builder()
                .name(name)
                .contact(contact)
                .build()
        );

        return savedMember;
    }
}

