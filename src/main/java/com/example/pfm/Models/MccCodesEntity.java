package com.example.pfm.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mcc")
public class MccCodesEntity {

    @Id
    @Column(name = "code")
    private Long code;
    @Column(name = "merchant_type")
    private String merchantType;

    public MccCodesEntity() {
    }

    public MccCodesEntity(Long code, String merchantType) {
        this.code = code;
        this.merchantType = merchantType;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }
}
