package com.toiletissue.manager.controller;

import com.toiletissue.manager.model.dto.ManagerDTO;
import com.toiletissue.manager.model.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/login")
    public void login(){}

    @GetMapping("/main")
    public void main(){}

    @PostMapping("/login")
    public String login(ManagerDTO managerDTO){

        return "redirect:/manager/main";
    }
}
