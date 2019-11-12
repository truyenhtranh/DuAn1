package com.example.test;

public class truyenTranh {
    public String tenChap,tenTruyen,anh;


    public truyenTranh(){

    }

    public truyenTranh(String tenChap, String tenTruyen, String anh) {
        this.tenChap = tenChap;
        this.tenTruyen = tenTruyen;
        this.anh = anh;
    }

    public String getTenChap() {
        return tenChap;
    }

    public void setTenChap(String tenChap) {
        this.tenChap = tenChap;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
}
