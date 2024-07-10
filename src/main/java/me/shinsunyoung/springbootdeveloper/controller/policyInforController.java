package me.shinsunyoung.springbootdeveloper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class policyInforController {


    //회사 정책
    @GetMapping("/policy/policies")
    public String polici() {
        return "policyInfor/policies";
    }

    //개인정보보호
    @GetMapping("/policy/private")
    public String priva() {
        return "policyInfor/private";
    }
}
