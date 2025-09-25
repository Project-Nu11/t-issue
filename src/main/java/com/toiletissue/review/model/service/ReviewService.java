package com.toiletissue.review.model.service;

import com.toiletissue.review.model.dao.ReviewMapper;
import com.toiletissue.review.model.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    public List<ReviewDTO> selectDeclaredReview(String status) {
        return reviewMapper.selectDeclaredReview(status);
    }

    public int cancelDeclaration(ReviewDTO reviewDTO) {
        return reviewMapper.cancelDeclaration(reviewDTO);

    }

    public List<ReviewDTO> selectAllReview(String criteria, String search) {
        return reviewMapper.selectAllReview(criteria,search);
    }

    public int insertReview(ReviewDTO reviewDTO) {
        int result = 0;

        try {
            result = reviewMapper.insertReview(reviewDTO);
        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    public List<ReviewDTO> selectReviewListByStation(String stationName) {

        List<ReviewDTO> reviewList = new ArrayList<>();
        try {
            reviewList = reviewMapper.selectReviewListByStation(stationName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviewList;
    }


    public int penalizeReview(int no) {
        return reviewMapper.penalizeReview(no);
    }

    public int penalizeMember(String id) {
        return reviewMapper.penalizeMember(id);
    }

    public int deleteReview(int no) {
        return reviewMapper.deleteReview(no);

    }

    public List<ReviewDTO> selectReviewById(String id) {
        return reviewMapper.selectReviewById(id);
    }

    public List<ReviewDTO> selectDeclaredReviewById(String id) {
        return reviewMapper.selectDeclaredReviewById(id);
    }

    public void declareReview(int no) {
        reviewMapper.declareReview(no);
    }
}
