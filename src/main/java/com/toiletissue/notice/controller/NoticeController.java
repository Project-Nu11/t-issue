package com.toiletissue.notice.controller;

import com.toiletissue.notice.model.dto.NoticeDTO;
import com.toiletissue.notice.model.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/insert")
    public void insertNotice(){}

    @GetMapping("/delete")
    public void deleteNotice(){}

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

    @PostMapping("/manager")
    public ModelAndView insertNotice(ModelAndView mv, @ModelAttribute NoticeDTO noticeDTO){

        noticeService.insertNotice(noticeDTO);

        mv.setViewName("redirect:/notice/manager");

        return mv;
    }

}
