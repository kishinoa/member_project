package com.example.member.dto;

import com.example.member.domain.Member;
import com.example.member.domain.MemberType;
import com.example.member.domain.State;
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
        return new Member(this.name, this.email, this.password, this.phoneNumber, this.state, this.type);
    }
}
