package me.shinsunyoung.springbootdeveloper.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import me.shinsunyoung.springbootdeveloper.domain.Order;
import me.shinsunyoung.springbootdeveloper.domain.Register;
import me.shinsunyoung.springbootdeveloper.domain.User;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderDto {

    private Long orderid;

    private Long registerProductId;

    private Long userCustomerId;

    private String nickname;

    private String memPhone;

    private String zipcode;

    private String country;

    private String province;

    private String city;

    private String memAdd;

    private Timestamp odrdate;

    private int odrtotalprice;

    private int odrmethod;

    private int odrcount;

    private String odrcomment;

    public OrderDto(Long orderid, Long registerProductId, Long userCustomerId, String nickname, String memPhone, String zipcode, String country, String province, String city, String memAdd, Timestamp odrdate, int odrtotalprice, int odrmethod, int odrcount, String odrcomment) {
        this.orderid = orderid;
        this.registerProductId = registerProductId;
        this.userCustomerId = userCustomerId;
        this.nickname = nickname;
        this.memPhone = memPhone;
        this.zipcode = zipcode;
        this.country = country;
        this.province = province;
        this.city = city;
        this.memAdd = memAdd;
        this.odrdate = odrdate;
        this.odrtotalprice = odrtotalprice;
        this.odrmethod = odrmethod;
        this.odrcount = odrcount;
        this.odrcomment = odrcomment;
    }

    public Order toEntity(User user, Register register) {
        return new Order(null, user, register, nickname, memPhone, zipcode, country, province, city, memAdd,
                odrdate, odrtotalprice, odrmethod, odrcount, odrcomment);
    }

//    public Order toEntity() {
//        return new Order(null, odrdate, odrtotalprice, odrmethod, odrcount, odrcomment);
//    }
}
