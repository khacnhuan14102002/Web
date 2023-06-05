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

public class LoaiService {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    public static List<category> getLoai() {
        return JDBiConnector.me().withHandle(handle -> {
            return handle.createQuery("select * from category").mapToBean(vn.edu.hcmuaf.fit.bean.category.class).stream().collect(Collectors.toList());
        });

    }

    public static void main(String[] args) {
        LoaiService loai = new LoaiService();
        List<category> list = loai.getLoai();
        for(category o : list){
            System.out.println(o);
        }

    }
}
