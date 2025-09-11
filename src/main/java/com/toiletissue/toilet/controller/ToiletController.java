package com.toiletissue.toilet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/toilet")
public class ToiletController {

    @GetMapping("/manager")
    public void toiletManager(){}

    @GetMapping("/subway")
    public String stationToiletList(Model model) {

        String toiletList = "";

        model.addAttribute("toiletList", toiletList);

        return "toilet/subway";
    }

    @GetMapping("/subwayName")
    public void stationNameToiletList() {}

    @GetMapping("/toiletName")
    public void toiletDetails() {}



}
