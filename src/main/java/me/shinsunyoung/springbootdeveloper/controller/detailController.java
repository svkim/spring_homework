package me.shinsunyoung.springbootdeveloper.controller;

import me.shinsunyoung.springbootdeveloper.domain.Register;
import me.shinsunyoung.springbootdeveloper.domain.User;
import me.shinsunyoung.springbootdeveloper.repository.RegisterRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class detailController {
    private final RegisterRepository registerRepository;

    @GetMapping({"/mugunghwa/detail/{id}"})
    public String detail(@PathVariable Long id, Model model, Principal principal, @AuthenticationPrincipal
    User username) {
        if (principal != null) {
            model.addAttribute("nickname", username.getNickname());
            model.addAttribute("customer_id", username.getUserId());
        }
//        Register register = (Register)this.registerRepository.findById(id).orElse((Object)null);
        Register register = (Register)this.registerRepository.findById(id).orElse(null);
        model.addAttribute("register", register);

        return "goods/detail";
    }




    public detailController(final RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }
}
