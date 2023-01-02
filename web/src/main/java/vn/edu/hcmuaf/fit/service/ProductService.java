package vn.edu.hcmuaf.fit.service;

import org.jdbi.v3.core.Handle;
import vn.edu.hcmuaf.fit.bean.Loai;
import vn.edu.hcmuaf.fit.bean.product;
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
    public static List<product> getListProductByLoai(String maloai){
        ArrayList<product> list = new ArrayList<>();
        String query = "select * from sanpham where maloai='" +maloai+ "'";
        try{
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
              product pro= new product(rs.getString(1),
                      rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11));
              list.add(pro);

            }
            return list;
        } catch (Exception e) {
            System.out.println("fail");
        }
        return null;

    }
    public static void main(String[] args) {
        ProductService pro = new ProductService();

        System.out.println(pro.getListProductByLoai("DC").size());
        }

    }

