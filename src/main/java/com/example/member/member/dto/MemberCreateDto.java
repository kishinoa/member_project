package com.example.member.member.dto;

import com.example.member.member.domain.Member;
import com.example.member.member.domain.MemberType;
import com.example.member.member.domain.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberCreateDto {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    @Builder.Default
    private State state = State.normal;
    @Builder.Default
    private MemberType type = MemberType.User;

    public Member toEntity() {
        return Member.builder()
                .name(this.name)
                .email(this.email)
                .password(this.password)
                .phoneNumber(this.phoneNumber)
                .state(this.state)
                .type(this.type)
                .build();
    }
}
