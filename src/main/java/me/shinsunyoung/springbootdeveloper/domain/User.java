package me.shinsunyoung.springbootdeveloper.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;


//회원 관련
@Table(name = "customer_tb")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Data
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", updatable = false)
    private Long userId;

    @Column(name = "cst_password", nullable = false)
    private String password;

    @Column(name = "cst_name", nullable = false)
    private String memName;

    @Column(name = "cst_nickname", nullable = false, unique = true)
    private String nickname;

    @Column(name = "cst_ymd", nullable = false)
    private String birthDay;

    @Column(name = "cst_gender", nullable = false)
    private String gender;

    @Column(name = "cst_email", nullable = false, unique = true)
    private String email;

    @Column(name = "cst_phone", nullable = false, unique = true)
    private String memPhone;

    @Column(name = "cst_country", nullable = false)
    private String country;

    @Column(name = "cst_city", nullable = false)
    private String city;

    @Column(name = "cst_province", nullable = false)
    private String province;

    @Column(name = "cst_adress", nullable = false)
    private String memAdd;

    @Column(name = "cst_customscode")
    private String clearanceNum;

    @Column(name = "cst_zipcode")
    private String zipcode;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    //Timestamp는 java.sql
    @CreationTimestamp
    @Column(name = "user_date")
    private Timestamp userDate;


    @Builder
    public User(Long userId,  String password, String memName, String nickname, String birthDay, String gender, String email,
                String memPhone, String country, String city, String province, String memAdd, String clearanceNum,
                String zipcode, Role role, Timestamp userDate) {
        this.userId = userId;
        this.password = password;
        this.memName = memName;
        this.nickname = nickname;
        this.birthDay = birthDay;
        this.gender = gender;
        this.email = email;
        this.memPhone = memPhone;
        this.country = country;
        this.city = city;
        this.province = province;
        this.memAdd = memAdd;
        this.clearanceNum = clearanceNum;
        this.zipcode = zipcode;
        this.role = Role.USER;
        this.userDate = userDate;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    //비밀번호 재설정
    public void setPassword(String password) {
        this.password = password;
    }
}
