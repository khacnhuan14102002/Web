package vn.edu.hcmuaf.fit.service;

import com.sun.tools.javac.Main;
import vn.edu.hcmuaf.fit.bean.Invoice;
import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.db.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

public class InvoiceService {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    public void addInvoice(Invoice invoice){
        String query = "INSERT INTO Invoices (IdInvoice, NameUs, Address, PayType, StatusIn, Total, Exportdate) VALUES (?,?,?,?,?,?,?);";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, invoice.getIdIn());
            ps.setString(2, invoice.getNameuser());
            ps.setString(3, invoice.getAddress());
            ps.setString(4, invoice.getType());
            ps.setString(5, invoice.getStatusIn());
            ps.setDouble(6, invoice.getTotal());
            ps.setTimestamp(7, invoice.getDatecreate());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail");
        }
    }

    public static void main(String[] args) {
        InvoiceService in = new InvoiceService();
        Invoice invoice = new Invoice(1,"ha","ds","cod","null",250,new Timestamp(new Date().getTime()));
        in.addInvoice(invoice);
    }
}
