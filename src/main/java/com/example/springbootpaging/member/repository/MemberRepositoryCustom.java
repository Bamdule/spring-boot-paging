package com.example.springbootpaging.member.repository;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.example.springbootpaging.member.dto.MemberDTO;
import com.example.springbootpaging.member.dto.MemberSearchResponse;
import com.example.springbootpaging.member.entity.Member;

public interface MemberRepositoryCustom {
    public MemberSearchResponse getMembers(String searchText, Pageable pageable);
}
