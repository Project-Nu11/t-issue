package com.toiletissue.penalty.controller;

import com.toiletissue.member.model.dto.MemberDTO;
import com.toiletissue.member.model.service.MemberService;
import com.toiletissue.review.model.dto.ReviewDTO;
import com.toiletissue.review.model.service.ReviewService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/penalty")
public class PenaltyController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/manager")
    public ModelAndView manager(
            ModelAndView mv
            , @Param("id") String id){
        List<MemberDTO> memberList = memberService.selectPenalizedMember();

//        List<ReviewDTO> reviewList = reviewService.selectDeclaredReviewById(id);
//
//
//        mv.addObject("reviewList",reviewList);
        mv.addObject("memberList",memberList);
        mv.setViewName("/penalty/manager");
        return mv;
    }

    @PostMapping("/restrict")
    public ModelAndView restrictMember(ModelAndView mv, @RequestParam String id){

        memberService.restrictMember(id);

        mv.setViewName("/member/manager");

        return mv;
    }


    @GetMapping("/penalizedReview")
    public String selectDeclaredReviewById(Model model, @RequestParam("id") String id){

        List<ReviewDTO> reviewList = reviewService.selectDeclaredReviewById(id);

        model.addAttribute("reviewList",reviewList);

        return "penalty/manager :: reviewList";
    }


}
