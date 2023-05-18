package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.bean.category;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.db.JDBiConnector;
import vn.edu.hcmuaf.fit.db.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class    ProductService {

    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    public static List<products> getListProductByCategory(String IdCategory) {
        return JDBiConnector.me().withHandle(handle -> {
            return handle.createQuery("select * from products where IdCategory='" +IdCategory+ "'").mapToBean(vn.edu.hcmuaf.fit.bean.products.class).stream().collect(Collectors.toList());
        });
    }

    public static List<products> getListProductALL() {
        return JDBiConnector.me().withHandle(handle -> {
            return handle.createQuery("select * from products").mapToBean(products.class).stream().collect(Collectors.toList());
        });
    }

    public static products getchitiet(int idProduct){
        products pro = new products();
        String query = "select * from products where IdProduct='" +idProduct+ "'";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

                pro.setIdProduct(rs.getInt(1));
                pro.setIdCategory(rs.getString(2));
                pro.setNameProduct(rs.getString(3));
                pro.setImage(rs.getString(4));
                pro.setPriceNew(rs.getInt(5));
                pro.setPriceOld(rs.getInt(6));
                pro.setQuantityStock(rs.getInt(7));
                pro.setDescription(rs.getString(8));
                pro.setIsnew(rs.getInt(9));
                pro.setDiscount(rs.getInt(10));


            }

        } catch (Exception e) {
            System.out.println("fail");
        }
        return pro;

    }
    public static products getprobyId(int idProduct){
        products pro = new products();
        String query = "select * from products where IdProduct='" +idProduct+ "'";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

                pro.setIdProduct(rs.getInt(1));
                pro.setIdCategory(rs.getString(2));
                pro.setNameProduct(rs.getString(3));
                pro.setImage(rs.getString(4));
                pro.setPriceNew(rs.getInt(5));
                pro.setPriceOld(rs.getInt(6));
                pro.setQuantityStock(rs.getInt(7));
                pro.setDescription(rs.getString(8));
                pro.setIsnew(rs.getInt(9));
                pro.setDiscount(rs.getInt(10));


            }

        } catch (Exception e) {
            System.out.println("fail");
        }
        return pro;

    }
    public static List<products> getListProductpage(List<products> list,int start,int end) {
        List<products> rs = new ArrayList<>();
        for(int i = start; i< end; i++){
            rs.add(list.get(i));
        }
        return rs;

    }
    public  List<products> searchbyName(String txtsearch){
        List<products> lpro = new ArrayList<>();
        products pro = new products();
        String query = "select * from products where nameProduct like ?";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+txtsearch+"%");
            rs = ps.executeQuery();
            while (rs.next()) {

                pro.setIdProduct(rs.getInt(1));
                pro.setIdCategory(rs.getString(2));
                pro.setNameProduct(rs.getString(3));
                pro.setImage(rs.getString(4));
                pro.setPriceNew(rs.getInt(5));
                pro.setPriceOld(rs.getInt(6));
                pro.setQuantityStock(rs.getInt(7));
                pro.setDescription(rs.getString(8));
                pro.setIsnew(rs.getInt(9));
                pro.setDiscount(rs.getInt(10));

                lpro.add(pro);
            }

        } catch (Exception e) {
            System.out.println("fail");
        }
        return lpro;

    }
    public static List<category> listCate() {
        return JDBiConnector.me().withHandle(handle -> {
            return handle.createQuery("select * from category").mapToBean(category.class).stream().collect(Collectors.toList());
        });
    }
    public List<products> getTop10SanPhamBanChay() {
        List<products> list = new ArrayList<>();
        products pro = new products();
        String query = "Select sp.IdProduct,sp.NameProduct, Sum(cthd.Quantity) as SL, sp.PriceNew From products sp, detailsinvoices cthd Where sp.IdProduct=cthd.Idpro Group by sp.IdProduct,sp.NameProduct,sp.PriceNew Order by Sum(cthd.Quantity) DESC limit 10";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

                pro.setIdProduct(rs.getInt(1));
                pro.setIdCategory(rs.getString(2));
                pro.setNameProduct(rs.getString(3));
                pro.setImage(rs.getString(4));
                pro.setPriceNew(rs.getInt(5));
                pro.setPriceOld(rs.getInt(6));
                pro.setQuantityStock(rs.getInt(7));
                pro.setDescription(rs.getString(8));
                pro.setIsnew(rs.getInt(9));
                pro.setDiscount(rs.getInt(10));
                list.add(pro);

            }

        } catch (Exception e) {
            System.out.println("fail");
        }

        return list;
    }
    public static void updateProduct(products pro) {
        String query = "update products set QuantityStock = ?  WHERE IdProduct = ?";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);

            ps.setInt(1, pro.getQuantityStock());
            ps.setInt(2, pro.getIdProduct());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail");
        }
    }
    public static List<products> getListProductlq(String IdCa) {
        return JDBiConnector.me().withHandle(handle -> {
            return handle.createQuery("SELECT * FROM products where IdCategory= '" +IdCa+ "' ORDER BY RAND() LIMIT 3").mapToBean(vn.edu.hcmuaf.fit.bean.products.class).stream().collect(Collectors.toList());
        });
    }

    public static void main(String[] args) {
        ProductService pro = new ProductService();

        products p = new products(1,"DC", "Đại Dương", "./image/dc2.jpg", 150000, 250000, 55, "Sản phẩm được lấy ý tưởng từ hình ảnh màu xanh của nước biển kết hợp với lông vũ màu xanh khiến cho sản phẩm đẹp hơn bao giờ hết", 1, 40);
        pro.updateProduct(p);
        System.out.println(pro.getTop10SanPhamBanChay());
    }

}
