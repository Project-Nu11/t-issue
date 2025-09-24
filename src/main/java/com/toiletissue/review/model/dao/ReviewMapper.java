package com.toiletissue.review.model.dao;

import com.toiletissue.review.model.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ReviewMapper {

    List<ReviewDTO> selectDeclaredReview(String status);

    int cancelDeclaration(ReviewDTO reviewDTO);

    List<ReviewDTO> selectAllReview(String criteria, String search);

   
    int insertReview(ReviewDTO reviewDTO);

    List<ReviewDTO> selectReviewListByStation(String stationName);
    

    int penalizeReview(int no);

    int penalizeMember(String id);

    int deleteReview(int no);

    List<ReviewDTO> selectReviewById(String id);

    List<ReviewDTO> selectDeclaredReviewById(String id);
}
