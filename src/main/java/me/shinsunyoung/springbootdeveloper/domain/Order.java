package me.shinsunyoung.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.Data;
import me.shinsunyoung.springbootdeveloper.dto.OrderDto;
import org.hibernate.annotations.CreationTimestamp;

import java.security.Timestamp;

@Entity
@Data
@Table(name = "order_tb")
public class Order {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "order_id"
    )
    private Long orderid;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Register register;

    @Column(
            name = "odr_nickname"
    )

    private String nickname;

    @Column(
            name = "odr_phone"
    )
    private String memPhone;

    @Column(
            name = "odr_zipcode"
    )
    private String zipcode;

    @Column(
            name = "odr_country"
    )
    private String country;

    @Column(
            name = "odr_province"
    )
    private String province;

    @Column(
            name = "odr_city"
    )
    private String city;

    @Column(
            name = "odr_address"
    )
    private String memAdd;

    @CreationTimestamp
    @Column(
            name = "odr_date"
    )
    private Timestamp odrdate;

    @Column(
            name = "odr_totalprice"
    )
    private int odrtotalprice;
    @Column(
            name = "odr_method"
    )
    private int odrmethod;
    @Column(
            name = "odr_count"
    )
    private int odrcount;
    @Column(
            name = "odr_comment"
    )
    private String odrcomment;

    public Order(Long orderid, User user, Register register, String nickname, String memPhone, String zipcode, String country, String province, String city, String memAdd, Timestamp odrdate, int odrtotalprice, int odrmethod, int odrcount, String odrcomment) {
        this.orderid = orderid;
        this.user = user;
        this.register = register;
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

    public Order() {

    }

//    public Order toEntity() {
//        return new OrderDto(null, user, odrdate, odrtotalprice, odrmethod, odrcount, odrcomment);
//    }
}
