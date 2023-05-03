package vn.edu.hcmuaf.fit.bean;

public class Wishlist {
    int idpro;
    String img;
    String name;
    int price;
    int idU;


    public Wishlist(int idpro, String img, String name, int price, int idU) {
        this.idpro = idpro;
        this.img = img;
        this.name = name;
        this.price = price;
        this.idU = idU;
    }

    public int getIdpro() {
        return idpro;
    }

    public void setIdpro(int idpro) {
        this.idpro = idpro;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "idpro=" + idpro +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

