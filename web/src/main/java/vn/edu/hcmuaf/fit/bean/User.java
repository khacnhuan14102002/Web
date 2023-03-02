package vn.edu.hcmuaf.fit.bean;

import java.sql.Date;

public class User {

	private Integer IdUser;
	
	private String NameUser;
	
	private String EmailUs;
	
	private String Pass;
	
	private String Phone;
	
	private Date RegistrationDate;
	
	private Integer RoleUs;
	
	private Integer Active;
	
	private String Keyactive;
	
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
		return Phone;
	}

	public void setPhone(String Phone) {
		this.Phone = Phone;
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
		return Active;
	}

	public void setActive(Integer Active) {
		this.Active = Active;
	}

	public String getKeyactive() {
		return Keyactive;
	}

	public void setKeyactive(String Keyactive) {
		this.Keyactive = Keyactive;
	}

	public String getRememberKey() {
		return rememberKey;
	}

	public void setRememberKey(String rememberKey) {
		this.rememberKey = rememberKey;
	}

	@Override
	public String toString() {
		return "User [IdUser=" + IdUser + ", NameUser=" + NameUser + ", EmailUs=" + EmailUs + ", Pass=" + Pass + ", Phone="
				+ Phone + ", RegistrationDate=" + RegistrationDate + ", RoleUs=" + RoleUs + ", Active=" + Active + ", Keyactive="
				+ Keyactive + ", rememberKey=" + rememberKey + "]";
	}
	
	
}
