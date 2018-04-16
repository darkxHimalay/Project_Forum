package model;

import utility.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class AdminPageClass {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    public int countQueries(){
        try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("select count(*) from save_question");
            rs=ps.executeQuery();
            rs.next();
            return rs.getInt("count(*)");
        }
        catch(Exception e){e.printStackTrace();}
        return 0;
    }
    public int countRegisteredUser(){
        try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("select count(*) from logintableetech");
            rs=ps.executeQuery();
            rs.next();
            return rs.getInt("count(*)");
        }
        catch(Exception e){e.printStackTrace();}
        return 0;
    }
    public int countQueriesAnswered(){
        try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("select count(*) from reply_table");
            rs=ps.executeQuery();
            rs.next();
            return rs.getInt("count(*)");
        }
        catch(Exception e){e.printStackTrace();}
        return 0;
    }
    public static void main(String[] args) {
        int i=new AdminPageClass().countQueriesAnswered();
        System.out.println(i);
    }
}
