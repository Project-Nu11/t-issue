package com.toiletissue.member.controller;

import com.toiletissue.member.model.dto.MemberDTO;
import com.toiletissue.member.model.service.MemberService;
import com.toiletissue.review.model.dto.ReviewDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member")   // ★ 모든 경로를 /member 하위
public class MemberController {

    private final MemberService memberService;
    public MemberController(MemberService memberService) { this.memberService = memberService; }

    @GetMapping("/main")
    public String main() {
        return "main";   // → templates/main.html
    }

    /* ---------- 로그인 ---------- */
    @GetMapping("/login")
    public String loginPage() {
        return "member/login";   // templates/member/login.html
    }

    /* ---------- 회원가입 ---------- */
    // 회원가입 폼(GET)
    @GetMapping("/register")
    public String registerForm(Model model) {
        if (!model.containsAttribute("member")) {
            model.addAttribute("member", new MemberDTO());
        }
        return "member/register";          // templates/member/register.html
    }

    // 아이디 중복확인: GET /member/register/check-id?memberId=xxx
    @GetMapping("/register/check-id")
    @ResponseBody
    public Map<String, Object> checkId(@RequestParam String memberId) {
        boolean available = !memberService.existsById(memberId);
        Map<String, Object> body = new HashMap<>();
        body.put("available", available);
        return body;
    }

    // 회원가입 처리(POST) - 서버 중복/비번일치 방어 포함
    @PostMapping("/register")
    public ModelAndView register(ModelAndView mv,
                                 @ModelAttribute("member") MemberDTO member,
                                 @RequestParam("confirmPwd") String confirmPwd,
                                 RedirectAttributes rttr) {

        if (memberService.existsById(member.getMemberId())) {
            rttr.addFlashAttribute("error", "이미 사용 중인 아이디입니다.");
            rttr.addFlashAttribute("member", member);
            mv.setViewName("redirect:/member/register?error=duplicateId");
            return mv;
        }
        if (member.getMemberPwd() == null || !member.getMemberPwd().equals(confirmPwd)) {
            rttr.addFlashAttribute("error", "비밀번호가 일치하지 않습니다.");
            rttr.addFlashAttribute("member", member);
            mv.setViewName("redirect:/member/register?error=pwdMismatch");
            return mv;
        }

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
                                RedirectAttributes rttr) {
        if (!(agreePrivacy && agreeTerms)) {
            rttr.addFlashAttribute("consentError", "필수 약관에 모두 동의해주세요.");
            return "redirect:/member/register/consent";
        }
        return "redirect:/member/register"; // 2단계: 회원정보 입력 폼으로 이동
    }

    // 아아디, 비밀번호 찾기
    @GetMapping("/find")
    public String findPage() {
        return "member/find";
    }

    @PostMapping("/find/id")
    @ResponseBody
    public ResponseEntity<?> findId(@RequestParam String memberName,
                                    @RequestParam String email) {
        String foundId = memberService.findMemberIdByNameAndEmail(memberName, email);
        Map<String,Object> result = new HashMap<>();
        result.put("success", foundId != null);
        result.put("foundId", foundId);
        return ResponseEntity.ok(result);
    }
    @PostMapping("/find/pwd")
    @ResponseBody
    public ResponseEntity<?> resetPwd(@RequestParam String memberId,
                                      @RequestParam String memberName,
                                      @RequestParam String email) {
        String tempPwd = memberService.resetPasswordWithTemp(memberId, memberName, email);
        Map<String,Object> result = new HashMap<>();
        result.put("success", tempPwd != null);
        result.put("tempPwd", tempPwd);
        return ResponseEntity.ok(result);
    }

    // MemberController 안에 추가
//    @GetMapping("/mypage")
//    public String mypage(org.springframework.security.core.Authentication authentication,
//                         org.springframework.ui.Model model) {
//        String loginId = authentication.getName();                 // 로그인한 아이디
//        model.addAttribute("loginId", loginId);
//
//        // 상세 정보
//        com.toiletissue.member.model.dto.MemberDTO me = memberService.findById(loginId);
//        model.addAttribute("member", me);
//
//        return "mypage/mypage";   //templates/mypage/mypage.html
//    }

    @GetMapping("/select")
    public void select() {}

    /*--------------------------------- 관리자 memberController------------------------------------*/


    @GetMapping("/manager")
    public void manager(Model model
                        ,@RequestParam(value = "page",defaultValue = "1") int page
    ){

        List<MemberDTO> memberList = memberService.selectAllMember();


        int totalMember = memberList.size();
        int pageSize = 10;
        int totalPage = (int)(Math.ceil((double)totalMember/pageSize));

        if(page<0){
            page = 1;
        } else if(page >totalPage){
            page = totalPage;
        }

        int start = (page-1)*pageSize;
        int end = Math.min(start+pageSize,totalMember);
        System.out.println("start = " + start);
        System.out.println("end = " + end);

        List<MemberDTO> pagedMembers = new ArrayList<>();
        if(!memberList.isEmpty()){
            pagedMembers = memberList.subList(start,end);
        }
        for(MemberDTO mem : pagedMembers){
            System.out.println(mem);
        }

        int buttonCount = 10;
        int startPage = ((page-1)/buttonCount)*buttonCount+1;
        int endPage = Math.min(startPage+buttonCount,totalPage);

        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("page",page);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("memberList",pagedMembers);
    }

    @PostMapping("/restrict")
    public ModelAndView restrictMember(ModelAndView mv,@RequestParam String id,RedirectAttributes rttr){

        int result = memberService.restrictMember(id);
        
        MemberDTO member = memberService.findById(id);
        System.out.println("member = " + member);
        
        String memberId = member.getMemberId();
        System.out.println("memberId = " + memberId);
        
        int penalty = member.getPenalty();
        System.out.println("penalty = " + penalty);
        
        
        String message = "";
        if(result >0){
            message = "해당 회원을 영구 제한 조치하였습니다.";
        } else{
            message = "영구 제한 조치를 실패하였습니다.\n해당 회원의 벌점은 "+penalty+"점 입니다.\n(영구 제한은 벌점 10점 부터 가능합니다.)";
        }

        rttr.addFlashAttribute("message",message);
        mv.setViewName("redirect:/member/manager");

        return mv;
    }
}

















