package vn.edu.hcmuaf.fit.bean;

import java.io.Serializable;

public class products implements Serializable, Comparable<products> {
    private String idProduct;
    private String idCategory;
    private String nameProduct;
    private String image;
    private Integer priceNew;
    private Integer priceOld;
    private Integer quantityStock;
    private String description;
    private String idReview;
    private int isnew;
    private int discount;

    public products(){

    }

    public products(String idProduct, String idCategory, String nameProduct, String image, Integer priceNew, Integer priceOld, Integer quantityStock, String description, String idReview, int isnew, int discount) {
        this.idProduct = idProduct;
        this.idCategory = idCategory;
        this.nameProduct = nameProduct;
        this.image = image;
        this.priceNew = priceNew;
        this.priceOld = priceOld;
        this.quantityStock = quantityStock;
        this.description = description;
        this.idReview = idReview;
        this.isnew = isnew;
        this.discount = discount;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPriceNew() {
        return priceNew;
    }

    public void setPriceNew(Integer priceNew) {
        this.priceNew = priceNew;
    }

    public Integer getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(Integer priceOld) {
        this.priceOld = priceOld;
    }

    public Integer getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(Integer quantityStock) {
        this.quantityStock = quantityStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIsnew() {
        return isnew;
    }

    public void setIsnew(int isnew) {
        this.isnew = isnew;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getIdReview() {
        return idReview;
    }

    public void setIdReview(String idReview) {
        this.idReview = idReview;
    }

    @Override
    public String toString() {
        return "products{" +
                "idProduct='" + idProduct + '\'' +
                ", idCategory='" + idCategory + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", image='" + image + '\'' +
                ", priceNew=" + priceNew +
                ", priceOld=" + priceOld +
                ", quantityStock=" + quantityStock +
                ", description='" + description + '\'' +
                ", idReview='" + idReview + '\'' +
                ", isnew=" + isnew +
                ", discount=" + discount +
                '}';
    }

    @Override
    public int compareTo(products o) {

        return Integer.parseInt(this.idProduct) - Integer.parseInt(o.idProduct);
    }


}