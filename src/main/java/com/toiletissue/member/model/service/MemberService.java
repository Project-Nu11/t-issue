package com.toiletissue.member.model.service;

import com.toiletissue.member.model.dao.MemberMapper;
import com.toiletissue.member.model.dto.MemberLoginDTO;
import com.toiletissue.member.model.dto.MemberSignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public MemberLoginDTO findByUsername(String username) {
        return new  MemberLoginDTO();
    }

    public int insert(MemberSignupDTO memberSignupDTO) {

        return 0;
    }


//    public int insert(MemberSignupDTO memberSignupDTO) {
//        memberSignupDTO.setMemberPwd(memberSignupDTO.getMemberPwd());
//
//        int result = 0;
//
//
//    }
//
//    public MemberLoginDTO findByUsername(String username) {
//
//    }
}
