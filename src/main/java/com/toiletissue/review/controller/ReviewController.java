package com.toiletissue.review.controller;

import com.toiletissue.review.model.dto.ReviewDTO;
import com.toiletissue.review.model.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/declared")
    public String reviewDeclared(
            Model model){
        List<ReviewDTO> reviewList = reviewService.selectAllReview();

        model.addAttribute("reviewList",reviewList);

        return "/review/declared";
    }

    @GetMapping("/search")
    public void reviewSearch(){}

}
