package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.bean.Invoice;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.db.JDBiConnector;
import vn.edu.hcmuaf.fit.db.connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceService {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    public int addInvoice(Invoice invoice){
        String query = "INSERT INTO invoices ( NameUs, Address ,PayType, StatusIn, Total, ExportDate, Phone,IdUs) VALUES (?,?,?,?,?,?,?,?)";
        int IdIn = 0;
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
            ps.setInt(8,invoice.getIdUs());
            ps.executeUpdate();
            try(ResultSet rs = ps.getGeneratedKeys() ){
                if(rs.next()){
                    IdIn = rs.getInt(1);
                }
                rs.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail");
        }
        return IdIn;
    }
    public ArrayList<Invoice> getAllIn(int id){
        ArrayList<Invoice> list = new ArrayList<>();
        String query="select * from invoices where IdUs = ?";
        try{
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                Invoice invoice = new Invoice(rs.getInt("IdInvoice"),
                        rs.getString("NameUs"),
                        rs.getString("Address"),
                        rs.getString("PayType"),
                        rs.getString("StatusIn"),
                        rs.getDouble("Total"),
                        rs.getTimestamp("Exportdate"),
                        rs.getString("Phone"),
                        rs.getInt("IdUs"));
                list.add(invoice);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail");
        }
        return list;
    }



    public double totalMoneyDay(int day) {
        String query = "select  SUM(Total) from invoices where Day(Exportdate)=? Group by Day(Exportdate);";
        try {
            conn = new connect().getconConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, day);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    public double totalMoneyMonth(int month) {
        String query = "select SUM(Total) from invoices where MONTH(Exportdate)=? Group by MONTH(Exportdate)";
        try {
            conn = new connect().getconConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, month);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public static void main(String[] args) {
    InvoiceService in = new InvoiceService();
    System.out.println(in.getAllIn(3));
    System.out.println(in.totalMoneyMonth(5));

}
    }
