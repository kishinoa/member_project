package com.example.member.dto;

import com.example.member.domain.Member;
import com.example.member.domain.MemberType;
import com.example.member.domain.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberListDto {
    private Long id;
    private String name;
    private String email;
    private State state;

    public static MemberListDto fromEntity(Member member) {
        return new MemberListDto(member.getId(), member.getName(), member.getEmail(), member.getState());
    }
}
