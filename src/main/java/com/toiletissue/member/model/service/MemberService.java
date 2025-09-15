//package com.toiletissue.member.model.service;
//
//import com.toiletissue.common.MemberRole;
//import com.toiletissue.member.model.dao.MemberMapper;
//import com.toiletissue.member.model.dto.MemberLoginDTO;
//import com.toiletissue.member.model.dto.MemberSignupDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Objects;
//
//@Service
//public class MemberService {
//
//    @Autowired
//    private MemberMapper memberMapper;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public int insert(MemberSignupDTO memberSignupDTO) {
//
//        memberSignupDTO.setMemberPwd(passwordEncoder.encode(memberSignupDTO.getMemberPwd()));
//
//        int result = 0;
//        try {
//            result = memberMapper.insert(memberSignupDTO);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }
//
//    public MemberLoginDTO findByMemberId(String username) {
//
//        MemberLoginDTO memberLoginDTO = memberMapper.findByMemberId(username);
//
//        if (!Objects.isNull(memberLoginDTO)) {
//
//            memberLoginDTO.setMemberRole(MemberRole.member);
//
//            return memberLoginDTO;
//        } else {
//            return null;
//        }
//    }
//
//
//    public boolean exists(String memberId) {
//
//        int count = 0;
//
//        try {
//            count = memberMapper.exists(memberId);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return count > 0;
//    }
//
//}
//
//
