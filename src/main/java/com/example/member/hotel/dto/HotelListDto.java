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
public class HotelListDto {
    private String hotelName;
    private String address;
    private HotelState hotelState;
    private String memberEmail;

    public static HotelListDto fromEntity(Hotel hotel) {
        return HotelListDto.builder()
                .hotelName(hotel.getHotelName())
                .address(hotel.getAddress())
                .hotelState(hotel.getState())
                .memberEmail(hotel.getMember().getEmail())
                .build();
    }

}
