package vn.edu.hcmuaf.fit.bean;

import java.util.Date;

public class Review {
    private int accountID;
    private int productID;
    private String contentReview;
    private Date dateReview;

    private String nameID;
    private int score;
    public Review(int accountID, int productID, String contentReview, Date dateReview, String nameID, int score) {
        this.accountID = accountID;
        this.productID = productID;
        this.contentReview = contentReview;
        this.dateReview = dateReview;
        this.nameID = nameID
        ;   this.score = score;
    }

    public Review() {

    }

    @Override
    public String toString() {
        return "Review{" +
                "accountID=" + accountID +
                ", productID=" + productID +
                ", contentReview='" + contentReview + '\'' +
                ", dateReview=" + dateReview +
                ", score=" + score +
                ", nameID='" + nameID + '\'' +
                '}';
    }

    //    public int c {
//        return accountID;
//    }
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    public int getProductID() {
        return productID;
    }
    public void setProductID(int productID) {
        this.productID = productID;
    }
    public String getContentReview() {
        return contentReview;
    }
    public void setContentReview(String contentReview) {
        this.contentReview = contentReview;
    }
    public Date getDateReview() {
        return dateReview;
    }
    public void setDateReview(Date dateReview) {
        this.dateReview = dateReview;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getNameID() {
        return nameID;
    }

    public void setNameID(String nameID) {
        this.nameID = nameID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
