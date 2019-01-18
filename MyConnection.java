package Myconnection;
import java.sql.*;
public class MyConnection {

    static{
    try 
    {
    Class a=Class.forName("com.mysql.jdbc.Driver");
    //System.out.println("driver loaded successfully");        
    } 
    catch (Exception e)
    {
      System.out.println(e);
    }
}    
public static Connection getConnection()
{
Connection con=null;
    try {
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
        //System.out.println("connected");
    } catch (Exception e) {
        System.out.println(e);
    }
    return con;

}
}
