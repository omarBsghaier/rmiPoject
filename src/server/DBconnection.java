package server;

import java.sql.*;

public class DBconnection{
    static Connection conn;
    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/taches_employes?useSSL=false";
            String username="root";
            String password="";
            conn=DriverManager.getConnection(url,username,password);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
