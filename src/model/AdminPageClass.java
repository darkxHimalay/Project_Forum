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
    public boolean deleteQueries(String ques_id){
        try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("delete from save_question where question_id=? ");
            ps.setString(1,ques_id);
            ps.executeUpdate();
            return true;
        }
        catch(Exception e){e.printStackTrace();}
        return false;
    }
    public boolean deleteReplies(String ques_id){
            try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("delete from reply_table where question_id=?");
            ps.setString(1,ques_id);
            ps.executeUpdate();
            return true;
        }catch(Exception e){e.printStackTrace();}
        return  false;
    }
    public boolean checkReplies(int ques_id){
        try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("select count(*) from reply_table where question_id=?");
            ps.setInt(1,ques_id);
            rs=ps.executeQuery();
            rs.next();
            int i=rs.getInt("count(*)");
            if(i>0){ return true;}
        }
        catch(Exception e){e.printStackTrace();}
        return  false;
    }
    public static void main(String[] args) {
        boolean vi=new AdminPageClass().deleteQueries("4");
        System.out.println(vi);
    }
}
