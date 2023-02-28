package vn.edu.hcmuaf.fit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.edu.hcmuaf.fit.db.Connects;
import vn.edu.hcmuaf.fit.bean.User;

public class UserDao {

	static Connection con = null;
	static PreparedStatement pre = null;
	static ResultSet res = null;

	public void saveUser(User u) {
		con = Connects.getConnect();
		String sql = "insert into users(NameUser, EmailUs, Pass , Phone , RegistrationDate, RoleUs, Active, activation_key) values (?,?,?,?,?,?,?,?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, u.getNameUser());
			pre.setString(2, u.getEmailUs());
			pre.setString(3, u.getPass());
			pre.setString(4, u.getPhone());
			pre.setDate(5, u.getRegistrationDate());
			pre.setInt(6, u.getRoleUs());
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
	
	public User login(String EmailUs, String Pass) {
		con = Connects.getConnect();
		User user = null;
		String sql = "select * from users where EmailUs = ? and Pass = ? and active = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, EmailUs);
			pre.setString(2, Pass);
			pre.setInt(3, 1);
			res = pre.executeQuery();
			if(res.next()) {
				user = new User();
				user.setActive(res.getInt("active"));
				user.setEmailUs(res.getString("EmailUs"));
				user.setRoleUs(res.getInt("RoleUs"));
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

	public void updatePassword(String newpass, String EmailUs) {
		con = Connects.getConnect();
		String sql = "update users set Pass = ? where EmailUs = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, newpass);
			pre.setString(2, EmailUs);
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(User u) {
		con = Connects.getConnect();
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
	
	public User findUserByMaUser(Integer IdUser) {
		User user = null;
		String sql = "select * from users where IdUser = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, IdUser);
			res = pre.executeQuery();
			if(res.next()) {
				user = new User();
				user.setActive(res.getInt("active"));
				user.setEmailUs(res.getString("EmailUs"));
				user.setRoleUs(res.getInt("RoleUs"));
				user.setNameUser(res.getString("NameUserF"));
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

	public static void main(String[] args) {

	}
}
