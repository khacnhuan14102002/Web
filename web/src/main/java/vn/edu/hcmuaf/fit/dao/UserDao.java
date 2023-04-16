package vn.edu.hcmuaf.fit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vn.edu.hcmuaf.fit.db.Connects;
import vn.edu.hcmuaf.fit.bean.User;

import static vn.edu.hcmuaf.fit.db.Connects.getConnect;

public class UserDao {

	private Connection con = null;
	private PreparedStatement pre = null;
	private ResultSet res = null;

	public void saveUser(User u) {
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
			if(res.next()) {
				user = new User();
				user.setActive(res.getInt("Active"));
				user.setEmailUs(email);
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

//	xoa nguoi dung
public void deleteUser(int id) {
	Connection conn = null;
	PreparedStatement stmt = null;
	try {
		conn = getConnect();
		String sql = "DELETE FROM users WHERE IdUser=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.executeUpdate();
	} catch (SQLException ex) {
		ex.printStackTrace();
	} finally {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}


}


