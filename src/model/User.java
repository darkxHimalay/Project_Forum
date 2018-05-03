package model;

import utility.ConnectionProvider;

import java.sql.*;

public class User {
    private  Connection con=null;
    private  PreparedStatement ps;
    private  ResultSet rs;
    private  Statement stm;
    public boolean validate(String s,String a)throws SQLException {
        try{
            con= new ConnectionProvider().getConnection();
            ps=con.prepareStatement("select * from logintableetech where email=? and password=?");
            ps.setString(1,s);
            ps.setString(2,a);
            rs=ps.executeQuery();
            if(rs.next())
            {return true;}
        }catch (Exception e){e.printStackTrace();}
        finally {
            con.close();
            ps.close();
        }
        return false;
    }
    public void insertData(String username,String email,String pass,String reg_id,String dob)throws SQLException{
        try {
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("INSERT INTO logintableetech VALUES (?,?,?,?,?,now(),NULL)");
            ps.setString(1,reg_id);
            ps.setString(2,pass);
            ps.setString(3,username);
            ps.setString(4,email);
            ps.setString(5,dob);
            ps.executeUpdate();
        }
        catch (Exception e){e.printStackTrace();}
        finally {
            con.close();
            ps.close();
        }
    }
    public String getname(int id)throws SQLException {
        String name = null;
        try {
            con = new ConnectionProvider().getConnection();
            ps = con.prepareStatement("SELECT full_name FROM logintableetech WHERE student_id=? ");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            name = rs.getString("full_name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            con.close();
            ps.close();
        }
        return name;
    }
    public String getbeboId(int id)throws SQLException{
        String name=null;
        try {
            con = new ConnectionProvider().getConnection();
            ps = con.prepareStatement("SELECT bebo_reg_id FROM logintableetech WHERE student_id=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();
            rs.next();
            name= rs.getString("bebo_reg_id");
        }catch (Exception e){e.printStackTrace();}
        finally {
            con.close();
            ps.close();
        }
        return name;
    }
    public int getStudent_id(String emailid)throws SQLException{
        int id=0;
        try {
            con = new ConnectionProvider().getConnection();
            ps = con.prepareStatement("SELECT * FROM logintableetech WHERE email=?");
            ps.setString(1,emailid);
            rs=ps.executeQuery();
            rs.next();
            id= rs.getInt(7);
        }catch (Exception e){e.printStackTrace();}
        finally {
            con.close();
            ps.close();
        }
        return id;
    }

    public static void main(String[] args)throws SQLException {
        String s=new User().getname(1);
        System.out.println(s);
        int i=new User().getStudent_id("hello@gmail.com");
        System.out.println(i);
    }
}