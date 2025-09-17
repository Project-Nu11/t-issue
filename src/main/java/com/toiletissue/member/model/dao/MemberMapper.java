package com.toiletissue.member.model.dao;

import com.toiletissue.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Mapper
public interface MemberMapper {

    // 회원가입
    void insertMember(MemberDTO member);

    // 아이디 중복 확인
    int countById(@Param("memberId") String memberId);

    // 단일/전체 조회
    MemberDTO findById(@Param("memberId") String memberId);
    List<MemberDTO> findAll();

//    MemberDTO select(int id);
}