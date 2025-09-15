package com.toiletissue.notice.controller;

import com.toiletissue.notice.model.dto.NoticeDTO;
import com.toiletissue.notice.model.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/manager")
    public String noticeManager(Model model){

        List<NoticeDTO> noticeList = noticeService.selectAllNotice();


        model.addAttribute("noticeList",noticeList);

        return "notice/manager";
    }

//    @GetMapping("/insert")
    ////    public void insertNotice(){}
    ////
    ////    @GetMapping("/delete")
    ////    public void deleteNotice(){}

    /*@PostMapping("/insert")
    public ModelAndView inertNotice(ModelAndView mv, @ModelAttribute NoticeDTO noticeDTO){

        int result = noticeService.insertNotice(noticeDTO);

//        String message = "";

        if(result > 0 ){
//            message = "공지사항 등록에 성공하였습니다.";
            mv.setViewName("/notice/manager");
        } else {
//            message = "공지사항 등록에 실패하였습니다.";
            mv.setViewName("/notice/manager");
        }

//        mv.addObject("message",message);

        return mv;
    }

    @PostMapping("/delete")
    public ModelAndView deleteNotice(ModelAndView mv, @ModelAttribute NoticeDTO noticeDTO){

        int result =  noticeService.deleteNotice(noticeDTO);

        if(result>0){
            mv.setViewName("/notice/manager");
        } else{
            mv.setViewName("/notice/delete");
        }

        return mv;
    }*/

    @PostMapping("/manager/insert")
    public ModelAndView insertNotice(ModelAndView mv, @ModelAttribute NoticeDTO noticeDTO){

        System.out.println(noticeDTO);
        noticeService.insertNotice(noticeDTO);
        System.out.println(noticeDTO);
        mv.setViewName("redirect:/notice/manager");

        return mv;
    }

    @PostMapping("/manager/delete")
    public ModelAndView deleteNotice(ModelAndView mv, @RequestParam int no){
        System.out.println(no);
        noticeService.deleteNotice(no);

        mv.setViewName("redirect:/notice/manager");

        return mv;
    }

    @PostMapping("/manager/update")
    public ModelAndView updateNotice(ModelAndView mv,@ModelAttribute NoticeDTO noticeDTO){
        System.out.println(noticeDTO);
        noticeService.updateNotice(noticeDTO);
        mv.setViewName("redirect:/notice/manager");

        return mv;
    }

}
