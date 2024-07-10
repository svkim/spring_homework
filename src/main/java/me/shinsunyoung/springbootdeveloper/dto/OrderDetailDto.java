package me.shinsunyoung.springbootdeveloper.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import me.shinsunyoung.springbootdeveloper.domain.OrdDetail;
import me.shinsunyoung.springbootdeveloper.domain.Register;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderDetailDto {
private Long prddetailid;
private Long productid;
private int quan;
private int pri;

    public Long getPrddetailid() {
        return prddetailid;
    }

    public Long getProductid() {
        return productid;
    }

    public int getQuan() {
        return quan;
    }

    public int getPri() {
        return pri;
    }

    public void setPrddetailid(Long prddetailid) {
        this.prddetailid = prddetailid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }

    public void setPri(int pri) {
        this.pri = pri;
    }

    public OrderDetailDto(Long prddetailid, Long productid, int quan, int pri) {
        this.prddetailid = prddetailid;
        this.productid = productid;
        this.quan = quan;
        this.pri = pri;
    }

    public OrdDetail toEntity() {
        return new OrdDetail(this.prddetailid, this.productid, this.quan, this.pri);
    }
}
