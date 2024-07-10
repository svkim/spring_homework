package me.shinsunyoung.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "order_detail_tb")
public class OrdDetail {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "prd_detail_id"
    )
    private Long prddetailid;

    @Column(
            name = "ord_id"
    )
    private int ordid;

    @Column(
            name = "product_id"
    )
    private Long productid;
//    private Register register;

    @Column(
            name = "quantity"
    )
private int quan;
    @Column(
            name = "price"
    )
private int pri;

    public OrdDetail(Long prddetailid, Long productid, int quan, int pri) {
        this.prddetailid = prddetailid;
        this.ordid = 0;
        this.productid = productid;
        this.quan = quan;
        this.pri = pri;
    }

    public OrdDetail() {

    }
}
