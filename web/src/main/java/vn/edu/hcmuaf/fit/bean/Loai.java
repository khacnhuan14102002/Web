package vn.edu.hcmuaf.fit.bean;

public class Loai {
    String maloai;
    String tenloai;

    public Loai(String maloai, String tenloai) {
        this.maloai = maloai;
        this.tenloai = tenloai;
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
