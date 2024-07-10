package me.shinsunyoung.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.Board;
import me.shinsunyoung.springbootdeveloper.domain.User;
import me.shinsunyoung.springbootdeveloper.dto.AddUserRequest;
import me.shinsunyoung.springbootdeveloper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;



//    -----------------------------------------------------------
    //비밀번호 변경
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean resetPassword(String email, String memPhone, String newPassword) {
        Optional<User> userOpt = userRepository.findByEmailAndMemPhone(email, memPhone);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            return true;
        }

        return false;
    }

//  ----------------------------------------------------

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .memName(dto.getMemName())
                .nickname(dto.getNickname())
                .birthDay(dto.getBirthDay())
                .gender(dto.getGender())
                .memPhone(dto.getMemPhone())
                .country(dto.getCountry())
                .city(dto.getCity())
                .province(dto.getProvince())
                .zipcode(dto.getZipcode())
                .memAdd(dto.getMemAdd())
                .clearanceNum(dto.getClearanceNum())
                .build()).getUserId();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }




    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    //이메일 중복
    public boolean isEmailAvailable(String email) {
        return !userRepository.existsByEmail(email);
    }

    //폰번호 중복
    public boolean isMemPhoneAvailable(String memphone) { return !userRepository.existsByMemPhone(memphone);
    }

    //닉네임 중복
    public boolean isNicknameAvailable(String nickname) {
        return !userRepository.existsByNickname(nickname);
    }


//    //비밀번호 변경
//    public boolean verifyUser(String nickname, String email) {
//        return userRepository.findByNicknameAndMemPhone(nickname, email).isPresent();
//    }
//
//    //비밀번호 변경
//    public boolean resetPassword(String email, String newPassword) {
//        userRepository.updatePasswordByUsername(email, newPassword);
//
//        return false;
//    }
//
//        //비밀번호 변경
//    public void updatePassword(String email, String newPassword) {
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        user.setPassword(passwordEncoder.encode(newPassword));
//        userRepository.save(user);
//
//        //String encodedPassword = passwordEncoder.encode(newPassword);
//        //userRepository.updatePasswordByUsername(email, newPassword);
//
//    }

//UserApiController에서 중복확인후 저장하기에 불필요, 있으면 자료가 두번 디비에 저장하려고 하기에 에러발생
//    public User createUser(User user) {
//        return userRepository.save(user);
//    }




    //전체 회원 리스트
    //List<user>값이 페이징 설정 해주면서 page<user>로 넘김
    public Page<User> userList(Pageable pageable) {
        return userRepository.findAll(pageable);

    }




    //페이징 처리시 사용자 검색 기능(이메일 검색)
    public Page<User> userSearchList1(String searchKeyword1, Pageable pageable) {
        return userRepository.findByEmailContaining(searchKeyword1, pageable);
    }




    //개별 회원 정보 보기
    public User iduserView(Long userId) {
        return userRepository.findById(userId).get();
//                .orElseThrow(() -> new RuntimeException("없는 id 입니다."));
    }


    //회원 강퇴
    public void userDelete(Long userId) {
        userRepository.deleteById(userId);
    }


    //회원이 자신의 정보 보기
    public User userView(Long userId) {
        return userRepository.findById(userId).get();
//                .orElseThrow(() -> new RuntimeException("업는 id 입니다."));

    }

    //회원이 자신의 정보 수정 입력쓰기
    public void save(User user) {
        userRepository.save(user);
    }






}
