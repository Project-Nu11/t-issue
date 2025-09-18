package com.toiletissue.request.controller;

import com.toiletissue.request.model.dto.RequestDTO;
import com.toiletissue.request.model.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/manager")
    public String requestManager(
            Model model,
            @RequestParam(name="status",defaultValue = "%%") String value,
            @RequestParam(value = "page", defaultValue = "1") int page){

        List<RequestDTO> requestList = requestService.selectAllRequest(value);

        for(RequestDTO req : requestList){
            System.out.println(req);
        }
        System.out.println(value);

        int totalRequests = requestList.size(); // 총 문의 수
        int pageSize = 10; // 한 페이지당 문의 수
        int totalPages = (int)(Math.ceil((double)totalRequests/pageSize)); // 총 페이지 수

        if(page <= 0){
            page = 1;
        } else if(page > totalPages){
            page = totalPages;
        }



        int start = (page-1)*pageSize; //페이지 시작 문의 번호
        int end = Math.min(start+pageSize,totalRequests); // 페이지 끝 문의 번호

        List<RequestDTO> pagedRequests = new ArrayList<>();
        if(!requestList.isEmpty()){
            pagedRequests = requestList.subList(start,end);
        }

        System.out.println("page = " + page);
        System.out.println("totalPages = " + totalPages);
        System.out.println("end = " + end);
        System.out.println("start = " + start);
        for(RequestDTO req : pagedRequests){
            System.out.println(req);
        }
        int buttonCount = 10; // 한 번에 보여질 페이지 버튼 수
        int startPage = ((page - 1) / buttonCount) * buttonCount + 1;
        int endPage = Math.min(startPage + buttonCount - 1, totalPages);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);




        model.addAttribute("requestList",pagedRequests);
        model.addAttribute("value",value);
        model.addAttribute("page",page);
        model.addAttribute("totalPages",totalPages);



        return "/request/manager";
    }

//    @GetMapping("/manager/select")
//    public String requestSelect(Model model,@RequestParam(value = "value") String value){
//        List<RequestDTO> requestList = requestService.selectRequestsByCriteria();
//        for(RequestDTO req : requestList){
//            System.out.println(req);
//        }
//        System.out.println(value);
//        model.addAttribute("requestList",requestList);
//        model.addAttribute("value",value);
//
//        return "/request/manager";
//    }

    @PostMapping("/manager/reject")
    public ModelAndView requestReject(ModelAndView mv, @ModelAttribute RequestDTO requestDTO){
        requestService.requestReject(requestDTO);
        mv.setViewName("redirect:/request/manager");
        return mv;

    }

    @PostMapping("/manager/answer")
    public ModelAndView requestAnswer(ModelAndView mv, @ModelAttribute RequestDTO requestDTO){
        System.out.println(requestDTO);
        requestService.requestAnswer(requestDTO);
        mv.setViewName("redirect:/request/manager");

        return mv;
    }

//    @GetMapping("/manager/select")
//    public ModelAndView requestSelect(ModelAndView mv, @RequestParam(name="value", defaultValue = "latest") String value){
//
//
//    }

    /*------------------------------------사용자 문의 기능------------------------------------------*/

    @GetMapping("/member")
    public String requestMember(
            Model model,
            @RequestParam(name="status",defaultValue = "%%") String value,
            @RequestParam(value = "page", defaultValue = "1") int page){

        List<RequestDTO> requestList = requestService.selectAllRequest(value);

        for(RequestDTO req : requestList){
            System.out.println(req);
        }
        System.out.println(value);

        int totalRequests = requestList.size(); // 총 문의 수
        int pageSize = 10; // 한 페이지당 문의 수
        int totalPages = (int)(Math.ceil((double)totalRequests/pageSize)); // 총 페이지 수

        if(page <= 0){
            page = 1;
        } else if(page > totalPages){
            page = totalPages;
        }

        int start = (page-1)*pageSize; //페이지 시작 문의 번호
        int end = Math.min(start+pageSize,totalRequests); // 페이지 끝 문의 번호
        List<RequestDTO> pagedRequests = new ArrayList<>();
        if(!requestList.isEmpty()){
            pagedRequests = requestList.subList(start,end);
        }

        System.out.println("page = " + page);
        System.out.println("totalPages = " + totalPages);
        System.out.println("end = " + end);
        System.out.println("start = " + start);
        for(RequestDTO req : pagedRequests){
            System.out.println(req);
        }
        int buttonCount = 10; // 한 번에 보여질 페이지 버튼 수
        int startPage = ((page - 1) / buttonCount) * buttonCount + 1;
        int endPage = Math.min(startPage + buttonCount - 1, totalPages);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);




        model.addAttribute("requestList",pagedRequests);
        model.addAttribute("value",value);
        model.addAttribute("page",page);
        model.addAttribute("totalPages",totalPages);



        return "/request/member";
    }

    @PostMapping("/member/insert")
    public ModelAndView requestInsert(ModelAndView mv,@ModelAttribute RequestDTO requestDTO){
        requestService.requestInsert(requestDTO);
        mv.setViewName("redirect:/request/member");
        return mv;
    }
    /*-----------------FAQ------------------------*/
    @GetMapping("/faq")
    public void faq(){}


}
