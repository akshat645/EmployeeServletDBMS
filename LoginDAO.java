package DAO;
import java.sql.*;
import Myconnection.*;
public class LoginDAO {
public static boolean checkLogin(String uname,String upass )throws Exception
{
Connection con=null;
con=MyConnection.getConnection();
PreparedStatement ps=null;
String sql="select * from loginadmin where uname=?";
ps=con.prepareStatement(sql);
ps.setString(1,uname);


ResultSet rs=null;
rs=ps.executeQuery();
if(rs.next())
    if(rs.getString(2).equals(upass))
    return true;
return false;


}

}
