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

    /* 아이디 중복확인*/
    public boolean existsById(String memberId) {
        return memberMapper.countById(memberId) > 0;
    }

    /* 회원가입 */
    @Transactional
    public void register(MemberDTO member) {

        if (existsById(member.getMemberId())) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }

        // 비밀번호 필수/길이
        if (member.getMemberPwd() == null || member.getMemberPwd().length() < 8) {
            throw new IllegalArgumentException("비밀번호는 8자 이상이어야 합니다.");
        }

        // 비밀번호 암호화
        member.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));

        // 기본 권한
        if (member.getRole() == null || member.getRole().isBlank()) {
            member.setRole("ROLE_USER");
        }

        // 탈퇴 여부
        member.setEndStatus(false);

        memberMapper.insertMember(member);
    }

    /* 로그인 시 호출 (Spring Security) */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberDTO member = memberMapper.findById(username);
        if (member == null) {
            throw new UsernameNotFoundException("해당 회원을 찾을 수 없습니다: " + username);
        }

        // DB가 'ROLE_USER' 이라서 roles()에 넣기 위해 'ROLE_' 로
        String roleForBuilder = (member.getRole() == null) ? "USER" : member.getRole().replace("ROLE_", "");

        return User.builder()
                .username(member.getMemberId())
                .password(member.getMemberPwd())
                .roles(roleForBuilder)
                .build();
    }

    /* 단일/전체 조회 */
    @Transactional(readOnly = true)
    public MemberDTO findById(String memberId) {
        return memberMapper.findById(memberId);
    }

    @Transactional(readOnly = true)
    public List<MemberDTO> findAll() {
        return memberMapper.findAll();
    }

    public void login(MemberDTO memberDTO) {}
}




