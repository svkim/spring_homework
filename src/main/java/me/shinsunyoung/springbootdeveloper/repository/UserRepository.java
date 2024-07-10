package me.shinsunyoung.springbootdeveloper.repository;

import jakarta.transaction.Transactional;
import me.shinsunyoung.springbootdeveloper.domain.Board;
import me.shinsunyoung.springbootdeveloper.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);



    //전체회원 출력
    @Override
    ArrayList<User> findAll();

    //전체회원 출력시 페이징 처리하면서 사용자 검색
    //이메일검색
    Page<User> findByEmailContaining(String email, Pageable pageable);

//    //닉네임검색
//    Page<User> findByNicknameContaining(String nickname, Pageable pageable);
//
//    //연락처검색
//    Page<User> findByMemPhoneContaining(String memPhone, Pageable pageable);









    //이메일찾기
    Optional<User> findByNicknameAndMemPhone(String nickname, String memPhone);

    //비밀번호 재설정
    Optional<User> findByEmailAndMemPhone(String email, String memPhone);

//    //    //비밀번호 재설정
//    @Transactional
//    @Modifying
//    @Query("UPDATE User u SET u.password = ?2 WHERE u.nickname = ?1")
//    void updatePasswordByUsername(String nickname, String newPassword);


    //이메일 중복
    boolean existsByEmail(String email);

    //연락처 중복
    boolean existsByMemPhone(String memphone);

    //닉네임 중복
    boolean existsByNickname(String nickname);


    //댓글 달 때 닉네임으로 달기
    Optional<User> findByNickname(String nickname);


}

