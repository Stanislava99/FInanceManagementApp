package com.example.pfm.Models;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class TransactionEntity {

    @Id
    private Long id;

    @Column(name = "beneficiaryName")
    private String beneficiaryName;

    @Column(name = "date")
    private String date;

    @Column(name = "amount")
    private double amount;

    @Column(name = "description")
    private String description;

    @Column(name = "currency")
    private String currency;

    @Column(name = "mcc")
    private String mcc;

    @Column(name = "kind")
    private String kind;

    public TransactionEntity() {
    }

    public TransactionEntity(Long id, String beneficiaryName, String date, double amount, String description, String currency, String mcc, String kind) {
        this.id = id;
        this.beneficiaryName = beneficiaryName;
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.currency = currency;
        this.mcc = mcc;
        this.kind = kind;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
