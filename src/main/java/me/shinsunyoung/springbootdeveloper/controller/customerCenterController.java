package me.shinsunyoung.springbootdeveloper.controller;

import me.shinsunyoung.springbootdeveloper.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class customerCenterController {

    //고객센터 메인-공지사항
    @GetMapping("/customerCenter/main")
    public String custC(Model model, Principal principal, @AuthenticationPrincipal User username) {

        if (principal != null) {
            model.addAttribute("nickname", username.getNickname());
        }
        return "customerCenter/customerCenter_Main_notice";
    }

    //고객센터 메인 - 공지사항1
    @GetMapping("/customerCenter/notice_1")
    public String custn1(Model model, Principal principal, @AuthenticationPrincipal User username) {

        if (principal != null) {
            model.addAttribute("nickname", username.getNickname());
        }

        return "customerCenter/customerCenter_Main_notice_1";
    }


    //고객센터 자주하는 질문과 그에 대한 답
    @GetMapping("/customerCenter/faq")
    public String custfaq(Model model, Principal principal, @AuthenticationPrincipal User username) {

        if (principal != null) {
            model.addAttribute("nickname", username.getNickname());
        }

        return "customerCenter/customerCenter_faq";
    }


    //고객센터 게시판 질문
    @GetMapping("/customerCenter/board")
    public String custboard(Model model, Principal principal, @AuthenticationPrincipal User username) {

        if (principal != null) {
            model.addAttribute("nickname", username.getNickname());
        }

        return "customerCenter/customerCenter_board";
    }
}
