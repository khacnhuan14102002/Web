package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.bean.Soluongbanra;
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

public class SoluongService {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    public Soluongbanra getQuanexist(int productID) {

        String query = "select soluong from doanhso where IdPro = ?";
        try {
            conn = new connect().getconConnection(); //mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1,productID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Soluongbanra(rs.getInt(1),
                        rs.getInt(2)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }
    public static void updateSoluong(Soluongbanra slbr) {
        String query = "update doanhso set soluong= ? where IdPro= ?";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);

            ps.setInt(1, slbr.getSoLuongDaBan());
            ps.setInt(2, slbr.getProductID());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail");
        }
    }

    public void insertSoLuongDaBan(int productID, int soLuongDaBan) {
        String query = "insert doanhso(IdPro,soluong)values(?,?)";
        try {
            conn = new connect().getconConnection(); //mo ket noi voi sql
            ps = conn.prepareStatement(query);

            ps.setInt(1, productID);
            ps.setInt(2, soLuongDaBan);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public Soluongbanra checkSoLuongDaBanExist(int productID) {

        String query = "select * from doanhso where IdPro='" +productID+ "'";
        try {
            conn = new connect().getconConnection(); //mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Soluongbanra(rs.getInt(1),
                        rs.getInt(2)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }
    public static List<Soluongbanra> get10Soluongbanra() {
        List<Soluongbanra> list = new ArrayList<>();
        String query = "select * from doanhso order by soluong desc limit 10";
        try {
            conn = new connect().getconConnection(); //mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Soluongbanra(rs.getInt(1),
                        rs.getInt(2)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static List<Soluongbanra> get3Soluongbanra() {
        List<Soluongbanra> list = new ArrayList<>();
        String query = "select * from doanhso order by soluong desc limit 3";
        try {
            conn = new connect().getconConnection(); //mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Soluongbanra(rs.getInt(1),
                        rs.getInt(2)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public  List<Soluongbanra> getSoluongbanra() {
        List<Soluongbanra> list = new ArrayList<>();
        String query = "select * from doanhso";
        try {
            conn = new connect().getconConnection(); //mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Soluongbanra(rs.getInt(1),
                        rs.getInt(2)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Soluongbanra> getTotalByProductTypeAndMonth(String text) {
        String year = text.substring(0,text.indexOf("-"));
        String month=text.substring(text.indexOf("-")+1, text.length());
        List<Soluongbanra> salesList = new ArrayList<>();
        try {
            String query = "SELECT p.IdProduct, SUM(d.quantity) AS total_quantity FROM products p JOIN detailsinvoices d ON p.IdProduct = d.Idpro JOIN invoices o ON d.IdIn = o.IdInvoice where year(Exportdate)='"+year+"' and month(Exportdate)='"+month+"' GROUP BY p.IdProduct";
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) {
                int idpro = rs.getInt("IdProduct");
                int totalQuantity = rs.getInt("total_quantity");
                Soluongbanra sales = new Soluongbanra(idpro, totalQuantity);
                salesList.add(sales);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salesList;
    }
    public List<Soluongbanra> getTotalByProductTypeAndDay(String date) {
        List<Soluongbanra> salesList = new ArrayList<>();
        try {
            String query = "SELECT p.IdProduct, SUM(d.quantity) AS total_quantity FROM products p JOIN detailsinvoices d ON p.IdProduct = d.Idpro JOIN invoices o ON d.IdIn = o.IdInvoice where Date(Exportdate)='"+date+"' GROUP BY p.IdProduct";
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) {
                int idpro = rs.getInt("IdProduct");
                int totalQuantity = rs.getInt("total_quantity");
                Soluongbanra sales = new Soluongbanra(idpro, totalQuantity);
                salesList.add(sales);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salesList;
    }
    public List<Soluongbanra> getTotalByProductTypeChooseDay(String date1,String date2) {
        List<Soluongbanra> salesList = new ArrayList<>();
        try {
            String query = "SELECT p.IdProduct, SUM(d.quantity) AS total_quantity FROM products p JOIN detailsinvoices d ON p.IdProduct = d.Idpro JOIN invoices o ON d.IdIn = o.IdInvoice where Date(Exportdate)>='"+date1+"' and Date(Exportdate)<='"+date2+"' GROUP BY p.IdProduct";
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) {
                int idpro = rs.getInt("IdProduct");
                int totalQuantity = rs.getInt("total_quantity");
                Soluongbanra sales = new Soluongbanra(idpro, totalQuantity);
                salesList.add(sales);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salesList;
    }
    public static void main(String[] args) {
        SoluongService sl = new SoluongService();
        // sl.insertSoLuongDaBan(17,2);
        // System.out.println(sl.checkSoLuongDaBanExist());
       System.out.println(sl.getTotalByProductTypeAndDay("2023-05-03"));
    }
}

