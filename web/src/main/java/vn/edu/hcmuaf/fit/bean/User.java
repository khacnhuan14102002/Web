package vn.edu.hcmuaf.fit.bean;

import java.sql.Date;

public class User {

	private Integer maUser;
	
	private String tenUs;
	
	private String email;
	
	private String pass;
	
	private String phone;
	
	private Date ngayDk;
	
	private Integer loai;
	
	private Integer active;
	
	private String activationKey;
	
	private String rememberKey;

	public User() {
		
	}

	public Integer getMaUser() {
		return maUser;
	}

	public void setMaUser(Integer maUser) {
		this.maUser = maUser;
	}

	public String getTenUs() {
		return tenUs;
	}

	public void setTenUs(String tenUs) {
		this.tenUs = tenUs;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getNgayDk() {
		return ngayDk;
	}

	public void setNgayDk(Date ngayDk) {
		this.ngayDk = ngayDk;
	}

	public Integer getLoai() {
		return loai;
	}

	public void setLoai(Integer loai) {
		this.loai = loai;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getActivationKey() {
		return activationKey;
	}

	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	public String getRememberKey() {
		return rememberKey;
	}

	public void setRememberKey(String rememberKey) {
		this.rememberKey = rememberKey;
	}

	@Override
	public String toString() {
		return "User [maUser=" + maUser + ", tenUs=" + tenUs + ", email=" + email + ", pass=" + pass + ", phone="
				+ phone + ", ngayDk=" + ngayDk + ", loai=" + loai + ", active=" + active + ", activationKey="
				+ activationKey + ", rememberKey=" + rememberKey + "]";
	}
	
	
}
