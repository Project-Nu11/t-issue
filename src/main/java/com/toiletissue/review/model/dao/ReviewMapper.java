package com.toiletissue.review.model.dao;

import com.toiletissue.review.model.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ReviewMapper {
    List<ReviewDTO> selectAllReview();
}
