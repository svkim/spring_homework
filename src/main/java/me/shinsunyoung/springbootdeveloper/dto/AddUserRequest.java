package me.shinsunyoung.springbootdeveloper.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import me.shinsunyoung.springbootdeveloper.domain.Role;
import me.shinsunyoung.springbootdeveloper.domain.User;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDateTime;

//회원 관린 DTO
@Setter
@Getter
public class AddUserRequest {
    private Long userId;


    private String memId;


    private String password;


    private String memName;

    @NotEmpty(message = "닉네임을 입력해주세요.")
    private String nickname;


    private String birthDay;


    private String gender;

    @NotEmpty(message = "이메일을 입력해주세요.")
    @Email(message = "유효한 이메일 주소를 입력해주세요.")
    private String email;

    @NotEmpty(message = "휴대폰번호를 입력해주세요.")
    private String memPhone;


    private String country;


    private String city;


    private String province;


    private String memAdd;


    private String clearanceNum;

    private String zipcode;

    private Role role;

    private Timestamp userDate;


}


