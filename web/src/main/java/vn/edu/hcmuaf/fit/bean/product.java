package vn.edu.hcmuaf.fit.bean;

import java.io.Serializable;

public class product  implements Serializable {
    private String masp;
    private String maloai;
    private String tensp;
    private String hinhanh;
    private Integer giamoi;
    private Integer giacu;
    private String tinhtrang;
    private String mota;
    private String idnhanxet;
public product(){}
    public product(String masp, String maloai, String tensp, String hinhanh, Integer giamoi, Integer giacu, String tinhtrang, String mota, String idnhanxet) {
        this.masp = masp;
        this.maloai = maloai;
        this.tensp = tensp;
        this.hinhanh = hinhanh;
        this.giamoi = giamoi;
        this.giacu = giacu;
        this.tinhtrang = tinhtrang;
        this.mota = mota;
        this.idnhanxet = idnhanxet;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public Integer getGiamoi() {
        return giamoi;
    }

    public void setGiamoi(Integer giamoi) {
        this.giamoi = giamoi;
    }

    public Integer getGiacu() {
        return giacu;
    }

    public void setGiacu(Integer giacu) {
        this.giacu = giacu;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getIdnhanxet() {
        return idnhanxet;
    }

    public void setIdnhanxet(String idnhanxet) {
        this.idnhanxet = idnhanxet;
    }

    @Override
    public String toString() {
        return "product{" +
                "masp='" + masp + '\'' +
                ", maloai='" + maloai + '\'' +
                ", tensp='" + tensp + '\'' +
                ", hinhanh='" + hinhanh + '\'' +
                ", giamoi=" + giamoi +
                ", giacu=" + giacu +
                ", tinhtrang='" + tinhtrang + '\'' +
                ", mota='" + mota + '\'' +
                ", idnhanxet='" + idnhanxet + '\'' +
                '}';
    }
}