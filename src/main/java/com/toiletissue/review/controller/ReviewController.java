package com.toiletissue.review.controller;

import com.toiletissue.request.model.dto.RequestDTO;
import com.toiletissue.review.model.dto.ReviewDTO;
import com.toiletissue.review.model.service.ReviewService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/declared")
    public String reviewDeclared(
            Model model,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value="status",defaultValue = "-1") String status
    ){


        List<ReviewDTO> reviewList = reviewService.selectDeclaredReview(status);


        int totalRequests = reviewList.size(); // 총 문의 수
        int pageSize = 10; // 한 페이지당 문의 수
        int totalPages = (int)(Math.ceil((double)totalRequests/pageSize)); // 총 페이지 수

        if(page <= 0){
            page = 1;
        } else if(page > totalPages){
            page = totalPages;
        }
        int start = (page-1)*pageSize; //페이지 시작 문의 번호
        int end = Math.min(start+pageSize,totalRequests); // 페이지 끝 문의 번호

        List<ReviewDTO> pagedReviews = new ArrayList<>();
        if(!reviewList.isEmpty()){
            pagedReviews = reviewList.subList(start,end);
        }

        System.out.println("page = " + page);
        System.out.println("totalPages = " + totalPages);
        System.out.println("end = " + end);
        System.out.println("start = " + start);
        for(ReviewDTO rev : pagedReviews){
            System.out.println("페이지에 보여주세요 declared review"+rev);
        }
        int buttonCount = 10; // 한 번에 보여질 페이지 버튼 수
        int startPage = ((page - 1) / buttonCount) * buttonCount + 1;
        int endPage = Math.min(startPage + buttonCount - 1, totalPages);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("page",page);
        model.addAttribute("totalPages",totalPages);

        model.addAttribute("reviewList",pagedReviews);
        model.addAttribute("status",status);

        return "/review/declared";
    }

    @GetMapping("/search")
    public String reviewSearch(
            Model model,
            @RequestParam(value = "page2", defaultValue = "1") int page,
            @RequestParam(value="criteria", defaultValue = "r.review_no") String criteria,
            @RequestParam(value="search",defaultValue = "%%") String search)
    {


        List<ReviewDTO> reviewList2 = reviewService.selectAllReview(criteria,search);


        int totalRequests = reviewList2.size(); // 총 문의 수
        int pageSize = 10; // 한 페이지당 문의 수
        int totalPages = (int)(Math.ceil((double)totalRequests/pageSize)); // 총 페이지 수

        if(page <= 0){
            page = 1;
        } else if(page > totalPages){
            page = totalPages;
        }
        int start = (page-1)*pageSize; //페이지 시작 문의 번호
        int end = Math.min(start+pageSize,totalRequests); // 페이지 끝 문의 번호

        List<ReviewDTO> pagedReviews2 = new ArrayList<>();
        if(!reviewList2.isEmpty()){
            pagedReviews2 = reviewList2.subList(start,end);
        }
        for(ReviewDTO rev : pagedReviews2){
            System.out.println("1페이지에 보여주세요 all review"+rev);
        }
        System.out.println("page = " + page);
        System.out.println("totalPages = " + totalPages);
        System.out.println("end = " + end);
        System.out.println("start = " + start);
        for(ReviewDTO rev : pagedReviews2){
            System.out.println("페이지에 보여주세요 all review"+rev);
        }
        int buttonCount = 10; // 한 번에 보여질 페이지 버튼 수
        int startPage = ((page - 1) / buttonCount) * buttonCount + 1;
        int endPage = Math.min(startPage + buttonCount - 1, totalPages);

        model.addAttribute("startPage2", startPage);
        model.addAttribute("endPage2", endPage);




        model.addAttribute("reviewList2",pagedReviews2);
//        model.addAttribute("value",value);
        model.addAttribute("page2",page);
        model.addAttribute("totalPages2",totalPages);
        model.addAttribute("criteria",criteria);
        model.addAttribute("search",search);

        return "/review/search";
    }

    @PostMapping("/declared/cancel")
    public ModelAndView cancelDeclaration(ModelAndView mv, @ModelAttribute ReviewDTO reviewDTO,
                                          RedirectAttributes rttr){

        int result =reviewService.cancelDeclaration(reviewDTO);
        String message = "";

        if(result>0){
            message = "신고 취소에 성공하였습니다.";
        } else{
            message = "신고 취소에 실패하였습니다.";
        }

        rttr.addFlashAttribute("message",message);
        mv.setViewName("redirect:/review/declared");


        return mv;
    }

    @PostMapping("/penalty")
    public ModelAndView penalizeReview(
            ModelAndView mv,
            @RequestParam("no")int no,
            @RequestParam("id")String id,
            RedirectAttributes rttr){

        int result1 = reviewService.penalizeReview(no);
        int result2 = reviewService.penalizeMember(id);

        String message = "";

        if(result1>0 && result2>0){
            message = "벌점 부과 및 리뷰 삭제에 성공하였습니다.";
        } else if(result1 >0){
            message = "리뷰 삭제에 성공하였습니다.\n벌점 부과에 실패하였습니다.";
        } else if(result2 >0){
            message = "벌점 부과에 성공하였습니다.\n리뷰 삭제에 실패하였습니다.";
        } else {
            message = "벌점 부과 및 리뷰 삭제에 실패하였습니다.";
        }

        rttr.addFlashAttribute("message",message);

        mv.setViewName("redirect:/review/declared");
        return mv;
    }

    @PostMapping("/search/delete")
    public ModelAndView deleteReview(ModelAndView mv,@RequestParam int no,RedirectAttributes rttr){
        int result = reviewService.deleteReview(no);
        String message = "";

        if(result>0){
            message = "리뷰 삭제를 성공하였습니다.";
        }else {
            message = "리뷰 삭제를 실패하였습니다.";
        }

        rttr.addFlashAttribute("message",message);
        mv.setViewName("redirect:/review/search");
        return mv;
    }






}
