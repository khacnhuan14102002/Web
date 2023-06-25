package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.bean.Manager;
import vn.edu.hcmuaf.fit.bean.Soluongbanra;
import vn.edu.hcmuaf.fit.bean.category;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.db.JDBiConnector;
import vn.edu.hcmuaf.fit.db.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.stream.Collectors;

public class RoleService {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;


    public static List<Manager> getRole() {
        return JDBiConnector.me().withHandle(handle -> {
            return handle.createQuery("select * from Manager").mapToBean(Manager.class).stream().collect(Collectors.toList());
        });
    }

    public static void updateRole(Manager ma) {
        String query =  "update Manager set manager= ? ,isdelete=?,isedit=?,isadd=? where idU=?";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);

         ps.setInt(1,ma.getManager());
            ps.setInt(2,ma.getIsdelete());
            ps.setInt(3,ma.getIsedit());
            ps.setInt(4,ma.getIsadd());
            ps.setInt(5,ma.getIdU());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail");
        }
    }
    public static  Manager getRoleId(int id) {
        Manager mn = new Manager();
        String query =  "select * from Manager where idU = '"+id+"' ";
        try {
            conn = new connect().getconConnection(); //mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Manager(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }
    public void adddwish(Manager ma){
        String query = "insert into Manager (idU,manager ,isdelete,isedit,isadd) VALUES(?,?,?,?,?)";
        try {
            conn = new connect().getconConnection();
            ps = conn.prepareStatement(query);

            ps.setInt(1,ma.getIdU());
            ps.setInt(2,ma.getManager());
            ps.setInt(3, ma.getIsdelete());
            ps.setInt(4, ma.getIsedit());
            ps.setInt(5,ma.getIsadd());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("fail");
        }
    }
    public static void main(String[] args) {
        RoleService r = new RoleService();

  System.out.println(r.getRole());

}
}
