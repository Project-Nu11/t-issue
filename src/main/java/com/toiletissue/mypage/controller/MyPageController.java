package com.toiletissue.mypage.controller;

import com.toiletissue.member.model.dto.MemberDTO;
import com.toiletissue.member.model.service.MemberService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MyPageController {

    private MemberService memberService;
    public MyPageController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/mypage")
    public String mypage(Authentication authentication, Model model) {
        String loginId = authentication.getName();
        MemberDTO memberDTO = memberService.findById(loginId);
        model.addAttribute("member", memberDTO);
        return "mypage/mypage";
    }
}
