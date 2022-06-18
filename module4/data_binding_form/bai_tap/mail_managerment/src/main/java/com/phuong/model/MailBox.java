package com.phuong.model;

public class MailBox {
    private String language;
    private Integer pageSize;
    private Boolean spamsFilter;
    private String signature;

    public MailBox() {
    }

    public MailBox(String language, Integer pageSize, Boolean spamsFilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(Boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "MailBox{" +
                "language='" + language + '\'' +
                ", pageSize=" + pageSize +
                ", spamsFilter=" + spamsFilter +
                ", signature='" + signature + '\'' +
                '}';
    }
}
