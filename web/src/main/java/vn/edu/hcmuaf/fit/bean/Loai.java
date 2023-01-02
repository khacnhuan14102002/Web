package vn.edu.hcmuaf.fit.bean;

import java.io.Serializable;

public class Loai implements Serializable {
     String maloai;
    String tenloai;

    public Loai(String maloai, String tenloai) {
        this.maloai = maloai;
        this.tenloai = tenloai;
    }

    public Loai() {
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    @Override
    public String toString() {
        return "Loai{" +
                "maloai='" + maloai + '\'' +
                ", tenloai='" + tenloai + '\'' +
                '}';
    }
}
