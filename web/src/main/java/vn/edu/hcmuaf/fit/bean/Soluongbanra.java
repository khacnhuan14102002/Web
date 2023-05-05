package vn.edu.hcmuaf.fit.bean;

public class Soluongbanra {
    private int productID;
    private int soLuongDaBan;

    public Soluongbanra(int productID, int soLuongDaBan) {
        this.productID = productID;
        this.soLuongDaBan = soLuongDaBan;
    }

    public Soluongbanra() {
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getSoLuongDaBan() {
        return soLuongDaBan;
    }

    public void setSoLuongDaBan(int soLuongDaBan) {
        this.soLuongDaBan = soLuongDaBan;
    }

    @Override
    public String toString() {
        return "Soluongbanra{" +
                "productID=" + productID +
                ", soLuongDaBan=" + soLuongDaBan +
                '}';
    }


}
