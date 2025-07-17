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
public class MemberDetailDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private MemberType type;
    private State state;

    public static MemberDetailDto fromEntity(Member member) {
        return new MemberDetailDto(member.getId(), member.getName(), member.getEmail(), member.getPhoneNumber(), member.getType(), member.getState());
    }
}
