package me.shinsunyoung.springbootdeveloper.controller;

import me.shinsunyoung.springbootdeveloper.domain.Register;
import me.shinsunyoung.springbootdeveloper.domain.User;
import me.shinsunyoung.springbootdeveloper.repository.RegisterRepository;
import me.shinsunyoung.springbootdeveloper.repository.UserRepository;
import me.shinsunyoung.springbootdeveloper.service.UserDetailService;
import me.shinsunyoung.springbootdeveloper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class mainController {
    private final RegisterRepository registerRepository;

    @Autowired
    private UserService userService;

    //회원이 로그인 후 첫페이지
//    @GetMapping("/main/home")
//    public String mainhome(Model model, Principal principal) {
//        String email = principal.getName();
//        User user = userService.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
//        model.addAttribute("nickname", user.getNickname());
//        return "main/home";
//    }

    @GetMapping("/main/home")
    public String index(Model model, Principal principal, @AuthenticationPrincipal User username) {
        ArrayList<Register> products = this.registerRepository.findAll();
        ArrayList<Register> populars = new ArrayList<>();
        if (products.size() > 0) {
            for (int i = products.size() - 1; i >= 0; i--) {
                populars.add(products.get(i));
            }
        }
        model.addAttribute("populars", populars);

        if (principal != null) {
            model.addAttribute("nickname", username.getNickname());
        }
        return "main/home";
    }
//    //비회원이 보는 메인페이지
//    @GetMapping("/main/main1")
//    public String main1() {
//        return "main/main1";
//    }

    public mainController(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

}
