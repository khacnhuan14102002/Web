package vn.edu.hcmuaf.fit.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class connect {
    public Connection getconConnection() throws Exception{
        String url = "jdbc:mysql://" + severName +":"+portNumber + "\\" + instance+"/" +dbName;
        if(instance == null || instance.trim().isEmpty())
            url ="jdbc:mysql://" + severName +":"+portNumber + "/"+dbName;
            Class.forName("com.mysql.cj.jdbc.Driver");
    return  DriverManager.getConnection(url, user, pass);
    }
    private final String severName="localhost";
    private final String dbName="project";
    private final String portNumber="3306";
    private final String instance="";
    private final String user = "root";
    private final String pass = "";

    public static void main(String[] args) {
        try{
                System.out.println(new connect().getconConnection());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
