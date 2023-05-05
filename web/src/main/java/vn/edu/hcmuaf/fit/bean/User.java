package vn.edu.hcmuaf.fit.bean;


//import java.util.Date;
import java.sql.Date;

public class User {

	private int IdUser;
	private String NameUser;
	private String EmailUs;
	private String Pass;
	private String Phone;
	private Date RegistrationDate;
	private int RoleUs;
	private int Active;
	private String Keyactive;
//	public User(){
//	}

	public User(String nameUser, String emailUs, String pass, String phone, Date registrationDate, int roleUs, int active, String keyactive) {
		NameUser = nameUser;
		EmailUs = emailUs;
		Pass = pass;
		Phone = phone;
		RegistrationDate = registrationDate;
		RoleUs = roleUs;
		Active = active;
		Keyactive = keyactive;
	}

	public User(String nameUser, String emailUs, String pass, String phone, int roleUs, int active, String keyactive) {
		NameUser = nameUser;
		EmailUs = emailUs;
		Pass = pass;
		Phone = phone;
		RoleUs = roleUs;
		Active = active;
		Keyactive = keyactive;
	}

	public User() {

	}

	public int getIdUser() {
		return IdUser;
	}
	public void setIdUser(int idUser) {
		IdUser = idUser;
	}
	public String getNameUser() {
		return NameUser;
	}
	public void setNameUser(String nameUser) {
		NameUser = nameUser;
	}
	public String getEmailUs() {
		return EmailUs;
	}
	public void setEmailUs(String emailUs) {
		EmailUs = emailUs;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public Date getRegistrationDate() {
		return RegistrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		RegistrationDate = registrationDate;
	}
	public int getRoleUs() {
		return RoleUs;
	}
	public void setRoleUs(int roleUs) {
		RoleUs = roleUs;
	}
	public int getActive() {
		return Active;
	}
	public void setActive(int active) {
		Active = active;
	}
	public String getKeyactive() {
		return Keyactive;
	}
	public void setKeyactive(String keyactive) {
		Keyactive = keyactive;
	}
	@Override
	public String toString() {
		return "User [IdUser=" + IdUser + ", NameUser=" + NameUser + ", EmailUs=" + EmailUs + ", Pass=" + Pass
				+ ", Phone=" + Phone + ", RoleUs=" + RoleUs + ", Active=" + Active + ", Keyactive=" + Keyactive + "]";
	}
}
