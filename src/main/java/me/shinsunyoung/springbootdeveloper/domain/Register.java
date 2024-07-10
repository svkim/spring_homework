package me.shinsunyoung.springbootdeveloper.domain;

import me.shinsunyoung.springbootdeveloper.dto.Addregister;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Setter
@Getter
@Entity
@Table(
        name = "product_tb"
)
public class Register {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "product_id"
    )
    private Long productId;
    @Column(
            name = "prd_name"
    )
    private String prdName;
    @Column(
            name = "prd_stock"
    )
    private int prdStock;
    @Column(
            name = "original_price"
    )
    private int originalPrice;
    @Column(
            name = "discount_price"
    )
    private int discountPrice;
    @Column(
            name = "prd_manufacturer"
    )
    private String prdManufacturer;
    @Column(
            name = "prd_dimensions"
    )
    private String prdDimensions;
    @Column(
            name = "prd_material"
    )
    private String prdMaterial;
    @Column(
            name = "prd_release"
    )
    private String prdRelease;
    @Column(
            name = "prd_modelnumber"
    )
    private String prdModelnumber;
    @Column(
            name = "prd_image"
    )
    private String prdImage;
    @Column(
            name = "prd_majorcategory"
    )
    private String prdMajorcategory;
    @Column(
            name = "prd_subcategory"
    )
    private String prdSubcategory;

    public Register(String prdName, int prdStock, int originalPrice, int discountPrice, String prdManufacturer, String prdDimensions, String prdMaterial, String prdRelease, String prdModelnumber, String prdImage, String prdMajorcategory, String prdSubcategory) {
        this.prdName = prdName;
        this.prdStock = prdStock;
        this.originalPrice = originalPrice;
        this.discountPrice = discountPrice;
        this.prdManufacturer = prdManufacturer;
        this.prdDimensions = prdDimensions;
        this.prdMaterial = prdMaterial;
        this.prdRelease = prdRelease;
        this.prdModelnumber = prdModelnumber;
        this.prdImage = prdImage;
        this.prdMajorcategory = prdMajorcategory;
        this.prdSubcategory = prdSubcategory;
    }

    public static RegisterBuilder builder() {
        return new RegisterBuilder();
    }

    public Long getProductId() {
        return this.productId;
    }

    public String getPrdName() {
        return this.prdName;
    }

    public int getPrdStock() {
        return this.prdStock;
    }

    public int getOriginalPrice() {
        return this.originalPrice;
    }

    public int getDiscountPrice() {
        return this.discountPrice;
    }

    public String getPrdManufacturer() {
        return this.prdManufacturer;
    }

    public String getPrdDimensions() {
        return this.prdDimensions;
    }

    public String getPrdMaterial() {
        return this.prdMaterial;
    }

    public String getPrdRelease() {
        return this.prdRelease;
    }

    public String getPrdModelnumber() {
        return this.prdModelnumber;
    }

    public String getPrdImage() {
        return this.prdImage;
    }

    public String getPrdMajorcategory() {
        return this.prdMajorcategory;
    }

    public String getPrdSubcategory() {
        return this.prdSubcategory;
    }

    public void setProductId(final Long productId) {
        this.productId = productId;
    }

    public void setPrdName(final String prdName) {
        this.prdName = prdName;
    }

    public void setPrdStock(final int prdStock) {
        this.prdStock = prdStock;
    }

    public void setOriginalPrice(final int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public void setDiscountPrice(final int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public void setPrdManufacturer(final String prdManufacturer) {
        this.prdManufacturer = prdManufacturer;
    }

    public void setPrdDimensions(final String prdDimensions) {
        this.prdDimensions = prdDimensions;
    }

    public void setPrdMaterial(final String prdMaterial) {
        this.prdMaterial = prdMaterial;
    }

    public void setPrdRelease(final String prdRelease) {
        this.prdRelease = prdRelease;
    }

    public void setPrdModelnumber(final String prdModelnumber) {
        this.prdModelnumber = prdModelnumber;
    }

    public void setPrdImage(final String prdImage) {
        this.prdImage = prdImage;
    }

    public void setPrdMajorcategory(final String prdMajorcategory) {
        this.prdMajorcategory = prdMajorcategory;
    }

    public void setPrdSubcategory(final String prdSubcategory) {
        this.prdSubcategory = prdSubcategory;
    }

    public Register() {
    }

    public Register(final Long productId, final String prdName, final int prdStock, final int originalPrice, final int discountPrice, final String prdManufacturer, final String prdDimensions, final String prdMaterial, final String prdRelease, final String prdModelnumber, final String prdImage, final String prdMajorcategory, final String prdSubcategory) {
        this.productId = productId;
        this.prdName = prdName;
        this.prdStock = prdStock;
        this.originalPrice = originalPrice;
        this.discountPrice = discountPrice;
        this.prdManufacturer = prdManufacturer;
        this.prdDimensions = prdDimensions;
        this.prdMaterial = prdMaterial;
        this.prdRelease = prdRelease;
        this.prdModelnumber = prdModelnumber;
        this.prdImage = prdImage;
        this.prdMajorcategory = prdMajorcategory;
        this.prdSubcategory = prdSubcategory;
    }

    public String toString() {
        Long var10000 = this.getProductId();
        return "Register(productId=" + var10000 + ", prdName=" + this.getPrdName() + ", prdStock=" + this.getPrdStock() + ", originalPrice=" + this.getOriginalPrice() + ", discountPrice=" + this.getDiscountPrice() + ", prdManufacturer=" + this.getPrdManufacturer() + ", prdDimensions=" + this.getPrdDimensions() + ", prdMaterial=" + this.getPrdMaterial() + ", prdRelease=" + this.getPrdRelease() + ", prdModelnumber=" + this.getPrdModelnumber() + ", prdImage=" + this.getPrdImage() + ", prdMajorcategory=" + this.getPrdMajorcategory() + ", prdSubcategory=" + this.getPrdSubcategory() + ")";
    }

    public static class RegisterBuilder {
        private String prdName;
        private int prdStock;
        private int originalPrice;
        private int discountPrice;
        private String prdManufacturer;
        private String prdDimensions;
        private String prdMaterial;
        private String prdRelease;
        private String prdModelnumber;
        private String prdImage;
        private String prdMajorcategory;
        private String prdSubcategory;

        RegisterBuilder() {
        }

        public RegisterBuilder prdName(final String prdName) {
            this.prdName = prdName;
            return this;
        }

        public RegisterBuilder prdStock(final int prdStock) {
            this.prdStock = prdStock;
            return this;
        }

        public RegisterBuilder originalPrice(final int originalPrice) {
            this.originalPrice = originalPrice;
            return this;
        }

        public RegisterBuilder discountPrice(final int discountPrice) {
            this.discountPrice = discountPrice;
            return this;
        }

        public RegisterBuilder prdManufacturer(final String prdManufacturer) {
            this.prdManufacturer = prdManufacturer;
            return this;
        }

        public RegisterBuilder prdDimensions(final String prdDimensions) {
            this.prdDimensions = prdDimensions;
            return this;
        }

        public RegisterBuilder prdMaterial(final String prdMaterial) {
            this.prdMaterial = prdMaterial;
            return this;
        }

        public RegisterBuilder prdRelease(final String prdRelease) {
            this.prdRelease = prdRelease;
            return this;
        }

        public RegisterBuilder prdModelnumber(final String prdModelnumber) {
            this.prdModelnumber = prdModelnumber;
            return this;
        }

        public RegisterBuilder prdImage(final String prdImage) {
            this.prdImage = prdImage;
            return this;
        }

        public RegisterBuilder prdMajorcategory(final String prdMajorcategory) {
            this.prdMajorcategory = prdMajorcategory;
            return this;
        }

        public RegisterBuilder prdSubcategory(final String prdSubcategory) {
            this.prdSubcategory = prdSubcategory;
            return this;
        }

        public Register build() {
            return new Register(this.prdName, this.prdStock, this.originalPrice, this.discountPrice, this.prdManufacturer, this.prdDimensions, this.prdMaterial, this.prdRelease, this.prdModelnumber, this.prdImage, this.prdMajorcategory, this.prdSubcategory);
        }

        public String toString() {
            return "Register.RegisterBuilder(prdName=" + this.prdName + ", prdStock=" + this.prdStock + ", originalPrice=" + this.originalPrice + ", discountPrice=" + this.discountPrice + ", prdManufacturer=" + this.prdManufacturer + ", prdDimensions=" + this.prdDimensions + ", prdMaterial=" + this.prdMaterial + ", prdRelease=" + this.prdRelease + ", prdModelnumber=" + this.prdModelnumber + ", prdImage=" + this.prdImage + ", prdMajorcategory=" + this.prdMajorcategory + ", prdSubcategory=" + this.prdSubcategory + ")";
        }
    }
}
