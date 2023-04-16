package vn.edu.hcmuaf.fit.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.db.Connects;

public class QuanLyUser {
    private Connection con = null;
    private PreparedStatement pre = null;
    private ResultSet res = null;
    // Thêm người dùng
    public static int addUser(User user) {
        String sql = "INSERT INTO Users(NameUser, EmailUs, Pass, Phone, RegistrationDate, RoleUs, Active, Keyactive) VALUES(?,?,?,?,?,?,?,?)";
        int result = 0;
        try (Connection conn = Connects.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getNameUser());
            pstmt.setString(2, user.getEmailUs());
            pstmt.setString(3, user.getPass());
            pstmt.setString(4, user.getPhone());
            pstmt.setDate(5, user.getRegistrationDate());
            pstmt.setInt(6, user.getRoleUs());
            pstmt.setInt(7, user.getActive());
            pstmt.setString(8, user.getKeyactive());
            result = pstmt.executeUpdate();
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Cập nhật thông tin người dùng
    public static int capNhatUser(String name, String email, String phone, int role, int active, int id) {
        String sql = "UPDATE Users SET NameUser = ?, EmailUs = ?, Phone = ?, RoleUs = ?, Active = ? WHERE IdUser = ?";
        int result = 0;
        try (Connection conn = Connects.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setInt(4, role);
            pstmt.setInt(5, active);
            pstmt.setInt(6, id);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Xóa người dùng
    public static int deleteUser(int id) {
        String sql = "DELETE FROM Users WHERE IdUser = ?";
        int result = 0;
        try (Connection conn = Connects.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Lấy thông tin tất cả người dùng
    public static ArrayList<User> getAllUsers() {
        String sql = "SELECT * FROM Users";
        ArrayList<User> users = new ArrayList<>();
        try (Connection conn = Connects.getConnect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getInt("IdUser"));
                user.setNameUser(rs.getString("NameUser"));
                user.setEmailUs(rs.getString("EmailUs"));
                user.setRoleUs(rs.getInt("RoleUs"));
                user.setActive(rs.getInt("Active"));
                user.setPhone(rs.getString("Phone"));
                user.setRegistrationDate(rs.getDate("RegistrationDate"));
                user.setKeyactive(rs.getString("Keyactive"));
                users.add(user);
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return users;
    }

    public User findUserByMaUser(Integer IdUser) {
        User user = null;
        String sql = "select * from users where IdUser = ?";
        try {
            pre = con.prepareStatement(sql);
            pre.setInt(1, IdUser);
            res = pre.executeQuery();
            if(res.next()) {
                user = new User();
                user.setActive(res.getInt("Active"));
                user.setEmailUs(res.getString("EmailUs"));
                user.setRoleUs(res.getInt("RoleUs"));
                user.setNameUser(res.getString("NameUser"));
                user.setIdUser(res.getInt("IdUser"));
                user.setRegistrationDate(res.getDate("RegistrationDate"));
                user.setPhone(res.getString("Phone"));
                user.setPass(res.getString("Pass"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
