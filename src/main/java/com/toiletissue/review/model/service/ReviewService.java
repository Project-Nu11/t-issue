package com.toiletissue.review.model.service;

import com.toiletissue.review.model.dao.ReviewMapper;
import com.toiletissue.review.model.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    public List<ReviewDTO> selectDeclaredReview() {
        return reviewMapper.selectDeclaredReview();
    }

    public void cancelDeclaration(ReviewDTO reviewDTO) {
        reviewMapper.cancelDeclaration(reviewDTO);
    }

    public List<ReviewDTO> selectAllReview(String criteria, String search) {
        return reviewMapper.selectAllReview(criteria,search);
    }
}
