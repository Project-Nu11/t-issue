package com.toiletissue.mypage.model.dao;

import com.toiletissue.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MyPageMapper {

    MemberDTO findById(@Param("memberId") String memberId);

    int updatePasswordByMemberId(@Param("memberId") String memberId,
                                 @Param("encodedPwd") String encodedPwd);

    int softDelete(@Param("memberId") String memberId);
}
