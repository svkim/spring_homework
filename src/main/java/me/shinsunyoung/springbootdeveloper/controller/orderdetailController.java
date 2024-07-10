package me.shinsunyoung.springbootdeveloper.controller;

import me.shinsunyoung.springbootdeveloper.domain.OrdDetail;
import me.shinsunyoung.springbootdeveloper.dto.OrderDetailDto;
import me.shinsunyoung.springbootdeveloper.repository.OrdDetailRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class orderdetailController {
    private final OrdDetailRepository ordRepository;

    @PostMapping("/mugunghwa/orderdetail")
    public String ordtable(OrderDetailDto form){
        System.out.println("TEST486:" + form.toString());
        OrdDetail orddetail = form.toEntity();
//        orddetail.setPrddetailid(101L);
//        orddetail.setOrdid(1);
        OrdDetail saved = ordRepository.save(orddetail);
        return "main/home";
    }

    public orderdetailController(final OrdDetailRepository ordRepository) {
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
