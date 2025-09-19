//package com.toiletissue.mypage.controller;
//
//import com.toiletissue.member.model.dto.MemberDTO;
//import com.toiletissue.member.model.service.MemberService;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.security.Principal;
//
//@Controller
//@RequestMapping("/member")
//public class MyPageController {
//
//    private MemberService memberService;
//    public MyPageController(MemberService memberService) {
//        this.memberService = memberService;
//    }
//
//    // 마이페이지
//    @GetMapping("/mypage")
//    public String mypage() {
//        return "mypage/mypage";
//    }
//
//    // 개인정보 조회
//    @GetMapping("/select")
//    public String select(Principal principal, Model model) {
//        String memberId = principal.getName();
//        MemberDTO me = memberService.findById(memberId);
//        model.addAttribute("member", me);
//        return "mypage/select";           // templates/mypage/select.html
//    }
//
//    //비밀번호 변경
//    @GetMapping("/update")
//    public String updateForm() {
//        return "mypage/update";           // templates/mypage/update.html
//    }
//}
