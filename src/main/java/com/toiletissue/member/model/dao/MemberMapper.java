package com.toiletissue.member.model.dao;

import com.toiletissue.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Mapper
public interface MemberMapper {

    void insertMember(MemberDTO member);   // 회원가입

    MemberDTO findById(@Param("memberId")String memberId);   // 로그인/단일조회

    List<MemberDTO> findAll();             // 전체조회

//    MemberDTO select(int id);
}