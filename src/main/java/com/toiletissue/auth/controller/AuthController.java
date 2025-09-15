package com.toiletissue.auth.controller;

import com.toiletissue.auth.model.service.AuthService;
import com.toiletissue.member.model.dto.MemberLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public void login(){}

    @PostMapping("/login")
    public ModelAndView login(ModelAndView mv, MemberLoginDTO memberLoginDTO){

        authService.login(memberLoginDTO);

        mv.setViewName("/main");

        return mv;
    }


}
