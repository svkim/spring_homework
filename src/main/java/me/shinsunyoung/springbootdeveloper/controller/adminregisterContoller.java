package me.shinsunyoung.springbootdeveloper.controller;

import me.shinsunyoung.springbootdeveloper.dto.Addregister;
import me.shinsunyoung.springbootdeveloper.domain.Register;
import me.shinsunyoung.springbootdeveloper.repository.RegisterRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class adminregisterContoller {
    private static final Logger log = LoggerFactory.getLogger(adminregisterContoller.class);
    private final RegisterRepository registerRepository;

    @GetMapping({"/mugunghwa/adminregister"})
    public String detail() {
        return "admin/adminregister";
    }

    @PostMapping({"/ad"})
    public String register(Addregister form, @RequestParam("prdImage") MultipartFile file) {
        String fileName = this.saveImage(file);
        Register register = form.toEntity(fileName);
        Register saved = (Register)this.registerRepository.save(register);
        return "redirect:/mugunghwa/view";
    }

    @GetMapping({"/mugunghwa/tem"})
    public String detaill() {
        return "goods/temlist";
    }

    @GetMapping({"/mugunghwa/{id}"})
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);
//        Register registerEntity = (Register)this.registerRepository.findById(id).orElse((Object)null);
        Register registerEntity = (Register)this.registerRepository.findById(id).orElse(null);
        model.addAttribute("register", registerEntity);
        return "detail/show";
    }

    @GetMapping({"/mugunghwa/view"})
    public String index(Model model) {
        ArrayList<Register> registerEntityList = this.registerRepository.findAll();
        model.addAttribute("registerList", registerEntityList);
        return "goods/temlist";
    }

    private String saveImage(MultipartFile file) {
        if (file.isEmpty()) {
            return null;
        } else {
            try {
                File var10000 = new File(".");
                String uploadDir = var10000.getCanonicalPath() + "/src/main/resources/static/prd/";
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath, new LinkOption[0])) {
                    Files.createDirectories(uploadPath);
                }

                String fileName = file.getOriginalFilename();
                Path filePath = uploadPath.resolve(fileName);
                file.transferTo(filePath.toFile());
                return fileName;
            } catch (Exception var6) {
                var6.printStackTrace();
                return null;
            }
        }
    }

    public adminregisterContoller(final RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }
    //1. adminregisterController 에 추가//
// 상품 수정 페이지로 이동할 수 있는 메서드
    @GetMapping("/mugunghwa/edit/{id}")
    public String editRegister(@PathVariable Long id, Model model) {
        Register registerEntity = registerRepository.findById(id).orElse(null);
        model.addAttribute("register", registerEntity);
        return "admin/editregister";
    }

    // 수정 폼을 처리하는 메서드
    @PostMapping("/mugunghwa/update/{id}")
    public String updateRegister(@PathVariable Long id, Addregister form, @RequestParam("prdImage") MultipartFile file) {
        Register existingRegister = registerRepository.findById(id).orElse(null);
        if (existingRegister != null) {
            String fileName = existingRegister.getPrdImage();
            if (!file.isEmpty()) {
                fileName = saveImage(file);
            }
            existingRegister.setPrdName(form.getPrdName());
            existingRegister.setPrdModelnumber(form.getPrdModelnumber());
            existingRegister.setOriginalPrice(form.getOriginalPrice());
            existingRegister.setDiscountPrice(form.getDiscountPrice());
            existingRegister.setPrdManufacturer(form.getPrdManufacturer());
            existingRegister.setPrdDimensions(form.getPrdDimensions());
            existingRegister.setPrdRelease(form.getPrdRelease());
            existingRegister.setPrdStock(form.getPrdStock());
            existingRegister.setPrdMajorcategory(form.getPrdMajorcategory());
            existingRegister.setPrdSubcategory(form.getPrdSubcategory());
            existingRegister.setPrdImage(fileName);
            registerRepository.save(existingRegister);
        }
        return "redirect:/mugunghwa/view";
    }
    @DeleteMapping("/mugunghwa/delete/{id}")
    public String deleteRegister(@PathVariable Long id) {
        registerRepository.deleteById(id);
        return "redirect:/mugunghwa/view";
    }
}


