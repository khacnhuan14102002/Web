package vn.edu.hcmuaf.fit.service;


//import org.checkerframework.checker.units.qual.A;
import vn.edu.hcmuaf.fit.bean.category;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.db.JDBiConnector;
import vn.edu.hcmuaf.fit.db.connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreService {


    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    public static List<products> getListProductByCategory(String IdCategory) {
//        ArrayList<products> list = new ArrayList<>();
//        String query = "select * from products where IdCategory='" +IdCategory+ "'";
//        try{
//            conn = new connect().getconConnection();
//            ps = conn.prepareStatement(query);
//            rs=ps.executeQuery();
//            while(rs.next()){
//                products pro= new products(rs.getString(1),
//                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11));
//                list.add(pro);
//
//            }
//            return list;
//        } catch (Exception e) {
//            System.out.println("fail");
//        }
//        return null;
        return JDBiConnector.me().withHandle(handle -> {
            return handle.createQuery("select * from products where IdCategory='" +IdCategory+ "'").mapToBean(vn.edu.hcmuaf.fit.bean.products.class).stream().collect(Collectors.toList());
        });
    }

    public static List<products> getListProductALL() {
//        ArrayList<products> list = new ArrayList<>();
////        String query = "select * from products";
////        try {
////            conn = new connect().getconConnection();
////            ps = conn.prepareStatement(query);
////            rs = ps.executeQuery();
////            while (rs.next()) {
////                products pro = new products(rs.getString(1),
////                        rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
////                list.add(pro);
////
////            }
////
////        } catch (Exception e) {
////            System.out.println("fail");
////        }
////        return list;
        return JDBiConnector.me().withHandle(handle -> {
            return handle.createQuery("select * from products").mapToBean(products.class).stream().collect(Collectors.toList());
        });
    }

    public static products getchitiet(String idProduct){
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
                ;


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
        List<products> lis = new ArrayList<>();
        products pro = new products();
        String query = "select * from products where nameProduct like ?";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+ txtsearch+"%");
            rs = ps.executeQuery();
            while (rs.next()) {

                lis.add(new products(
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
        return lis;

    }

    public  List<category> ListCategory() {
        List<category> listCat = new ArrayList<>();
        String query = "select * from category";
        try {
            conn = new connect().getconConnection(); //mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                category cate = new category(rs.getString(1 ),rs.getString(2));
                listCat.add(cate);
            }
        } catch (Exception e) {
            System.out.println("fail");
        }
        return listCat;
    }
    public List<category> getListCat() {
//        ArrayList<products> list = new ArrayList<>();
////        String query = "select * from products";
////        try {
////            conn = new connect().getconConnection();
////            ps = conn.prepareStatement(query);
////            rs = ps.executeQuery();
////            while (rs.next()) {
////                products pro = new products(rs.getString(1),
////                        rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
////                list.add(pro);
////
////            }
////
////        } catch (Exception e) {
////            System.out.println("fail");
////        }
////        return list;
        return JDBiConnector.me().withHandle(handle -> {
            return handle.createQuery("select * from category").mapToBean(category.class).stream().collect(Collectors.toList());
        });
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
        public List<products> lispaging(ArrayList<products> pro,int start,int end){
        List<products> list = new ArrayList<>();
        for(int i = start;i< end;i++){list.add(pro.get(i));
            }
            return list;

        }
    public List<products> paging(int index){
        List<products> list = new ArrayList<>();
        String query = "SELECT * FROM products ORDER BY IdProduct LIMIT 12 OFFSET ?";
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


    public List<products> maxtomin(){
        List<products> list = new ArrayList<>();
        String query = "select * from products ORDER BY PriceNew desc";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
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
    public List<products> mintomax(){
        List<products> list = new ArrayList<>();
        String query = "select * from products ORDER BY PriceNew asc";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
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
    public List<products> ZtoA(){
        List<products> list = new ArrayList<>();
        String query = "select * from products ORDER BY NameProduct desc";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
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
    public List<products> AtoZ(){
        List<products> list = new ArrayList<>();
        String query = "select * from products ORDER BY NameProduct asc";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
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
    public List<products> To11(){
        List<products> list = new ArrayList<>();
        String query = "select * from products WHERE PriceNew BETWEEN 10000 AND 100000;";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
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
    public List<products> To12(){
        List<products> list = new ArrayList<>();
        String query = "select * from products WHERE PriceNew BETWEEN 100000 AND 200000;";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
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
    public List<products> To23(){
        List<products> list = new ArrayList<>();
        String query = "select * from products WHERE PriceNew BETWEEN 200000 AND 300000;";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
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

    public List<products> To34(){
        List<products> list = new ArrayList<>();
        String query = "select * from products WHERE PriceNew BETWEEN 300000 AND 400000;";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
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
    public List<products> isNew(){
        List<products> list = new ArrayList<>();
        String query = "select * from products WHERE Isnew = '1';";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
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
        StoreService pro = new StoreService();
//        System.out.println(pro.getListProductByCategory("TH"));
//        System.out.println(pro.getListProductALL().size());
     System.out.println(pro.getchitiet("1"));
//        System.out.println(pro.searchbyName("Đ"));
//        System.out.println(pro.getListCat());
//        System.out.println(pro.gettotalpro());

        List<products> prod = pro.isNew();
        for(products o : prod){
            System.out.println(o);
        }
    }



}

