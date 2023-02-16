package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.bean.Loai;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.db.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ManagerService {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    public static List<products> getAllProduct() {
        List<products> list = new ArrayList<>();
        String query = "select * from sanpham where stt not like 1";
        try {
            conn = new connect().getconConnection(); //mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                products pro = new products(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11));
                list.add(pro);
            }
        } catch (Exception e) {
            System.out.println("fail");
        }
        return list;
    }

    public static List<Loai> getAllCategory() {
        List<Loai> list = new ArrayList<>();
        String query = "select * from loai";
        try {
            conn = new connect().getconConnection(); //mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Loai loai = new Loai(rs.getString(1),
                        rs.getString(2));
                list.add(loai);
            }
        } catch (Exception e) {
            System.out.println("fail");
        }
        return list;
    }

    public void deleteProduct(String pid) {
        String query = "UPDATE sanpham\n" +
                "SET stt = 1\n" +
                "WHERE MASP = ?";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("fail");
        }
    }

    public void removeProduct(String pid) {
        String query = "UPDATE sanpham\n" +
                "SET stt = 1\n" +
                "WHERE MASP = ?";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("fail");
        }
    }

    public static void addProduct(products pro) {
        String query = "INSERT INTO sanpham (masp, maloai, tensp, hinhanh, giamoi, giacu, tinhtrang, mota,stt)\n" +
                "VALUES (?,?,?,?,?,?,?,?,?);";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pro.getMasp());
            ps.setString(2, pro.getMaloai());
            ps.setString(3, pro.getTensp());
            ps.setString(4, pro.getHinhanh());
            ps.setInt(5, pro.getGiamoi());
            ps.setInt(6, pro.getGiacu());
            ps.setString(7, pro.getTinhtrang());
            ps.setString(8, pro.getMota());
            ps.setInt(9, 0);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail");
        }
    }

    public static void updateProduct(products pro) {
        String query = "update sanpham set tensp=?, hinhanh=?, giamoi=?, giacu=?, mota =? WHERE MASP = ?";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, pro.getTensp());
            ps.setString(2, pro.getHinhanh());
            ps.setInt(3, pro.getGiamoi());
            ps.setInt(4, pro.getGiacu());
            ps.setString(5, pro.getMota());
            ps.setString(6, pro.getMasp());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail");
        }
    }

    public static void main(String[] args) {
        ManagerService mana = new ManagerService();
//        mana.removeProduct("DC01");
//        System.out.println(getAllProduct());
//        List<Loai> listC = mana.getAllCategory();
//        List<product> list = getAllProduct();
//        for (Loai o : listC){
//            System.out.println(o);
//        }

    }
}
