//package com.toiletissue.mypage.model.service;
//
//import com.toiletissue.member.model.dto.MemberDTO;
//import com.toiletissue.mypage.model.dao.MyPageMapper;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class MyPageService {
//    private final MyPageMapper myPageMapper;
//    private final PasswordEncoder passwordEncoder;
//
//    public MyPageService(MyPageMapper myPageMapper) {
//        this.myPageMapper = myPageMapper;
//        this.passwordEncoder = new BCryptPasswordEncoder();
//    }
//
//    @Transactional(readOnly = true)
//    public MemberDTO getProfile(String memberId) {
//        return myPageMapper.findById(memberId);
//    }
//
//    @Transactional
//    public void changePwd(String memberId, String currentPwd, String newPwd, String confirmPwd) {
//        MemberDTO memberDTO = myPageMapper.findById(memberId);
//
//        if (memberDTO == null) throw new IllegalArgumentException("회원 정보를 찾을 수 없습니다.");
//
//        if (currentPwd == null || !passwordEncoder.matches(currentPwd, memberDTO.getMemberPwd()))
//            throw new IllegalArgumentException("현재 비밀번호가 올바르지 않습니다.");
//
//        if (newPwd == null || newPwd.trim().isEmpty() || confirmPwd == null)
//            throw new IllegalArgumentException("새 비밀번호를 입력해 주세요.");
//
//        if (!newPwd.equals(confirmPwd))
//            throw new IllegalArgumentException("새 비밀번호가 일치하지 않습니다.");
//
//        if (!newPwd.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"))
//            throw new IllegalArgumentException("비밀번호는 영문과 숫자를 포함해 8자 이상이어야 합니다.");
//
//        if (passwordEncoder.matches(newPwd, memberDTO.getMemberPwd()))
//            throw new IllegalArgumentException("이전 비밀번호와 동일할 수 없습니다.");
//
//        int updated = myPageMapper.updatePasswordByMemberId(memberId, passwordEncoder.encode(newPwd));
//        if (updated == 0) throw new IllegalStateException("비밀번호 변경에 실패했습니다.");
//    }
//
//    @Transactional
//    public void withdraw(String memberId, String currentPwd) {
//
//    }
//
//}
