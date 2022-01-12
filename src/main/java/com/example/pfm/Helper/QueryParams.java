package com.example.pfm.Helper;

import static com.example.pfm.Helper.SortOrder.ASC;

public class QueryParams {

    private int page = 1;

    private int pageSize = 10;

    private String startDate;

    private String endDate;

    private String transactionKind;

    private String sortOrder;

    private SortOrder sortBy = ASC;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTransactionKind() {
        return transactionKind;
    }

    public void setTransactionKind(String transactionKind) {
        this.transactionKind = transactionKind;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public SortOrder getSortBy() {
        return sortBy;
    }

    public void setSortBy(SortOrder sortBy) {
        this.sortBy = sortBy;
    }
}
