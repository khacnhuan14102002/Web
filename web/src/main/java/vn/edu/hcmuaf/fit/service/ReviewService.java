package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.bean.Review;
import vn.edu.hcmuaf.fit.bean.category;
import vn.edu.hcmuaf.fit.db.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getInt(6)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        ReviewService rw = new ReviewService();
        List<Review> list = rw.getAllReviewByProductID("1");
        for (Review o : list) {
            System.out.println(o);

        }
    }
}
