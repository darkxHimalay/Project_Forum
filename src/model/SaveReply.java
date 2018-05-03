package model;

import utility.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaveReply {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    public String getName( String studentid)throws SQLException{
       try {
           con = new ConnectionProvider().getConnection();
           ps = con.prepareStatement("select * from logintableetech where student_id=?");
           ps.setString(1,studentid);
           rs=ps.executeQuery();
           rs.next();
           return rs.getString(3);
       }catch(Exception e){e.printStackTrace();}finally {
           con.close();
           ps.close();
       }
      return null;
    }
    public String getQuestion(String questionId)throws SQLException{
        try{
            con= new ConnectionProvider().getConnection();
            ps=con.prepareStatement("select * from save_question where question_id=?");
            ps.setString(1,questionId);
            rs=ps.executeQuery();
            rs.next();
            return rs.getString(2);
        }
        catch(Exception e){e.printStackTrace();}finally {
            con.close();
            ps.close();
        }
        return null;
    }
    public String getTopic(String questionId)throws SQLException{
        try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("select * from save_question where question_id=?");
            ps.setString(1,questionId);
            rs=ps.executeQuery();
            if(rs.next())
            {return rs.getString(3);}
        }
        catch (Exception e){e.printStackTrace();}finally {
            con.close();
            ps.close();
        }
        return null;
    }
    public void save_reply(String reply,Integer studentId,Integer studentIdl,Integer questionId)throws SQLException {
        try{
            con= new ConnectionProvider().getConnection();
            ps=con.prepareStatement("Insert into reply_table values(null,?,?,?,?)");
            ps.setString(1,reply);
            ps.setInt(2,studentId);
            ps.setInt(3,studentIdl);
            ps.setInt(4,questionId);
            ps.executeUpdate();
        }
        catch(Exception e){e.printStackTrace();}finally {
            con.close();
            ps.close();
        }
    }
    public static void main(String[] args) throws SQLException {
       //new SaveReply().save_reply("The data which shows in a list is called List View.",1,5,9);
    String he=new SaveReply().getTopic("1");
        System.out.println(he);
    }
}
