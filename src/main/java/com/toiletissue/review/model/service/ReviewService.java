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

    public List<ReviewDTO> selectAllReview() {
        return reviewMapper.selectAllReview();
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
}
