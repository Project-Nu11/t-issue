package com.toiletissue.member.controller;

import com.toiletissue.member.model.dto.MemberDTO;
import com.toiletissue.member.model.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/member")   // ★ 모든 경로를 /member 하위로 통일
public class MemberController {

    private final MemberService memberService;
    public MemberController(MemberService memberService) { this.memberService = memberService; }

    @GetMapping("/main")
    public String main() {
        return "main";   // → src/main/resources/templates/main.html
    }

    /* ---------- 로그인 ---------- */
    // 로그인 폼(GET) - 시큐리티 formLogin().loginPage("/member/login")와 매칭
    @GetMapping("/login")
    public String loginPage() {
        return "member/login";   // templates/member/login.html
    }

//    // 로그인 실패(GET) - 시큐리티 failureUrl("/member/fail?...")와 매칭
//    @GetMapping("/fail")
//    public ModelAndView loginFail(ModelAndView mv, @RequestParam(required = false) String message) {
//        mv.addObject("message", message);
//        mv.setViewName("member/fail");     // templates/member/fail.html
//        return mv;
//    }

    /* ---------- 회원가입 ---------- */
    // 회원가입 폼(GET)
    @GetMapping("/register")
    public String registerForm(Model model) {
        if (!model.containsAttribute("member")) {
            model.addAttribute("member", new MemberDTO());
        }
        return "member/register";          // templates/member/register.html
    }

    // 회원가입 처리(POST)
    @PostMapping("/register")
    public String register(@ModelAttribute("member") MemberDTO member) {
        memberService.register(member);
        return "redirect:/member/login";
    }

//    /* ---------- 마이페이지/목록/단건 ---------- */
//    @GetMapping("/mypage")
//    public String mypage() {
//        return "member/mypage";            // templates/member/mypage.html
//    }
//
//    @GetMapping("/list")
//    public String list(Model model) {
//        List<MemberDTO> members = memberService.findAll();
//        model.addAttribute("members", members);
//        return "member/list";              // templates/member/list.html
//    }
//
//    @PostMapping("/select")
//    public ModelAndView select(ModelAndView mv, @RequestParam String memberId) {
//        MemberDTO member = memberService.findById(memberId);
//        mv.addObject("member", member);
//        mv.setViewName("member/select");   // templates/member/select.html
//        return mv;
//    }
}




