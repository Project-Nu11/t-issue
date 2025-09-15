package com.toiletissue.auth.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

@RequestMapping(value = {"/","/main"})
    public void main() {
    }

    @Value("${api.kakao.key}")
    private String kakaoKey;

    @GetMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("kakaoKey", kakaoKey);
        return "main";
    }
}
