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
        return "/member/login";   // templates/mem
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
    public ModelAndView register(ModelAndView mv,@ModelAttribute("member") MemberDTO member) {
        memberService.register(member);
        mv.setViewName("redirect:/member/login");
        return mv;
    }

    //회원가입 - 약관동의
    @GetMapping("/register/consent")
    public String registerConsent() {
        return "member/register-consent";
    }

    // 약관동의 제출 (POST)
    @PostMapping("/register/consent")
    public String submitConsent(@RequestParam(value = "agreePrivacy", defaultValue = "false") boolean agreePrivacy,
                                @RequestParam(value = "agreeTerms",   defaultValue = "false") boolean agreeTerms,
                                org.springframework.web.servlet.mvc.support.RedirectAttributes rttr) {
        if (!(agreePrivacy && agreeTerms)) {
            rttr.addFlashAttribute("consentError", "필수 약관에 모두 동의해주세요.");
            return "redirect:/member/register/consent";
        }
        return "redirect:/member/register"; // 2단계: 회원정보 입력 폼으로 이동
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

    @GetMapping("/manager")
    public void manager(){}

}