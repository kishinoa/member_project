package com.example.member.hotel.dto;

import com.example.member.hotel.domain.Hotel;
import com.example.member.hotel.domain.HotelState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HotelDetailDto {
    private String hotelName;
    private String address;
    private String phoneNumber;
    private HotelState hotelState;
    private String memberName;

    public static HotelDetailDto fromEntity(Hotel hotel) {
        return HotelDetailDto.builder()
                .hotelName(hotel.getHotelName())
                .address(hotel.getAddress())
                .phoneNumber(hotel.getPhoneNumber())
                .hotelState(hotel.getState())
                .memberName(hotel.getMember().getName())
                .build();
    }
}
