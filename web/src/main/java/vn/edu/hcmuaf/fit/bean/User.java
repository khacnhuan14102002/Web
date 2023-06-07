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
    private int Manager;
//	public User(){
//	}

    public User(String nameUser, String emailUs, String pass, String phone, Date registrationDate, int roleUs, int manager, int active, String keyactive) {
        NameUser = nameUser;
        EmailUs = emailUs;
        Pass = pass;
        Phone = phone;
        RegistrationDate = registrationDate;
        RoleUs = roleUs;
        Manager = manager;
        Active = active;
        Keyactive = keyactive;
    }

    public User(String nameUser, String emailUs, String pass, String phone, Date registrationDate, int roleUs, int manager, int active) {
        NameUser = nameUser;
        EmailUs = emailUs;
        Pass = pass;
        Phone = phone;
        RegistrationDate = registrationDate;
        RoleUs = roleUs;
        Manager = manager;
        Active = active;
    }

    public User(int idUser, String nameUser, String emailUs, String pass, String phone, Date registrationDate, int roleUs, int manager, int active) {
        IdUser = idUser;
        NameUser = nameUser;
        EmailUs = emailUs;
        Pass = pass;
        Phone = phone;
        RegistrationDate = registrationDate;
        RoleUs = roleUs;
        Manager = manager;
        Active = active;
    }

    public User(String nameUser, String emailUs, String pass, String phone, int roleUs, int manager, int active, String keyactive) {
        NameUser = nameUser;
        EmailUs = emailUs;
        Pass = pass;
        Phone = phone;
        RoleUs = roleUs;
        Manager = Manager;
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

    //
    public int getManager() {
        return Manager;
    }

    public void setManager(int manager) {
        Manager = manager;
    }

    //
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
                + ", Phone=" + Phone + ", RoleUs=" + RoleUs + ", Manager=" + Manager + ", Active=" + Active + ", Keyactive=" + Keyactive + "]";
    }
}
