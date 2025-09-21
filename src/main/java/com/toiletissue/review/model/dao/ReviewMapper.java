package com.toiletissue.review.model.dao;

import com.toiletissue.review.model.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ReviewMapper {

    List<ReviewDTO> selectDeclaredReview();

    void cancelDeclaration(ReviewDTO reviewDTO);

    List<ReviewDTO> selectAllReview(String criteria, String search);

   
    int insertReview(ReviewDTO reviewDTO);

    List<ReviewDTO> selectReviewListByStation(String stationName);
    

    void penalizeReview(int no);

    void penalizeMember(String id);
}
