package com.example.member.hotel.domain;

import com.example.member.Common.domain.BaseTimeEntity;
import com.example.member.member.domain.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Hotel extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hotelName;
    private String address;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private HotelState state;
    private LocalDateTime answerTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public void updateState(HotelState state) {
        this.state = state;
        this.answerTime = LocalDateTime.now();
    }
}
