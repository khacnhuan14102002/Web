package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.bean.category;
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
        String query = "select * from products where HideProduct = 0";
        try {
            conn = new connect().getconConnection(); //mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                products pro = new products(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10));
                list.add(pro);
            }
        } catch (Exception e) {
            System.out.println("fail");
        }
        return list;
    }

    public static List<category> getAllCategory() {
        List<category> list = new ArrayList<>();
        String query = "select * from category";
        try {
            conn = new connect().getconConnection(); //mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                category cat = new category(rs.getString(1),
                        rs.getString(2));
                list.add(cat);
            }
        } catch (Exception e) {
            System.out.println("fail");
        }
        return list;
    }
    public void removeProduct(int pid) {
        String query = "UPDATE products\n" +
                "SET HideProduct = 1\n" +
                "WHERE IdProduct = ?";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("fail");
        }
    }

    public static void addProduct(products pro) {
        String query = "INSERT INTO products (IdProduct, IdCategory, NameProduct, Image, PriceNew, PriceOld, QuantityStock, Description,HideProduct)\n" +
                "VALUES (?,?,?,?,?,?,?,?,?);";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, pro.getIdProduct());
            ps.setString(2, pro.getIdCategory());
            ps.setString(3, pro.getNameProduct());
            ps.setString(4, "./image/"+pro.getImage());
            ps.setInt(5, pro.getPriceNew());
            ps.setInt(6, pro.getPriceOld());
            ps.setInt(7, pro.getQuantityStock());
            ps.setString(8, pro.getDescription());
            ps.setInt(9, 0);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail");
        }
    }

    public static void updateProduct(products pro) {
        String query = "update products set NameProduct=?, Image=?, PriceNew=?, PriceOld=?, Description =? WHERE IdProduct = ?";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, pro.getNameProduct());
            ps.setString(2, pro.getImage());
            ps.setInt(3, pro.getPriceNew());
            ps.setInt(4, pro.getPriceOld());
            ps.setString(5, pro.getDescription());
            ps.setInt(6, pro.getIdProduct());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail");
        }
    }
    public  int gettotalpro() {
        String query = "select count(*) from products";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);

            }
        } catch (Exception e) {
            System.out.println("fail");
        }
        return 0;
    }
    public List<products> paging(int index){
        List<products> list = new ArrayList<>();
        String query = "SELECT * FROM products  where HideProduct = 0 ORDER BY IdProduct LIMIT 12 OFFSET ?";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1,(index-1)*12);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new products(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)));

            }


        } catch (Exception e) {
            System.out.println("fail");
        }
        return list;

    }

    public static void main(String[] args) {
        ManagerService mana = new ManagerService();

        System.out.println(mana.getAllCategory());
    }
}
