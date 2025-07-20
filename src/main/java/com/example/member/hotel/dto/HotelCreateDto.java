package com.example.member.hotel.dto;

import com.example.member.hotel.domain.Hotel;
import com.example.member.hotel.domain.HotelState;
import com.example.member.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class HotelCreateDto {
    private String hotelName;
    private String address;
    private String phoneNumber;
    private Long memberId;
    @Builder.Default
    private HotelState state = HotelState.Wait;

    public Hotel toEntity(Member member) {
        return Hotel.builder()
                .hotelName(this.hotelName)
                .address(this.address)
                .phoneNumber(this.phoneNumber)
                .state(this.state)
                .member(member)
                .build();
    }
}
