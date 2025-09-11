package com.toiletissue.member.controller;


import com.toiletissue.member.model.dto.MemberSignupDTO;
import com.toiletissue.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/manager")
    public void reviewManager(){}

    @GetMapping("/signup")
    public void signup() {
    }

    @PostMapping("/signup")
    public ModelAndView signup(ModelAndView mv, @ModelAttribute MemberSignupDTO memberSignupDTO) {

        int result = memberService.insert(memberSignupDTO);

        String message = "";

        if (result > 0) {
            message = "회원가입이 정상적으로 완료되었습니다.";

        }

        return mv;
    }
}
