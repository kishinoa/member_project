package com.example.member.member.dto;

import com.example.member.member.domain.Member;
import com.example.member.member.domain.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MemberListDto {
    private Long id;
    private String name;
    private String email;
    private State state;

    public static MemberListDto fromEntity(Member member) {
        return MemberListDto.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .state(member.getState())
                .build();
    }
}
