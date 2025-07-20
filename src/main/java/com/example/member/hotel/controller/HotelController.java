package com.example.member.hotel.controller;

import com.example.member.Common.dto.CommonDto;
import com.example.member.hotel.dto.HotelCreateDto;
import com.example.member.hotel.dto.HotelStateUpdateDto;
import com.example.member.hotel.service.HotelService;
import com.example.member.member.dto.MemberCreateDto;
import com.example.member.member.dto.MemberUpdatePwDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping("/create")
    public ResponseEntity<?> save(@Valid @RequestBody HotelCreateDto hotelCreateDto) {
        System.out.println("1");
        hotelService.save(hotelCreateDto);
        return new ResponseEntity<>(new CommonDto("OK", HttpStatus.CREATED.value(), "생성완료"), HttpStatus.CREATED);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(new CommonDto(hotelService.findById(id), HttpStatus.OK.value(), "해당 멤버를 찾았습니다."), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> findAll(@PageableDefault(size = 6, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return new ResponseEntity<>(hotelService.findAll(pageable), HttpStatus.OK);
    }

    @PatchMapping("/updatestate")
    public ResponseEntity<?> updateState(@RequestBody HotelStateUpdateDto hotelStateUpdateDto) {
        hotelService.updateState(hotelStateUpdateDto);
        return new ResponseEntity<>("호텔상태 변경완료", HttpStatus.OK);
    }
}
