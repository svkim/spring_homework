package me.shinsunyoung.springbootdeveloper.dto;


import me.shinsunyoung.springbootdeveloper.domain.Register;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Getter
@Setter
@ToString
public class Addregister {
    private Long productId;
    private String prdName;
    private int prdStock;
    private int originalPrice;
    private int discountPrice;
    private String prdManufacturer;
    private String prdDimensions;
    private String prdMaterial;
    private String prdRelease;
    private String prdModelnumber;
    private MultipartFile prdImage;
    private String prdMajorcategory;
    private String prdSubcategory;

    public Register toEntity(String prdImage) {
        return new Register((Long)null, this.prdName, this.prdStock, this.originalPrice, this.discountPrice, this.prdManufacturer, this.prdDimensions, this.prdMaterial, this.prdRelease, this.prdModelnumber, prdImage, this.prdMajorcategory, this.prdSubcategory);
    }

    public Addregister() {
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

    public MultipartFile getPrdImage() {
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

    public void setPrdImage(final MultipartFile prdImage) {
        this.prdImage = prdImage;
    }

    public void setPrdMajorcategory(final String prdMajorcategory) {
        this.prdMajorcategory = prdMajorcategory;
    }

    public void setPrdSubcategory(final String prdSubcategory) {
        this.prdSubcategory = prdSubcategory;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Addregister)) {
            return false;
        } else {
            Addregister other = (Addregister)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getPrdStock() != other.getPrdStock()) {
                return false;
            } else if (this.getOriginalPrice() != other.getOriginalPrice()) {
                return false;
            } else if (this.getDiscountPrice() != other.getDiscountPrice()) {
                return false;
            } else {
                Object this$productId = this.getProductId();
                Object other$productId = other.getProductId();
                if (this$productId == null) {
                    if (other$productId != null) {
                        return false;
                    }
                } else if (!this$productId.equals(other$productId)) {
                    return false;
                }

                Object this$prdName = this.getPrdName();
                Object other$prdName = other.getPrdName();
                if (this$prdName == null) {
                    if (other$prdName != null) {
                        return false;
                    }
                } else if (!this$prdName.equals(other$prdName)) {
                    return false;
                }

                label124: {
                    Object this$prdManufacturer = this.getPrdManufacturer();
                    Object other$prdManufacturer = other.getPrdManufacturer();
                    if (this$prdManufacturer == null) {
                        if (other$prdManufacturer == null) {
                            break label124;
                        }
                    } else if (this$prdManufacturer.equals(other$prdManufacturer)) {
                        break label124;
                    }

                    return false;
                }

                Object this$prdDimensions = this.getPrdDimensions();
                Object other$prdDimensions = other.getPrdDimensions();
                if (this$prdDimensions == null) {
                    if (other$prdDimensions != null) {
                        return false;
                    }
                } else if (!this$prdDimensions.equals(other$prdDimensions)) {
                    return false;
                }

                Object this$prdMaterial = this.getPrdMaterial();
                Object other$prdMaterial = other.getPrdMaterial();
                if (this$prdMaterial == null) {
                    if (other$prdMaterial != null) {
                        return false;
                    }
                } else if (!this$prdMaterial.equals(other$prdMaterial)) {
                    return false;
                }

                label103: {
                    Object this$prdRelease = this.getPrdRelease();
                    Object other$prdRelease = other.getPrdRelease();
                    if (this$prdRelease == null) {
                        if (other$prdRelease == null) {
                            break label103;
                        }
                    } else if (this$prdRelease.equals(other$prdRelease)) {
                        break label103;
                    }

                    return false;
                }

                label96: {
                    Object this$prdModelnumber = this.getPrdModelnumber();
                    Object other$prdModelnumber = other.getPrdModelnumber();
                    if (this$prdModelnumber == null) {
                        if (other$prdModelnumber == null) {
                            break label96;
                        }
                    } else if (this$prdModelnumber.equals(other$prdModelnumber)) {
                        break label96;
                    }

                    return false;
                }

                label89: {
                    Object this$prdImage = this.getPrdImage();
                    Object other$prdImage = other.getPrdImage();
                    if (this$prdImage == null) {
                        if (other$prdImage == null) {
                            break label89;
                        }
                    } else if (this$prdImage.equals(other$prdImage)) {
                        break label89;
                    }

                    return false;
                }

                Object this$prdMajorcategory = this.getPrdMajorcategory();
                Object other$prdMajorcategory = other.getPrdMajorcategory();
                if (this$prdMajorcategory == null) {
                    if (other$prdMajorcategory != null) {
                        return false;
                    }
                } else if (!this$prdMajorcategory.equals(other$prdMajorcategory)) {
                    return false;
                }

                Object this$prdSubcategory = this.getPrdSubcategory();
                Object other$prdSubcategory = other.getPrdSubcategory();
                if (this$prdSubcategory == null) {
                    if (other$prdSubcategory != null) {
                        return false;
                    }
                } else if (!this$prdSubcategory.equals(other$prdSubcategory)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Addregister;
    }

    public int hashCode() {
//        int PRIME = true;
        int result = 1;
        result = result * 59 + this.getPrdStock();
        result = result * 59 + this.getOriginalPrice();
        result = result * 59 + this.getDiscountPrice();
        Object $productId = this.getProductId();
        result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
        Object $prdName = this.getPrdName();
        result = result * 59 + ($prdName == null ? 43 : $prdName.hashCode());
        Object $prdManufacturer = this.getPrdManufacturer();
        result = result * 59 + ($prdManufacturer == null ? 43 : $prdManufacturer.hashCode());
        Object $prdDimensions = this.getPrdDimensions();
        result = result * 59 + ($prdDimensions == null ? 43 : $prdDimensions.hashCode());
        Object $prdMaterial = this.getPrdMaterial();
        result = result * 59 + ($prdMaterial == null ? 43 : $prdMaterial.hashCode());
        Object $prdRelease = this.getPrdRelease();
        result = result * 59 + ($prdRelease == null ? 43 : $prdRelease.hashCode());
        Object $prdModelnumber = this.getPrdModelnumber();
        result = result * 59 + ($prdModelnumber == null ? 43 : $prdModelnumber.hashCode());
        Object $prdImage = this.getPrdImage();
        result = result * 59 + ($prdImage == null ? 43 : $prdImage.hashCode());
        Object $prdMajorcategory = this.getPrdMajorcategory();
        result = result * 59 + ($prdMajorcategory == null ? 43 : $prdMajorcategory.hashCode());
        Object $prdSubcategory = this.getPrdSubcategory();
        result = result * 59 + ($prdSubcategory == null ? 43 : $prdSubcategory.hashCode());
        return result;
    }

    public String toString() {
        Long var10000 = this.getProductId();
        return "Addregister(productId=" + var10000 + ", prdName=" + this.getPrdName() + ", prdStock=" + this.getPrdStock() + ", originalPrice=" + this.getOriginalPrice() + ", discountPrice=" + this.getDiscountPrice() + ", prdManufacturer=" + this.getPrdManufacturer() + ", prdDimensions=" + this.getPrdDimensions() + ", prdMaterial=" + this.getPrdMaterial() + ", prdRelease=" + this.getPrdRelease() + ", prdModelnumber=" + this.getPrdModelnumber() + ", prdImage=" + this.getPrdImage() + ", prdMajorcategory=" + this.getPrdMajorcategory() + ", prdSubcategory=" + this.getPrdSubcategory() + ")";
    }
}
