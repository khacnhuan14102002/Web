package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.bean.Loai;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.db.JDBiConnector;
import vn.edu.hcmuaf.fit.db.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    public static List<products> getListProductByLoai(String maloai) {
//        ArrayList<products> list = new ArrayList<>();
//        String query = "select * from sanpham where maloai='" +maloai+ "'";
//        try{
//            conn = new connect().getconConnection();
//            ps = conn.prepareStatement(query);
//            rs=ps.executeQuery();
//            while(rs.next()){
//                products pro= new products(rs.getString(1),
//                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11));
//                list.add(pro);
//
//            }
//            return list;
//        } catch (Exception e) {
//            System.out.println("fail");
//        }
//        return null;
        return JDBiConnector.me().withHandle(handle -> {
            return handle.createQuery("select * from sanpham where maloai='" +maloai+ "'").mapToBean(vn.edu.hcmuaf.fit.bean.products.class).stream().collect(Collectors.toList());
        });
    }

    public static List<products> getListProductALL() {
//        ArrayList<products> list = new ArrayList<>();
////        String query = "select * from sanpham";
////        try {
////            conn = new connect().getconConnection();
////            ps = conn.prepareStatement(query);
////            rs = ps.executeQuery();
////            while (rs.next()) {
////                products pro = new products(rs.getString(1),
////                        rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
////                list.add(pro);
////
////            }
////
////        } catch (Exception e) {
////            System.out.println("fail");
////        }
////        return list;
        return JDBiConnector.me().withHandle(handle -> {
            return handle.createQuery("select * from sanpham").mapToBean(products.class).stream().collect(Collectors.toList());
        });
    }

    public static products getchitiet(String masp){
        products pro = new products();
        String query = "select * from sanpham where masp='" +masp+ "'";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

                pro.setMasp(rs.getString(1));
                pro.setMaloai(rs.getString(2));
                pro.setTensp(rs.getString(3));
                pro.setHinhanh(rs.getString(4));
                pro.setGiamoi(rs.getInt(5));
                pro.setGiacu(rs.getInt(6));
                pro.setTinhtrang(rs.getString(7));
                pro.setMota(rs.getString(8));
                pro.setIdnhanxet(rs.getString(9));
                pro.setIsnew(rs.getInt(10));
                pro.setGiamgia(rs.getInt(11));


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
        String query = "select * from sanpham where tensp like ?";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+txtsearch+"%");
            rs = ps.executeQuery();
            while (rs.next()) {

                pro.setMasp(rs.getString(1));
                pro.setMaloai(rs.getString(2));
                pro.setTensp(rs.getString(3));
                pro.setHinhanh(rs.getString(4));
                pro.setGiamoi(rs.getInt(5));
                pro.setGiacu(rs.getInt(6));
                pro.setTinhtrang(rs.getString(7));
                pro.setMota(rs.getString(8));
                pro.setIdnhanxet(rs.getString(9));
                pro.setIsnew(rs.getInt(10));
                pro.setGiamgia(rs.getInt(11));

                lpro.add(pro);
            }

        } catch (Exception e) {
            System.out.println("fail");
        }
        return lpro;

    }
    public static void main(String[] args) {
        ProductService pro = new ProductService();

        System.out.println(pro.getListProductByLoai("DC").size());
        System.out.println(pro.getListProductALL().size());
        System.out.println(pro.getchitiet("DC01"));
        System.out.println(pro.searchbyName("Đ"));
    }

}
