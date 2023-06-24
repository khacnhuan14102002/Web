package vn.edu.hcmuaf.fit.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.db.Connects;
import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.db.JDBiConnector;
import vn.edu.hcmuaf.fit.db.connect;

import static vn.edu.hcmuaf.fit.db.Connects.getConnect;

public class UserDao {

    static Connection con = null;
    static PreparedStatement pre = null;
    static ResultSet res = null;

    public void saveUser(User u) {
        con = getConnect();
        String sql = "insert into users(NameUser, EmailUs, Pass, Phone, RegistrationDate, RoleUs,Manager, Active, Keyactive) values (?,?,?,?,?,?,?,?,?)";
        try {
            pre = con.prepareStatement(sql);
            pre.setString(1, u.getNameUser());
            pre.setString(2, u.getEmailUs());
            pre.setString(3, u.getPass());
            pre.setString(4, u.getPhone());
            pre.setDate(5, u.getRegistrationDate());
            pre.setInt(6, u.getRoleUs());
            pre.setInt(7, u.getManager());
            pre.setInt(8, u.getActive());
            pre.setString(9, u.getKeyactive());

            System.out.println(u.getKeyactive());

            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean activeByActivationKey(String Keyactive) {
        con = getConnect();
        String sql = "update users set Active = ? where Keyactive =?";
        try {
            pre = con.prepareStatement(sql);
            pre.setInt(1, 1);
            pre.setString(2, Keyactive);
            return pre.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User login(String email, String pass) {
        con = getConnect();
        User user = null;
        String sql = "select * from users where EmailUs = ? and Pass= ? and Active = ?";
        try {
            pre = con.prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, pass);
            pre.setInt(3, 1);
            res = pre.executeQuery();
            if (res.next()) {
                user = new User();
                user.setActive(res.getInt("Active"));
                user.setEmailUs(email);
                user.setRoleUs(res.getInt("RoleUs"));
                user.setManager(res.getInt("Manager"));
                user.setNameUser(res.getString("NameUser"));
                user.setIdUser(res.getInt("IdUser"));
                user.setRegistrationDate(res.getDate("RegistrationDate"));
                user.setPhone(res.getString("Phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updatePassword(String newpass, String email) {
        con = getConnect();
        String sql = "update users set Pass = ? where EmailUs = ?";
        try {
            pre = con.prepareStatement(sql);
            pre.setString(1, newpass);
            pre.setString(2, email);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User u) {
        con = getConnect();
        String sql = "update users set NameUser=?, EmailUs=?, Pass=?, Phone=? where IdUser = ?";
        try {
            pre = con.prepareStatement(sql);
            pre.setString(1, u.getNameUser());
            pre.setString(2, u.getEmailUs());
            pre.setString(3, u.getPass());
            pre.setString(4, u.getPhone());
            pre.setInt(5, u.getIdUser());
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User getUser(int id) {
        User user = new User();
        String query = "select * from users where IdUser='" + id + "'";
        try {
            con = new connect().getconConnection();
            pre = con.prepareStatement(query);
            res = pre.executeQuery();
            while (res.next()) {

                user.setActive(res.getInt("Active"));
                user.setEmailUs(res.getString("EmailUs"));
                user.setRoleUs(res.getInt("RoleUs"));
                user.setManager(res.getInt("Manager"));
                user.setNameUser(res.getString("NameUser"));
                user.setIdUser(res.getInt("IdUser"));
                user.setRegistrationDate(res.getDate("RegistrationDate"));
                user.setPhone(res.getString("Phone"));
                user.setPass(res.getString("Pass"));


            }

        } catch (Exception e) {
            System.out.println("fail");
        }
        return user;

    }

    public User findUserByMaUser(Integer IdUser) {
        User user = null;
        String sql = "select * from users where IdUser = ?";
        try {
            pre = con.prepareStatement(sql);
            pre.setInt(1, IdUser);
            res = pre.executeQuery();
            if (res.next()) {
                user = new User();
                user.setActive(res.getInt("Active"));
                user.setEmailUs(res.getString("EmailUs"));
                user.setRoleUs(res.getInt("RoleUs"));
                user.setManager(res.getInt("Manager"));
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
                user.setManager(rs.getInt("Manager"));
                user.setActive(rs.getInt("Active"));
                user.setPhone(rs.getString("Phone"));
                user.setPass(rs.getString("Pass"));
                user.setRegistrationDate(rs.getDate("RegistrationDate"));
                user.setKeyactive(rs.getString("Keyactive"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
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

    //them user
    public void addUser(User u) {
        con = getConnect();
        String sql = "insert into users(NameUser, EmailUs, Pass, Phone, RegistrationDate, RoleUs, Active, Keyactive) values (?,?,?,?,?,?,?,?)";
        try {
            pre = con.prepareStatement(sql);
            pre.setString(1, u.getNameUser());
            pre.setString(2, u.getEmailUs());
            pre.setString(3, u.getPass());
            pre.setString(4, u.getPhone());
            pre.setDate(5, u.getRegistrationDate());
            pre.setInt(6, u.getRoleUs());
            pre.setInt(7, u.getActive());
            pre.setString(8, u.getKeyactive());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void EditUser(User u) {
        con = getConnect();
        String sql = "update users set NameUser=? , EmailUs=?, Pass=?, Phone =? , RoleUs=? , Active=? where IdUser = ?";
        try {
            pre = con.prepareStatement(sql);
            pre.setString(1, u.getNameUser());
            pre.setString(2, u.getEmailUs());
            pre.setString(3, u.getPass());
            pre.setString(4, u.getPhone());
            pre.setInt(5, u.getRoleUs());
            pre.setInt(6, u.getActive());
            pre.setInt(7, u.getIdUser());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int userId = 3; // IdUser của người dùng cần kiểm tra

        UserDao userDao = new UserDao();
        User user = userDao.getUser(userId);
//kiểm tra manager có lấy được dữ liệu hay chưa
//        if (user != null) {
//            int manager = user.getManager();
//            System.out.println("Manager: " + manager);
//        } else {
//            System.out.println("User not found.")
//        }
        userDao.saveUser(new User("thi","â@gmail.com","12","121332313",new Date(2023-06-24),1,1,1));
    }

}


