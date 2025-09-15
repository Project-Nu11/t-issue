package com.toiletissue.member.model.service;

import com.toiletissue.member.model.dao.MemberMapper;
import com.toiletissue.member.model.dto.MemberDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService implements UserDetailsService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 회원가입
     */
    @Transactional
    public void register(MemberDTO member) {
        // 비밀번호 암호화
        member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));

        // 기본 권한: ROLE_USER
        if (member.getRole() == null || member.getRole().isBlank()) {
            member.setRole("ROLE_USER");
        }

        // 탈퇴 여부 기본값
        member.setEndStatus(false);

        System.out.println("회원가입 처리: " + member);

        memberMapper.insertMember(member);
    }

    /**
     * 로그인 시 호출되는 메서드 (Spring Security)
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberDTO member = memberMapper.findById(username);

        if (member == null) {
            throw new UsernameNotFoundException("해당 회원을 찾을 수 없습니다: " + username);
        }

        return User.builder()
                .username(member.getMemberId())
                .password(member.getMemberPwd())
                // DB에 ROLE_USER 저장되어 있으므로 ROLE_ 제거 후 roles() 사용
                .roles(member.getRole().replace("ROLE_", ""))
                .build();
    }

    /**
     * 단일 회원 조회
     */
    public MemberDTO findById(String memberId) {
        return memberMapper.findById(memberId);
    }

    /**
     * 전체 회원 조회
     */
    public List<MemberDTO> findAll() {
        return memberMapper.findAll();
    }

    public void login(MemberDTO memberDTO) {
    }
}



