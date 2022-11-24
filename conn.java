import java.sql.*;
import java.awt.event.*;

public class conn {

    Connection c;
    Statement s;

    conn(){
        try
        {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            c = DriverManager.getConnection(
//                    "jodd2233server.mysql.database.azure.com",
//                    "Ayush2233", "Jodd2233@");
//            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","9136");
//            s=c.createStatement();
            String url = String.format("jdbc:mysql://jodd2233server.mysql.database.azure.com:3306/restaurant?verifyServerCertificate=true&useSSL=true&requireSSL=false");
            c = DriverManager.getConnection(url, "Ayush2233", "Jodd2233@");
            s=c.createStatement();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new conn();
    }
}