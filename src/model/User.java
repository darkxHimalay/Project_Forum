package model;

import utility.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    private  Connection con=null;
    private  PreparedStatement ps;
    private  ResultSet rs;
    private  Statement stm;
    public boolean validate(String s,String a){
        try{
            con= new ConnectionProvider().getConnection();
            ps=con.prepareStatement("select * from logintableetech where email=? and password=?");
            ps.setString(1,s);
            ps.setString(2,a);
            rs=ps.executeQuery();
            if(rs.next())
            {return true;}
        }catch (Exception e){e.printStackTrace();}
        return false;
    }
    public void insertData(String username,String email,String pass,String reg_id,String dob){
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
    }
    public String getname(int id) {
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
        return name;
    }
    public String getbeboId(int id){
        String name=null;
        try {
            con = new ConnectionProvider().getConnection();
            ps = con.prepareStatement("SELECT bebo_reg_id FROM logintableetech WHERE student_id=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();
            rs.next();
            name= rs.getString("bebo_reg_id");
        }catch (Exception e){e.printStackTrace();}
        return name;
    }
    public int getStudent_id(String emailid){
        int id=0;
        try {
            con = new ConnectionProvider().getConnection();
            ps = con.prepareStatement("SELECT * FROM logintableetech WHERE email=?");
            ps.setString(1,emailid);
            rs=ps.executeQuery();
            rs.next();
            id= rs.getInt(7);
        }catch (Exception e){e.printStackTrace();}
        return id;
    }

    public static void main(String[] args) {
        String s=new User().getname(1);
        System.out.println(s);
        int i=new User().getStudent_id("hello@gmail.com");
        System.out.println(i);
    }
}