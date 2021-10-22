package com.example.springbootpaging.member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootpaging.member.dto.MemberDTO;
import com.example.springbootpaging.member.dto.MemberSearchResponse;
import com.example.springbootpaging.member.entity.Member;
import com.example.springbootpaging.member.service.MemberService;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity saveMember(String name, String contact) {
        Member saveMember = memberService.saveMember(name, contact);

        return ResponseEntity.ok(saveMember);
    }

    @GetMapping
    public ResponseEntity getListMember(
        @RequestParam(value = "searchText", defaultValue = "") String searchText,
        Pageable pageable) {
        MemberSearchResponse memberSearchResponse = memberService.getMembers(searchText, pageable);
        return ResponseEntity.ok(memberSearchResponse);
    }
}
