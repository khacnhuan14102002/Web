package vn.edu.hcmuaf.fit.bean;

public class DetailInvoice {
    private int iddIn;
    private int Idinvoice;
    private int  Idpro;
    private int quantity;
    private int price;
    public DetailInvoice() {
    }

    public DetailInvoice(int idinvoice, int idpro, int quantity, int price) {
        Idinvoice = idinvoice;
        Idpro = idpro;
        this.quantity = quantity;
        this.price = price;
    }

    public DetailInvoice(int iddIn, int idinvoice, int idpro, int quantity, int price) {
        this.iddIn = iddIn;
        Idinvoice = idinvoice;
        Idpro = idpro;
        this.quantity = quantity;
        this.price = price;
    }

    public int getIddIn() {
        return iddIn;
    }

    public void setIddIn(int iddIn) {
        this.iddIn = iddIn;
    }

    public int getIdinvoice() {
        return Idinvoice;
    }

    public void setIdinvoice(int idinvoice) {
        Idinvoice = idinvoice;
    }

    public int getIdpro() {
        return Idpro;
    }

    public void setIdpro(int idpro) {
        Idpro = idpro;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "DetailInvoice{" +
                "iddIn=" + iddIn +
                ", Idinvoice=" + Idinvoice +
                ", Idpro=" + Idpro +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {

    }
}
