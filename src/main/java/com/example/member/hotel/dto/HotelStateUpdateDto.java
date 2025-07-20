package com.example.member.hotel.dto;

import com.example.member.hotel.domain.HotelState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HotelStateUpdateDto {
    private Long targetId;
    private String email;
    private HotelState state;
}
