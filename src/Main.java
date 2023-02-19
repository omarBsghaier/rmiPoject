import server.DBconnection;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DBconnection db =  new DBconnection() ;
        DBconnection.createConnection() ;
    }
}