package model;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import utility.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Upvote {
    //TODO to insert the data
    //TODO to change the data
    private Connection con;
    private PreparedStatement ps;
    private Statement stm;
    private ResultSet rs;
    public void insertData(String studentId,String studentIdl,String question_id){
        try {
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("INSERT INTO upvote VALUES (?,?,'T',?)");
            ps.setString(1,studentId);
            ps.setString(2,studentIdl);
            ps.setString(3,question_id);
            ps.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e+"Insert data");}
    }
    public void toggleData(String student_id,String student_idl,String question_id){
        try{
            //con=new ConnectionProvider().getConnection();
            stm=con.createStatement();
            rs=stm.executeQuery("select * from upvote");
            rs.next();
            String s=rs.getString("toggle");
            ps=con.prepareStatement("update upvote set toggle=? where question_id=? and student_id=? and student_idl=?");
            if(s.equals("T")){
                ps.setString(1,"F");
            }
            else {
                ps.setString(1,"T");
            }
            ps.setString(2,question_id);
            ps.setString(3,student_id);
            ps.setString(4,student_idl);
            int x=ps.executeUpdate();
        }
        catch (Exception e){e.printStackTrace();}
    }
    public int countUpvotes(String question_id,String student_id){
     int count=0;

        try{
            con=new ConnectionProvider().getConnection();
        ps=con.prepareStatement("select count(toggle) from upvote where question_id=? and student_id=? and toggle='T'");
        ps.setString(1,question_id);
        ps.setString(2,student_id);
        rs=ps.executeQuery();
        if(rs.next())
        count=rs.getInt(1);

        }catch (Exception e){
            System.out.println("count Upvotes"+e);}
        return count;
    }
    public boolean validateQuestion(String question_id,String student_id,String student_idl){
        boolean flag=false;
        try{
          //  System.out.println(question_id+" ====> "+student_id);
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("select * from upvote where question_id=? and student_id=? and student_idl=?");
            ps.setString(1,question_id);
            ps.setString(2,student_id);
            ps.setString(3,student_idl);
            rs=ps.executeQuery();
            //System.out.println(rs.getString(1)+" Value from rs");

            if( rs.next())
            flag=true;//return true;
        }catch (Exception e){
            System.out.println("Validate "+e);
        }
      return flag;//return false
    }
    public int countTotalUpvotes(){
        int count=0;
        try{
        con=new ConnectionProvider().getConnection();
        ps=con.prepareStatement("select count(*) from upvote where toggle='T'");
        rs=ps.executeQuery();
        rs.next();
        count=rs.getInt("count(*)");
        return count;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return count;
    }
    public static void main(String[] args) {
//         Upvote u=new Upvote();
//         u.toggleData("2","2");
//         int i=u.countUpvotes("2","2");
//         System.out.println(i);
    }
}
