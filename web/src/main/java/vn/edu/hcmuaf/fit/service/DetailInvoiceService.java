package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.bean.DetailInvoice;
import vn.edu.hcmuaf.fit.bean.Invoice;
import vn.edu.hcmuaf.fit.db.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DetailInvoiceService {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    public void addInvoiceDetail(DetailInvoice in){
        String query = "INSERT INTO Detailsinvoices (IddetailIn,IdIn,Idpro,Quantity,Price) VALUES (?,?,?,?,?);";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, in.getIddIn());
            ps.setInt(2, in.getIdinvoice());
            ps.setInt(3, in.getIdpro());
            ps.setInt(4, in.getQuantity());
            ps.setInt(5, in.getPrice());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail");
        }
    }

    public static void main(String[] args) {
        DetailInvoiceService d = new DetailInvoiceService();
        d.addInvoiceDetail(new DetailInvoice(1,1,1,2,35000));
    }
}
