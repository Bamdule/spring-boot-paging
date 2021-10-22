package com.example.springbootpaging.member.repository;

import static com.example.springbootpaging.member.entity.QMember.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.example.springbootpaging.member.dto.MemberDTO;
import com.example.springbootpaging.member.dto.MemberSearchResponse;
import com.example.springbootpaging.member.entity.Member;
import com.example.springbootpaging.member.entity.QMember;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class MemberRepositoryImpl implements MemberRepositoryCustom {

    @Autowired
    private EntityManager em;



    @Override
    public MemberSearchResponse getMembers(String searchText, Pageable pageable) {
        BooleanBuilder whereBuilder = new BooleanBuilder();

        if (StringUtils.hasText(searchText)) {
            whereBuilder.and(member.name.startsWith(searchText));
        }

        JPAQueryFactory query = new JPAQueryFactory(em);
        QueryResults<MemberDTO> results = query.select(Projections.bean(
                MemberDTO.class,
                member.id,
                member.contact,
                member.name
            ))
            .from(member)
            .where(whereBuilder)
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetchResults();

        return MemberSearchResponse.builder()
            .members(results.getResults())
            .page(pageable.getPageNumber())
            .size(pageable.getPageSize())
            .total(results.getTotal())
            .build();
    }
}
