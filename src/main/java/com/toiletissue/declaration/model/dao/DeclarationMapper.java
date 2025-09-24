package com.toiletissue.declaration.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DeclarationMapper {

    void insertDeclaration(@Param("reviewNo") int reviewNo,
                           @Param("memberId") String memberId);

    int existsDeclaration(@Param("reviewNo") int reviewNo,
                          @Param("memberId") String memberId);
}
