package vn.edu.hcmuaf.fit.bean;

import java.sql.Date;

public class User {

	private Integer IdUser;
	
	private String NameUser;
	
	private String EmailUs;
	
	private String Pass;
	
	private String phone;
	
	private Date RegistrationDate;
	
	private Integer RoleUs;
	
	private Integer active;
	
	private String activationKey;
	
	private String rememberKey;

	public User() {
		
	}

	public Integer getIdUser() {
		return IdUser;
	}

	public void setIdUser(Integer IdUser) {
		this.IdUser = IdUser;
	}

	public String getNameUser() {
		return NameUser;
	}

	public void setNameUser(String NameUser) {
		this.NameUser = NameUser;
	}

	public String getEmailUs() {
		return EmailUs;
	}

	public void setEmailUs(String EmailUs) {
		this.EmailUs = EmailUs;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String Pass) {
		this.Pass = Pass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegistrationDate() {
		return RegistrationDate;
	}

	public void setRegistrationDate(Date RegistrationDate) {
		this.RegistrationDate = RegistrationDate;
	}

	public Integer getRoleUs() {
		return RoleUs;
	}

	public void setRoleUs(Integer RoleUs) {
		this.RoleUs = RoleUs;
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
		return "User [IdUser=" + IdUser + ", NameUser=" + NameUser + ", EmailUs=" + EmailUs + ", Pass=" + Pass + ", phone="
				+ phone + ", RegistrationDate=" + RegistrationDate + ", RoleUs=" + RoleUs + ", active=" + active + ", activationKey="
				+ activationKey + ", rememberKey=" + rememberKey + "]";
	}
	
	
}
