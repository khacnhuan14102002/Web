package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.bean.Log;
import vn.edu.hcmuaf.fit.bean.Review;
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

public class LogService {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    public List<Log> paging(int index) {
        List<Log> list = new ArrayList<>();
        String query = "select * from log WHERE src in(\"AUTHLOGIN FALSE\",\"AUTHLOGIN\") ORDER BY id LIMIT 12 OFFSET ?";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * 12);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Log(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
            System.out.println("fail");
        }
        return list;
    }
    public List<Log> getAllLg() {
        List<Log> list = new ArrayList<>();
        String query = "select * from log WHERE src in(\"AUTHLOGIN FALSE\",\"AUTHLOGIN\")";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Log(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Log> getAllDay(String date) {
        List<Log> list = new ArrayList<>();
        String query = "select * from log WHERE src in(\"AUTHLOGIN FALSE\",\"AUTHLOGIN\") and Date(createAt)='"+date+"'";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Log(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Log> getAllMonth(String text) {
        String year = text.substring(0,text.indexOf("-"));
        String month=text.substring(text.indexOf("-")+1, text.length());
        List<Log> list = new ArrayList<>();
        String query = "select * from log WHERE src in(\"AUTHLOGIN FALSE\",\"AUTHLOGIN\") and year(createAt)='"+year+"' and month(createAt)='"+month+"'";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Log(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Log> getAllChoose(String date1,String date2) {
        List<Log> list = new ArrayList<>();
        String query = "select * from log WHERE src in(\"AUTHLOGIN FALSE\",\"AUTHLOGIN\") and Date(createAt)>='"+date1+"' and Date(createAt)<='"+date2+"'";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Log(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getInt(7)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        LogService l= new LogService();

      System.out.println(l.getAllDay("2023-06-06").size());
        System.out.println(l.getAllChoose("2023-06-06","2023-06-25"));
        }
    }


