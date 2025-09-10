package com.toiletissue.request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/request")
public class RequestController {

    @GetMapping("/manager")
    public void requestManager(){

//        return "redirect:/request/manager";
    }
}
