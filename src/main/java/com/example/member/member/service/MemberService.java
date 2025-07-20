package com.example.member.member.service;

import com.example.member.member.domain.Member;
import com.example.member.member.dto.MemberCreateDto;
import com.example.member.member.dto.MemberDetailDto;
import com.example.member.member.dto.MemberListDto;
import com.example.member.member.dto.MemberUpdatePwDto;
import com.example.member.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void save(MemberCreateDto memberCreateDto) {
        if(memberRepository.findByEmail(memberCreateDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("존재하는 이메일입니다.");
        }
        if(memberCreateDto.getPassword().length() < 4) {
            throw new IllegalArgumentException("비밀번호 길이가 4자리 미만 입니다.");
        }
        memberRepository.save(memberCreateDto.toEntity());
    }

    @Transactional(readOnly = true)
    public MemberDetailDto findById(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new NoSuchElementException("존재하는 멤버가 없습니다."));
        return MemberDetailDto.fromEntity(member);
    }

    @Transactional(readOnly = true)
    public List<MemberListDto> findAll() {
        return memberRepository.findAll().stream().map(MemberListDto::fromEntity).collect(Collectors.toList());
    }

    public void updatePw(MemberUpdatePwDto memberUpdatePwDto) {
        Member member = memberRepository.findByEmail(memberUpdatePwDto.getEmail()).orElseThrow(() -> new NoSuchElementException("존재하지 않는 이메일 입니다."));
        if(memberUpdatePwDto.getPassword().length() < 4) {
            throw new IllegalArgumentException("비밀번호 길이가 4자리 미만 입니다.");
        }
        member.updatePw(memberUpdatePwDto.getPassword());
    }

    public void delete(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new NoSuchElementException("존재하는 계정이 없습니다."));
        member.updateState();
    }
}
