package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.bean.Invoice;
import vn.edu.hcmuaf.fit.db.connect;

import java.sql.*;
import java.util.Date;

public class InvoiceService {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    public int addInvoice(Invoice invoice){
        String query = "INSERT INTO invoices ( NameUs, Address ,PayType, StatusIn, Total, ExportDate, Phone) VALUES (?,?,?,?,?,?,?)";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            ps.setInt(1, invoice.getIdIn());
            ps.setString(1, invoice.getNameuser());
            ps.setString(2, invoice.getAddress());
            ps.setString(3, invoice.getType());
            ps.setString(4, invoice.getStatusIn());
            ps.setDouble(5, invoice.getTotal());
            ps.setTimestamp(6, invoice.getDatecreate());
            ps.setString(7,invoice.getPhone());
            ps.executeUpdate();
            try(ResultSet rs = ps.getGeneratedKeys() ){
                if(rs.next()){
                    return rs.getInt(1);
                }
                rs.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail");
        }
        return 0;
    }

    public static void main(String[] args) {
        Invoice in = new Invoice("he","px","cd","x",1205,new Timestamp(new Date().getTime()),"0315");
        InvoiceService invoice = new InvoiceService();
        invoice.addInvoice(in);
    }
}
