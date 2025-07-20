package com.example.member.hotel.service;

import com.example.member.hotel.domain.Hotel;
import com.example.member.hotel.dto.HotelCreateDto;
import com.example.member.hotel.dto.HotelDetailDto;
import com.example.member.hotel.dto.HotelListDto;
import com.example.member.hotel.dto.HotelStateUpdateDto;
import com.example.member.hotel.repository.HotelRepository;
import com.example.member.member.domain.Member;
import com.example.member.member.domain.MemberType;
import com.example.member.member.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class HotelService {

    private final HotelRepository hotelRepository;

    private final MemberRepository memberRepository;

    public void save(@Valid HotelCreateDto hotelCreateDto) {
        Member member = memberRepository.findById(hotelCreateDto.getMemberId()).orElseThrow(() -> new EntityNotFoundException("해당 ID가 없습니다."));
        if(member.getType()!=MemberType.Host) {
            throw new IllegalArgumentException("호스트가 아니라 호텔을 등록할 수 없습니다.");
        }
        hotelRepository.save(hotelCreateDto.toEntity(member));
    }


    public HotelDetailDto findById(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(""));
        return HotelDetailDto.fromEntity(hotel);
    }

    public Page<HotelListDto> findAll(Pageable pageable) {
        Page<Hotel> hotels = hotelRepository.findAll(pageable);
        return hotels.map(a->HotelListDto.fromEntity(a));
    }

    public void updateState(HotelStateUpdateDto hotelStateUpdateDto) {
        Member member = memberRepository.findByEmail(hotelStateUpdateDto.getEmail()).orElseThrow(() -> new EntityNotFoundException("없는 계정입니다."));
        if(member.getType()!=MemberType.Admin) {
            throw new IllegalArgumentException("관리자 계정이 아닙니다.");
        }
        Hotel hotel = hotelRepository.findById(hotelStateUpdateDto.getTargetId()).orElseThrow(() -> new EntityNotFoundException("존재하지 않는 호텔입니다."));
        hotel.updateState(hotelStateUpdateDto.getState());
    }
}
