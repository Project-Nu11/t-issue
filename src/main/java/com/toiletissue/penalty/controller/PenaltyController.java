package com.toiletissue.penalty.controller;

import com.toiletissue.member.model.dto.MemberDTO;
import com.toiletissue.member.model.service.MemberService;
import com.toiletissue.review.model.dto.ReviewDTO;
import com.toiletissue.review.model.service.ReviewService;
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
    public void manager(Model model
            , @RequestParam(value = "page",defaultValue = "1") int page
            , @RequestParam("id") String id
    ){

        List<MemberDTO> memberList = memberService.selectPenalizedMember();
        for(MemberDTO mem : memberList){
            System.out.println(mem);
        }
//        List<ReviewDTO> reviewList = reviewService.selectReviewById(id);


        int totalMember = memberList.size();
        int pageSize = 10;
        int totalPage = (int)(Math.ceil((double)totalMember/pageSize));

        if(page<0){
            page = 1;
        } else if(page >totalPage){
            page = totalPage;
        }

        int start = (page-1)*pageSize;
        int end = Math.min(start+pageSize,totalMember);
        System.out.println("start = " + start);
        System.out.println("end = " + end);

        List<MemberDTO> pagedMembers = new ArrayList<>();
        if(!memberList.isEmpty()){
            pagedMembers = memberList.subList(start,end);
        }
        for(MemberDTO mem : pagedMembers){
            System.out.println(mem);
        }

        int buttonCount = 10;
        int startPage = ((page-1)/buttonCount)*buttonCount+1;
        int endPage = Math.min(startPage+buttonCount,totalPage);

        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("page",page);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("memberList",pagedMembers);
    }

    @PostMapping("/restrict")
    public ModelAndView restrictMember(ModelAndView mv, @RequestParam String id){

        memberService.restrictMember(id);

        mv.setViewName("redirect:/member/manager");

        return mv;
    }
}
