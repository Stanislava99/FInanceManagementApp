package com.example.pfm.Models;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "parentCode")
    private String parentCode;

    @Column(name = "name")
    private String name;

    public CategoryEntity() {
    }

    public CategoryEntity(String code, String parentCode, String name) {
        this.code = code;
        this.parentCode = parentCode;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
