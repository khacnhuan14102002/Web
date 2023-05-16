package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.db.connect;
import vn.edu.hcmuaf.fit.bean.DetailInvoice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DetailInvoiceService {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    public void adddetail(DetailInvoice in){
        String query = "INSERT INTO detailsinvoices (IdIn,Idpro,Quantity,Price) VALUES (?,?,?,?)";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);

            ps.setInt(1, in.getIdinvoice());
            ps.setInt(2, in.getIdpro());
            ps.setInt(3, in.getQuantity());
            ps.setInt(4, in.getPrice());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail");
        }
    }
    public ArrayList<DetailInvoice> getAllIn(int id){
        ArrayList<DetailInvoice> list = new ArrayList<>();
        String query="select * from detailsinvoices where IdIn = ?";
        try{
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                DetailInvoice detailInvoice = new DetailInvoice(
                        rs.getInt("IddetailIn"),
                        rs.getInt("IdIn"),
                        rs.getInt("Idpro"),
                        rs.getInt("Quantity"),
                        rs.getInt("Price"));
                list.add(detailInvoice);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail");
        }
        return list;
    }

    public static void main(String[] args) {
//        DetailInvoice de = new DetailInvoice(1,1,1,1,15000);
        DetailInvoiceService detail = new DetailInvoiceService();
//        detail.adddetail(de);
        System.out.println(detail.getAllIn(3));
    }
}



