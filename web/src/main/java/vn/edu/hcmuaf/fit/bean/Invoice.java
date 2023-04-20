package vn.edu.hcmuaf.fit.bean;


import java.sql.Timestamp;

public class Invoice {

    private String nameuser;
    private String address;
    private String type;
    private String StatusIn;
    private double Total;
    private Timestamp datecreate;
    private String phone;

    public Invoice() {
    }


    public Invoice( String nameuser, String address, String type, String statusIn, double total, Timestamp datecreate, String phone) {

        this.nameuser = nameuser;
        this.address = address;
        this.type = type;
        StatusIn = statusIn;
        Total = total;
        this.datecreate = datecreate;
        this.phone = phone;
    }

//    public int getIdIn() {
//        return idIn;
//    }
//
//    public void setIdIn(int idIn) {
//        this.idIn = idIn;
//    }

    public String getNameuser() {
        return nameuser;
    }

    public void setNameuser(String nameuser) {
        this.nameuser = nameuser;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatusIn() {
        return StatusIn;
    }

    public void setStatusIn(String statusIn) {
        StatusIn = statusIn;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public Timestamp getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Timestamp datecreate) {
        this.datecreate = datecreate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                ", nameuser='" + nameuser + '\'' +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", StatusIn='" + StatusIn + '\'' +
                ", Total=" + Total +
                ", datecreate=" + datecreate +
                ", phone='" + phone + '\'' +
                '}';
    }
}
