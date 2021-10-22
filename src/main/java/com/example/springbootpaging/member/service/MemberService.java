package com.example.springbootpaging.member.service;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.example.springbootpaging.member.dto.MemberDTO;
import com.example.springbootpaging.member.dto.MemberSearchResponse;
import com.example.springbootpaging.member.entity.Member;

public interface MemberService {
    public MemberSearchResponse getMembers(String searchText, Pageable pageable);

    public Member saveMember(String name, String contact);
}
