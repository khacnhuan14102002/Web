package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.bean.Invoice;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.db.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    public static List<Invoice> getAllInvoice() {
        List<Invoice> list = new ArrayList<>();
        String query = "select * from invoices";
        try {
            conn = new connect().getconConnection(); //mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Invoice in_voice = new Invoice(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getTimestamp(7),
                        rs.getString(8),
                        rs.getInt(9));
                list.add(in_voice);
            }
        } catch (Exception e) {
            System.out.println("fail");
        }
        return list;
    }

    public static void main(String[] args) {
        OrderService order = new OrderService();
        System.out.println(order.getAllInvoice());
    }
}
