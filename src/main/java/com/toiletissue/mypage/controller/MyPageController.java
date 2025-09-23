package com.toiletissue.mypage.controller;

import com.toiletissue.member.model.dto.MemberDTO;
import com.toiletissue.mypage.model.service.MyPageService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

    private final MyPageService myPageService;

    public MyPageController(MyPageService myPageService) {
        this.myPageService = myPageService;
    }

    // /mypage
    //"mypage"와 "/mypage/** " 모두를 처리 / 있는거 없는거 둘다 처리....
    @GetMapping({"", "/"})
    public String mypage() {
        return "/mypage/mypage";
    }

    // /mypage/select
    @GetMapping("/select")
    public String select(Principal principal, Model model) {
        if (principal == null) return "redirect:/member/login";
        MemberDTO member = myPageService.getProfile(principal.getName());
        if (member == null) return "redirect:/member/login?code=NOT_FOUND";
        model.addAttribute("member", member);
        return "mypage/select";
    }

    @GetMapping("/update")
    public String updateGet() {
        return "redirect:/mypage/select";
    }

    // /mypage/update (POST: 비밀번호 변경)
    @PostMapping("/update")
    public String changePassword(Principal principal,
                                 @RequestParam String currentPwd,
                                 @RequestParam String newPwd,
                                 @RequestParam String confirmPwd,
                                 RedirectAttributes rttr,
                                 HttpServletRequest req,
                                 HttpServletResponse res) {


        if (principal == null) return "redirect:/member/login";

        try {
            myPageService.changePwd(principal.getName(), currentPwd, newPwd, confirmPwd);

            //  변경 직후 로그아웃(세션 무효화 + 쿠키 삭제)
            new SecurityContextLogoutHandler().logout(req, res, null);

            return "redirect:/member/login?code=PWD_CHANGED";
        } catch (IllegalArgumentException e) {
            rttr.addFlashAttribute("error", e.getMessage());
            return "redirect:/mypage/select";
        }
    }

    /* 탈퇴 폼 */
    @GetMapping("/delete")
    public String deleteForm(Principal principal, Model model) {
        if (principal == null) return "redirect:/member/login";
        model.addAttribute("memberId", principal.getName());
        return "mypage/delete";   // templates/mypage/delete.html
    }

    /* 탈퇴 처리 */
    @PostMapping("/delete")
    public String delete(Principal principal,
                         @RequestParam String currentPwd,
                         RedirectAttributes rttr,
                         HttpServletRequest req,
                         HttpServletResponse res) {
        if (principal == null) return "redirect:/member/login";
        try {
            myPageService.withdraw(principal.getName(), currentPwd);

            // 성공 시 즉시 로그아웃(세션/쿠키 정리)
            new SecurityContextLogoutHandler().logout(req, res, null);

            return "redirect:/member/login?code=WITHDRAWN";

        } catch (IllegalArgumentException | IllegalStateException e) {

            rttr.addFlashAttribute("error", e.getMessage());
            return "redirect:/mypage/delete";
        }

    }
}
