package me.shinsunyoung.springbootdeveloper.controller;

import me.shinsunyoung.springbootdeveloper.domain.User;
import me.shinsunyoung.springbootdeveloper.repository.RegisterRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class categoryController {
    private final RegisterRepository registerRepository;

    @GetMapping({"/mugunghwa/category"})
    public String category(@RequestParam(value = "major",required = false) String major, @RequestParam(value = "sub",required = false) String sub, Model model, Principal principal, @AuthenticationPrincipal User username)  {
        Object products;
        if (major != null && sub != null) {
            products = this.registerRepository.findByPrdMajorcategoryAndPrdSubcategory(major, sub);
        } else {
            products = this.registerRepository.findAll();
        }

        model.addAttribute("products", products);

             if (principal != null) {
                model.addAttribute("nickname", username.getNickname());
            }

        return "goods/category";
    }

    @GetMapping({"/mugunghwa/category_product"})
    public String category_product(@RequestParam(value = "prdName",required = false) String prdName, Model model, Principal principal, @AuthenticationPrincipal User username) {
        Object products = null;
        if (prdName != null) {
            products = this.registerRepository.findByPrdName(prdName);
        }

        model.addAttribute("products", products);

        if (principal != null) {
            model.addAttribute("nickname", username.getNickname());
        }
        return "goods/category";
    }

    public categoryController(final RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }
}
