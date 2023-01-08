package vn.edu.hcmuaf.fit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vn.edu.hcmuaf.fit.db.Connects;
import vn.edu.hcmuaf.fit.bean.User;

public class UserDao {

	private Connection con = null;
	private PreparedStatement pre = null;
	private ResultSet res = null;

	public void saveUser(User u) {
		con = Connects.getConnect();
		String sql = "insert into users(TENUS, EMAIL, PASS, SODT, NGAYDK, LOAI, active, activation_key) values (?,?,?,?,?,?,?,?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, u.getTenUs());
			pre.setString(2, u.getEmail());
			pre.setString(3, u.getPass());
			pre.setString(4, u.getPhone());
			pre.setDate(5, u.getNgayDk());
			pre.setInt(6, u.getLoai());
			pre.setInt(7, u.getActive());
			pre.setString(8, u.getActivationKey());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean activeByActivationKey(String activation_key) {
		con = Connects.getConnect();
		String sql = "update users set active = ?, activation_key = ? where activation_key =?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, 1);
			pre.setString(2, "");
			pre.setString(3, activation_key);
			return pre.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public User login(String email, String pass) {
		con = Connects.getConnect();
		User user = null;
		String sql = "select * from users where EMAIL = ? and PASS = ? and active = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, email);
			pre.setString(2, pass);
			pre.setInt(3, 1);
			res = pre.executeQuery();
			if(res.next()) {
				user = new User();
				user.setActive(res.getInt("active"));
				user.setEmail(email);
				user.setLoai(res.getInt("LOAI"));
				user.setTenUs(res.getString("TENUS"));
				user.setMaUser(res.getInt("MAUSER"));
				user.setNgayDk(res.getDate("NGAYDK"));
				user.setPhone(res.getString("SODT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public void updatePassword(String newpass, String email) {
		con = Connects.getConnect();
		String sql = "update users set PASS = ? where EMAIL = ?";
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
		con = Connects.getConnect();
		String sql = "update users set TENUS=?, EMAIL=?, PASS=?, SODT=? where MAUSER = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, u.getTenUs());
			pre.setString(2, u.getEmail());
			pre.setString(3, u.getPass());
			pre.setString(4, u.getPhone());
			pre.setInt(5, u.getMaUser());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User findUserByMaUser(Integer maUser) {
		User user = null;
		String sql = "select * from users where MAUSER = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, maUser);
			res = pre.executeQuery();
			if(res.next()) {
				user = new User();
				user.setActive(res.getInt("active"));
				user.setEmail(res.getString("EMAIL"));
				user.setLoai(res.getInt("LOAI"));
				user.setTenUs(res.getString("TENUS"));
				user.setMaUser(res.getInt("MAUSER"));
				user.setNgayDk(res.getDate("NGAYDK"));
				user.setPhone(res.getString("SODT"));
				user.setPass(res.getString("PASS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;		
	}
}
