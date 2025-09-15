package com.toiletissue.member.model.dao;

import com.toiletissue.member.model.dto.MemberLoginDTO;
import com.toiletissue.member.model.dto.MemberSignupDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface MemberMapper {

    int insert(MemberSignupDTO memberSignupDTO);

    MemberLoginDTO findByMemberId(@Param("memberId") String memberId);  //로그인은 아이디(memberId)로

    int exists(@Param("memberId") String memberId);
}

