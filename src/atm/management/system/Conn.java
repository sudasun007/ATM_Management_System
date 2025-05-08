package atm.management.system;
import java.sql.*;


//5 steps to JDB connectivity

//1st Register the Driver
//2nd Create Connection
//3rd Create Statement
//4th Execute  Query
//5th Close Connection


public class Conn {

    Connection con;
    Statement st;
    public  Conn(){ // create a constructor

        try{
            //Class.forName("com.mysql.jdbc.Driver");// register the driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // Optional


            //creae connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmDB","root","Sudheera30052807");

            //Create Statement
            st = con.createStatement();

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
