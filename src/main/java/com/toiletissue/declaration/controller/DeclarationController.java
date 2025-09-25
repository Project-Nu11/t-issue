package com.toiletissue.declaration.controller;

import com.toiletissue.declaration.model.service.DeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/review")
public class DeclarationController {

    private final DeclarationService declarationService;

    @Autowired
    public DeclarationController(DeclarationService declarationService) {
        this.declarationService = declarationService;
    }
    // reviewController랑 동일함 신고된 리뷰 폼을 어디로 보내야할지..
//    @GetMapping("/declared")
//    public void reviewDeclared() {}

    @PostMapping("/declared")
    public String insertDeclaration(@RequestParam("reviewNo") int reviewNo,
                                    @RequestParam("memberId") String memberId,
                                    RedirectAttributes redirectAttributes) {
        if (declarationService.existsDeclaration(reviewNo, memberId)) {
            redirectAttributes.addFlashAttribute("msg", "이미 신고한 리뷰입니다.");
            return "redirect:/main";

        }
        declarationService.insertDeclaration(reviewNo, memberId);

        redirectAttributes.addFlashAttribute("msg", "신고가 완료되었습니다.");
        return "redirect:/main";
    }
}
