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

                pro.setIdProduct(rs.getString(1));
                pro.setIdCategory(rs.getString(2));
                pro.setNameProduct(rs.getString(3));
                pro.setImage(rs.getString(4));
                pro.setPriceNew(rs.getInt(5));
                pro.setPriceOld(rs.getInt(6));
                pro.setQuantityStock(rs.getInt(7));
                pro.setDescription(rs.getString(8));
                pro.setIdReview(rs.getString(9));
                pro.setIsnew(rs.getInt(10));
                pro.setDiscount(rs.getInt(11));


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

                pro.setIdProduct(rs.getString(1));
                pro.setIdCategory(rs.getString(2));
                pro.setNameProduct(rs.getString(3));
                pro.setImage(rs.getString(4));
                pro.setPriceNew(rs.getInt(5));
                pro.setPriceOld(rs.getInt(6));
                pro.setQuantityStock(rs.getInt(7));
                pro.setDescription(rs.getString(8));
                pro.setIdReview(rs.getString(9));
                pro.setIsnew(rs.getInt(10));
                pro.setDiscount(rs.getInt(11));

                lpro.add(pro);
            }

        } catch (Exception e) {
            System.out.println("fail");
        }
        return lpro;

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

    public static void main(String[] args) {
        StoreService pro = new StoreService();
        System.out.println(pro.getListProductByCategory("TH"));
//        System.out.println(pro.getListProductALL().size());
       System.out.println(pro.getchitiet("DC01"));
        System.out.println(pro.searchbyName("Đại"));
        System.out.println(pro.getListCat());
    }



}

