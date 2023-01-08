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

public class LoaiService {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    public static List<Loai> getLoai() {
//        ArrayList<Loai> list = new ArrayList<>();
//        String query = "select * from loai";
//        try{
//            conn = new connect().getconConnection();
//            ps = conn.prepareStatement(query);
//            rs=ps.executeQuery();
//            while(rs.next()){
//                Loai loai =new Loai(rs.getString(1),
//                        rs.getString(2));
//            list.add(loai);
//
//            }
//            return list;
//        } catch (Exception e) {
//            System.out.println("fail");
//        }
//        return null;
        return JDBiConnector.me().withHandle(handle -> {
            return handle.createQuery("select * from Loai").mapToBean(vn.edu.hcmuaf.fit.bean.Loai.class).stream().collect(Collectors.toList());
        });

    }

    public static void main(String[] args) {
        LoaiService loai = new LoaiService();
        List<Loai> list = loai.getLoai();
        for(Loai o : list){
            System.out.println(o);
        }

    }
}
