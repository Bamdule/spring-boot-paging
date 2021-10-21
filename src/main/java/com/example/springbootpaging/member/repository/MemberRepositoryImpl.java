package com.example.springbootpaging.member.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.springbootpaging.member.entity.Member;
import com.example.springbootpaging.member.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class MemberRepositoryImpl implements MemberRepositoryCustom {

    @Autowired
    private EntityManager em;

    @Override
    public List<Member> getMembers() {
        JPAQueryFactory query = new JPAQueryFactory(em);
        return query.selectFrom(QMember.member)
            .fetch();
    }
}
