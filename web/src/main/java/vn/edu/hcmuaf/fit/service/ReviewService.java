package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.bean.Review;
import vn.edu.hcmuaf.fit.bean.category;
import vn.edu.hcmuaf.fit.db.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReviewService {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    public List<Review> getAllReviewByProductID(String productId) {
        List<Review> list = new ArrayList<>();
        String query = "select * from Review where   Idproduct = ? ORDER BY dateReview desc";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, productId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Review(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getTimestamp(4),
                        rs.getString(5),
                        rs.getInt(6)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public int countAllReview() {
        String query = "select count(*) from Review";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    public void insertReview(Review re) {
        String query = "insert Review(IdAccount, Idproduct, ContentReview, dateReview,NameID,Score)values(?,?,?,?,?,?)";

        try {
            conn = new connect().getconConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, re.getAccountID());
            ps.setInt(2, re.getProductID());
            ps.setString(3,re.getContentReview());
            ps.setTimestamp(4,re.getDateReview());
            ps.setString(5,re.getNameID());
            ps.setInt(6,re.getScore());
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        ReviewService rw = new ReviewService();
       double total = 0;
        List<Review> list = rw.getAllReviewByProductID("1");for (Review o : list) {
            total += o.getScore();


        }
       // Review re = new Review(3,1,"Tuyệt vời",new Timestamp(new Date().getTime()),"Nhuận",4);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        //rw.insertReview(re);
        System.out.println(decimalFormat.format(total/rw.countAllReview()));
        System.out.println(total);
        System.out.println(rw.countAllReview());
        System.out.println((Math.round(total/rw.countAllReview()) * 100) / 100.00);

    }
}
