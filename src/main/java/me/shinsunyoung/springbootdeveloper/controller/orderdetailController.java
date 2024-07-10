package me.shinsunyoung.springbootdeveloper.controller;

import me.shinsunyoung.springbootdeveloper.domain.Order;
import me.shinsunyoung.springbootdeveloper.domain.Register;
import me.shinsunyoung.springbootdeveloper.domain.User;
import me.shinsunyoung.springbootdeveloper.dto.OrderDto;
import me.shinsunyoung.springbootdeveloper.repository.OrdRepository;
import me.shinsunyoung.springbootdeveloper.repository.RegisterRepository;
import me.shinsunyoung.springbootdeveloper.repository.UserRepository;
import me.shinsunyoung.springbootdeveloper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class orderdetailController {
    @Autowired
    private RegisterRepository registerRepository;
    @Autowired
    private UserRepository userRepository;

    private final OrdRepository ordRepository;

    @PostMapping("/mugunghwa/orderdetail")
    public String ordtable(OrderDto form){
        System.out.println("TEST486:" + form.toString());
        Register register = (Register) registerRepository.findById(form.getRegisterProductId()).orElse(null);
        User user = (User) userRepository.findById(form.getUserCustomerId()).orElse(null);

        Order order = form.toEntity(user, register);
        Order saved = ordRepository.save(order);
        return "main/home";
    }

    public orderdetailController(final OrdRepository ordRepository) {
        this.ordRepository = ordRepository;
    }
}

//@PostMapping({"/ad"})
//public String register(Addregister form, @RequestParam("prdImage") MultipartFile file) {
//    String fileName = this.saveImage(file);
//    Register register = form.toEntity(fileName);
//    Register saved = (Register)this.registerRepository.save(register);
//    return "redirect:/mugunghwa/view";
//}
