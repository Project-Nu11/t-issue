package com.toiletissue.penalty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/penalty")
public class PenaltyController {

    @GetMapping("/manager")
    public void penaltyManager(){}
}
