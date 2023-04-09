package vn.edu.hcmuaf.fit.bean;

public class ProductCart {
    public int quantity;
    public products pro;

    public ProductCart(int quantity, products pro) {
        this.quantity = quantity;
        this.pro = pro;
    }
    public void incre(){
        this.quantity++;
    }
}
