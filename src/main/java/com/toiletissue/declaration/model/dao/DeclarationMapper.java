package com.toiletissue.declaration.model.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeclarationMapper {
    int declareReview(int no, String id);

}
