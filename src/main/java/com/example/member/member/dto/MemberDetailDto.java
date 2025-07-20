package com.example.member.member.dto;

import com.example.member.member.domain.Member;
import com.example.member.member.domain.MemberType;
import com.example.member.member.domain.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MemberDetailDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private MemberType type;
    private State state;

    public static MemberDetailDto fromEntity(Member member) {
        return MemberDetailDto.builder()
                .id(member.getId())
                .email(member.getEmail())
                .name(member.getName())
                .phoneNumber(member.getPhoneNumber())
                .type(member.getType())
                .state(member.getState())
                .build();
    }
}
