package com.toiletissue.member.model.dao;

import com.toiletissue.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    // 이름 + 이메일로 아이디 찾기
    String findMemberIdByNameAndEmail(@Param("memberName") String memberName,
                                      @Param("email") String email);

    // 아이디 + 이름 + 이메일 존재 여부 확인
    int existsByIdNameEmail(@Param("memberId") String memberId,
                                @Param("memberName") String memberName,
                                @Param("email") String email);

    // 비밀번호 업데이트 (임시 비번 반영)
    int updatePasswordByMemberId(@Param("memberId") String memberId,
                                 @Param("encodedPwd") String encodedPwd);

    List<MemberDTO> selectAllMember();

    void restrictMember(String id);

    List<MemberDTO> selectPenalizedMember();

//    MemberDTO select(int id);
}