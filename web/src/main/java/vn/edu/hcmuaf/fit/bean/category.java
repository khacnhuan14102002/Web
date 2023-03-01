package vn.edu.hcmuaf.fit.bean;

import java.io.Serializable;

public class category implements Serializable {
    String idCat;
    String nameCat;

    public category(String idCat, String nameCat) {
        this.idCat = idCat;
        this.nameCat = nameCat;
    }

    public category() {
    }

    public String getIdCat() {
        return idCat;
    }

    public void setIdCat(String idCat) {
        this.idCat = idCat;
    }

    public String getNameCat() {
        return nameCat;
    }

    public void setNameCat(String nameCat) {
        this.nameCat = nameCat;
    }

    @Override
    public String toString() {
        return "category{" +
                "idCat='" + idCat + '\'' +
                ", nameCat='" + nameCat + '\'' +
                '}';
    }
}
