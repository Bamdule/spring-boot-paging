package com.example.springbootpaging.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootpaging.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>, MemberRepositoryCustom {
}
