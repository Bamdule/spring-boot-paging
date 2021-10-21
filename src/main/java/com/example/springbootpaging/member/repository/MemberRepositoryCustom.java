package com.example.springbootpaging.member.repository;

import java.util.List;

import com.example.springbootpaging.member.entity.Member;

public interface MemberRepositoryCustom {
    public List<Member> getMembers();
}
