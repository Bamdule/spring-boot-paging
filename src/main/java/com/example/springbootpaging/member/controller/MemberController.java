package com.example.springbootpaging.member.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootpaging.member.entity.Member;
import com.example.springbootpaging.member.service.MemberService;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public ResponseEntity getListMember(Pageable pageable) {
        List<Member> members = memberService.getMembers();
        return ResponseEntity.ok(members);
    }
}
