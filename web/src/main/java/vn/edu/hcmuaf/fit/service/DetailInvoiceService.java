package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.db.connect;
import vn.edu.hcmuaf.fit.bean.DetailInvoice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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

    public static void main(String[] args) {
        DetailInvoice de = new DetailInvoice(1,1,1,1,15000);
        DetailInvoiceService detail = new DetailInvoiceService();
        detail.adddetail(de);
    }
}
