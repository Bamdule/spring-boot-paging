package com.example.springbootpaging.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootpaging.member.entity.Member;
import com.example.springbootpaging.member.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> getMembers() {
        return memberRepository.getMembers();
    }
}

