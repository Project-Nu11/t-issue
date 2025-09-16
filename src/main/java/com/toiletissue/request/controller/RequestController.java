package com.toiletissue.request.controller;

import com.toiletissue.request.model.dto.RequestDTO;
import com.toiletissue.request.model.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/manager")
    public String requestManager(
            Model model,
            @RequestParam(name="status",defaultValue = "%%") String value){

        List<RequestDTO> requestList = requestService.selectAllRequest(value);

        for(RequestDTO req : requestList){
            System.out.println(req);
        }
        System.out.println(value);

        model.addAttribute("requestList",requestList);
        model.addAttribute("value",value);


        return "/request/manager";
    }

    @GetMapping("/manager/select")
    public String requestSelect(Model model,@RequestParam(value = "value") String value){
        List<RequestDTO> requestList = requestService.selectRequestsByCriteria();
        for(RequestDTO req : requestList){
            System.out.println(req);
        }
        System.out.println(value);
        model.addAttribute("requestList",requestList);
        model.addAttribute("value",value);

        return "/request/manager";
    }

    @PostMapping("/manager/reject")
    public ModelAndView requestReject(ModelAndView mv, @ModelAttribute RequestDTO requestDTO){
        requestService.requestReject(requestDTO);
//        mv.setViewName("redirect:/request/manager");
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


}
