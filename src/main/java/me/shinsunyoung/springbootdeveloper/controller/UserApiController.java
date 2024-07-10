package me.shinsunyoung.springbootdeveloper.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.User;
import me.shinsunyoung.springbootdeveloper.dto.AddUserRequest;
import me.shinsunyoung.springbootdeveloper.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final UserService userService;

    //회원가입 페이지 호출
    @GetMapping("/join")
    public String signup() {
        return "signup";
    }


    //회원가입 진행
    //이메일, 아이디, 닉네임, 연락처 중복 확인
    @Transactional
    @PostMapping("/user")
//    public String signup(, @Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model ) {
    public String signup(@Valid @ModelAttribute("user") AddUserRequest request, BindingResult bindingResult, Model model ) {



//        if (bindingResult.hasErrors()) {
//            //회원가입 중 에러가 발생한 경우 입력한 정보를 모델에 추가하여 뷰로 전달
////            model.addAttribute("user", user);
//            return "signup";
//        }


        if (!userService.isEmailAvailable(request.getEmail())) {
            model.addAttribute("emailError", "이메일이 이미 있습니다.");
            return "signup";
        }

        if (!userService.isMemPhoneAvailable(request.getMemPhone())) {
            model.addAttribute("phoneNumberError", "폰번호가 이미 있습니다.");
            return "signup";
        }

        if (!userService.isNicknameAvailable(request.getNickname())) {
            model.addAttribute("nicknameError", "닉네임이 이미 있습니다.");
            return "signup";
        }

        userService.save(request);

        return "redirect:login";
    }


    //로그아웃 호출
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "main/main1";
    }




}
