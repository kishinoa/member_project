package com.example.member.controller;

import com.example.member.dto.CommonDto;
import com.example.member.dto.MemberCreateDto;
import com.example.member.dto.MemberUpdatePwDto;
import com.example.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody MemberCreateDto memberCreateDto) {
        memberService.save(memberCreateDto);
        return new ResponseEntity<>(new CommonDto("OK", HttpStatus.CREATED.value(), "생성완료"), HttpStatus.CREATED);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(new CommonDto(memberService.findById(id), HttpStatus.OK.value(), "해당 멤버를 찾았습니다."), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(memberService.findAll(), HttpStatus.OK);
    }

    @PatchMapping("/updatepw")
    public ResponseEntity<?> updatePw(@RequestBody MemberUpdatePwDto memberUpdatePwDto) {
        memberService.updatePw(memberUpdatePwDto);
        return new ResponseEntity<>("비밀번호 변경완료", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        memberService.delete(id);
        return new ResponseEntity<>("계정탈퇴완료", HttpStatus.OK);
    }
}
