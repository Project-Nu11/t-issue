//package com.toiletissue.member.controller;
//
//
//import com.toiletissue.member.model.dto.MemberSignupDTO;
//import com.toiletissue.member.model.service.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//@Controller
//@RequestMapping("/member")
//public class MemberController {
//
//    @Autowired
//    private MemberService memberService;
//
//    @GetMapping("/manager")
//    public void reviewManager(){}
//
//    @GetMapping("/signup")
//    public void signup() {
//    }
//
//    @PostMapping("/signup")
//    public String signup(MemberSignupDTO memberSignupDTO, RedirectAttributes rttr) {
//
//        int result = memberService.insert(memberSignupDTO);
//
//        if (result > 0) {
//            rttr.addFlashAttribute("message", "회원가입이 정상적으로 완료되었습니다.");
////            return "redirect:/auth/login";// 로그인 페이지 리다이렉트
//            return "main";
//
//        } else {
//            rttr.addFlashAttribute("message", "회원가입에 실패하였습니다.");
//            return "redirect:/member/signup";       // 다시 회원가입 화면
//        }
//    }
//
//
//    @GetMapping("/check-id")
//    @ResponseBody
//    public String checkId(@RequestParam String memberId) {
//        return memberService.exists(memberId) ? "이미 존재하는 아이디입니다." : "사용 가능한 아이디입니다.";  //프론트
//    }
//}
//
