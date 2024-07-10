package me.shinsunyoung.springbootdeveloper.service;

import me.shinsunyoung.springbootdeveloper.domain.Register;
import me.shinsunyoung.springbootdeveloper.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepository registerRepository;


    //이미지 등록
    private final String uploadDir = "./uploads";

//    public Register saveRegister(Register register, MultipartFile file) throws IOException {
//        if (!file.isEmpty()) {
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(uploadDir + File.separator + file.getOriginalFilename());
//            Files.write(path, bytes);
//            register.setPrdimg(file.getOriginalFilename());
//            register.setFilePath(path.toString());
//        }
//        return registerRepository.save(register);
//    }

    // 모든 상품을 조회하는 메서드
    public List<Register> getAllProducts() {
        return registerRepository.findAll();
    }

    // ID로 특정 상품을 조회하는 메서드
    public Optional<Register> getProductById(Long id) {
        return registerRepository.findById(id);
    }
}
