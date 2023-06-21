package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.bean.Invoice;
import vn.edu.hcmuaf.fit.db.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ThongkeInvoice {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    public ArrayList<Invoice> getAllInvoice(){
        ArrayList<Invoice> list = new ArrayList<>();
        String query="select * from invoices";
        try{
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
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
    public ArrayList<Invoice> getAllMonth(String text){
        String year = text.substring(0,text.indexOf("-"));
        String month=text.substring(text.indexOf("-")+1, text.length());
        ArrayList<Invoice> list = new ArrayList<>();
        String query="select * from invoices where year(Exportdate)='"+year+"' and month(Exportdate)='"+month+"'";
        try{
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
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
    public  ArrayList<Invoice> thongKeTheoThangHeThong(){
        Date toDate = new Date(System.currentTimeMillis());
        SimpleDateFormat fomatTime = new SimpleDateFormat("yyyy-MM-dd");
        String date = fomatTime.format(toDate.getTime());

        String year = date.substring(0,date.indexOf("-"));
        String month=date.substring(date.indexOf("-")+1, date.lastIndexOf("-"));
        ArrayList<Invoice> list = new ArrayList<>();
        String query="select * from invoices where year(Exportdate)='"+year+"' and month(Exportdate)='"+month+"'";
        try{
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
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
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi thong ke theo thang");
        }
        return list;
    }
    public ArrayList<Invoice> thongKeTheoNgayHeThong(){
        Date toDate = new Date(System.currentTimeMillis());
        SimpleDateFormat fomatTime = new SimpleDateFormat("yyyy-MM-dd");
        String date = fomatTime.format(toDate.getTime());

        ArrayList<Invoice> list = new ArrayList<>();
        String query="select * from invoices where Exportdate='"+date+"'";
        try{
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
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
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi thong ke theo thang");
        }
        return list;
    }
    public ArrayList<Invoice> thongKeTheoNgay(String date){
        ArrayList<Invoice> list = new ArrayList<>();
        String query="select * from invoices where date(Exportdate)='"+date+"'";
        try{
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
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
    public ArrayList<Invoice> getAllInbyDate(String  dates,String datee){
        ArrayList<Invoice> list = new ArrayList<>();
        String query="select * from invoices where Date(Exportdate)>='"+dates+"' and Date(Exportdate)<='"+datee+"'";
        try{
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
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
    public double layTongDoanhThuTheoNgay(Timestamp date){
        ThongkeInvoice tk = new ThongkeInvoice();
        double sum =0;
        for(Invoice ts : tk.thongKeTheoNgay(String.valueOf(date))){

                sum+=ts.getTotal();

        }
        return sum;
    }
    public static void main(String[] args) {
       ThongkeInvoice tk = new ThongkeInvoice();
//        System.out.println(tk.getAllInbyDate("2023-05-01","2023-05-07"));
        //System.out.println(in.getAllInbyMonth("2023-05-01 00:00:00","2023-05-31 23:59:59"));
//        System.out.println(tk.layTongDoanhThuTheoNgay("2023-05-07"));

    }

}
