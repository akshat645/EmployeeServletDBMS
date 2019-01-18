package DAO;
import Myconnection.*;
import java.sql.*;
import POJO.*;
import java.util.*;
public class EmployeeDAO  
{
 
   
    
public boolean insertData(Employee E)throws SQLException
{
Connection con=null;
con=MyConnection.getConnection();
PreparedStatement ps=null;
String sql;
sql="insert into employee values(?,?,?,?,?,?)";
ps=con.prepareStatement(sql);
ps.setInt(1,E.getEid());
ps.setString(2,E.getEname());
ps.setString(3,E.getDept());
ps.setInt(4,E.getSalary());
ps.setLong(5,E.getPh_no());
ps.setString(6,E.getPassword() );
    if (ps.executeUpdate()>0) 
    {
        con.close();
        return true;
    }
    con.close();
    return false;
}



public Employee search_By_eid(Employee E)throws SQLException
{
Connection con=null;
con=MyConnection.getConnection();
PreparedStatement ps=null;
ResultSet rs=null;
String sql=null;
sql="select * from employee where eid=?";
ps=con.prepareStatement(sql);
ps.setInt(1,E.getEid());
rs=ps.executeQuery();


    if (rs.next()) 
    {
    E.setEid(rs.getInt(1));
    E.setEname(rs.getString(2));
    E.setDept(rs.getString(3));
    E.setSalary(rs.getInt(4));
    E.setPh_no(rs.getLong(5));
    E.setPassword(rs.getString(6));
    }
    else 
        System.out.println("Record not found");
    con.close();
    return E;
    

}



public List<Employee> search_By_dept(Employee E)throws SQLException
{
List<Employee> l=new ArrayList<Employee>();
Connection con=null;
con=MyConnection.getConnection();
PreparedStatement ps=null;
ResultSet rs=null;
String sql=null;
sql="select * from employee where dept=?";
ps=con.prepareStatement(sql);
ps.setString(1,E.getDept());
rs=ps.executeQuery();

while(rs.next()!=false)
{
Employee a=new Employee();
a.setEid(rs.getInt(1));
a.setEname(rs.getString(2));
a.setDept(E.getDept());
a.setSalary(rs.getInt(4));
a.setPh_no(rs.getLong(5));
l.add(a);

}
con.close();
return l;
}


public Employee search_By_Ph_No(Employee E)throws SQLException
{
Employee a=new Employee();
Connection con=null;
con=MyConnection.getConnection();
PreparedStatement ps=null;
ResultSet rs=null;
String sql=null;
sql="select * from employee where mobile=?";
ps=con.prepareStatement(sql);
ps.setLong(1,E.getPh_no());
rs=ps.executeQuery();
if(rs.next()!=false)
{

a.setEid(rs.getInt(1));
a.setEname(rs.getString(2));
a.setDept(rs.getString(3));
a.setSalary(rs.getInt(4));
a.setPh_no(E.getPh_no());

}
con.close();
return a;
}

public boolean delete_By_id(Employee E)throws SQLException
{
Connection con=null;
con=MyConnection.getConnection();
PreparedStatement ps=null;
String sql=null;
sql="delete from employee where eid=?";
ps=con.prepareStatement(sql);
ps.setInt(1, E.getEid());
if(ps.executeUpdate()>0)
{   con.close();
    return true;

}
con.close();
return false;    
}

public List<Employee> search_By_All()throws SQLException
{
List<Employee> l=new ArrayList<Employee>();
Connection con=null;
con=MyConnection.getConnection();
PreparedStatement ps=null;
ResultSet rs=null;
String sql=null;
sql="select * from employee";
ps=con.prepareStatement(sql);
rs=ps.executeQuery();

while(rs.next()!=false)
{
Employee a=new Employee();
a.setEid(rs.getInt(1));
a.setEname(rs.getString(2));
a.setDept(rs.getString(3));
a.setSalary(rs.getInt(4));
a.setPh_no(rs.getLong(5));
l.add(a);
}
con.close();
return l;

}
public int last_ID()throws SQLException
{
int a=0;    
List<Employee> l=new ArrayList<Employee>();
Connection con=null;
con=MyConnection.getConnection();
PreparedStatement ps=null;
ResultSet rs=null;
String sql=null;
sql="select max(eid) from employee";
ps=con.prepareStatement(sql);
rs=ps.executeQuery();
while(rs.next()!=false)
    a=rs.getInt(1);
    //System.out.println("dao"+a);
return a;
}
public boolean updateData(Employee E)throws SQLException
{
Connection con=null;
con=MyConnection.getConnection();
PreparedStatement ps=null;
String sql;
sql="update employee set ename=?,dept=?,salary=?,mobile=? where eid=?";
ps=con.prepareStatement(sql);

ps.setString(1,E.getEname());
ps.setString(2,E.getDept());
ps.setInt(3,E.getSalary());
ps.setLong(4,E.getPh_no());
ps.setInt(5,E.getEid()) ;
    if (ps.executeUpdate()>0) 
    {
        con.close();
        return true;
    }
    con.close();
    return false;
}
public Employee checkPassword(Employee E) throws SQLException
{
Connection con=null;
con=MyConnection.getConnection();
PreparedStatement ps=null;
String sql;
sql="select * from employee where eid=?";
ps=con.prepareStatement(sql);
ps.setInt(1,E.getEid());

ResultSet rs=null;
rs=ps.executeQuery();
Employee a=new Employee();
if(rs.next()!=false)
{

a.setEid(rs.getInt(1));
a.setEname(rs.getString(2));
a.setDept(rs.getString(3));
a.setSalary(rs.getInt(4));
a.setPh_no(E.getPh_no());
a.setPassword(rs.getString(6));

}
con.close();
return a;

}

}


