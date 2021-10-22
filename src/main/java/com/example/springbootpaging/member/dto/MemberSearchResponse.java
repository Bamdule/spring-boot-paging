package com.example.springbootpaging.member.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberSearchResponse {
    private List<MemberDTO> members;

    private long total;
    private long page;
    private long size;
}
