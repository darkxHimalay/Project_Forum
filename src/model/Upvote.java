package model;

import utility.ConnectionProvider;

import java.sql.*;

public class Upvote {
    //TODO to insert the data
    //TODO to change the data
    private Connection con;
    private PreparedStatement ps;
    private Statement stm;
    private ResultSet rs;
    public void insertData(String studentId,String studentIdl,String question_id)throws SQLException {
        try {
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("INSERT INTO upvote VALUES (?,?,'T',?)");
            ps.setString(1,studentId);
            ps.setString(2,studentIdl);
            ps.setString(3,question_id);
            ps.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e+"Insert data");}finally {
            con.close();
            ps.close();
        }
    }
//    public void toggleData(String student_id,String student_idl,String question_id){
//        try{
//            con=new ConnectionProvider().getConnection();
//            stm=con.createStatement();
//            rs=stm.executeQuery("select * from upvote");
//            rs.next();
//            String s=rs.getString("toggle");
//            ps=con.prepareStatement("update upvote set toggle=? where question_id=? and student_id=? and student_idl=?");
//            if(s.equals("T")){
//                ps.setString(1,"F");
//            }
//            else if(s.equals("F")){
//                ps.setString(1,"T");
//            }
//            ps.setString(2,question_id);
//            ps.setString(3,student_id);
//            ps.setString(4,student_idl);
//            int x=ps.executeUpdate();
//        }
//        catch (Exception e){e.printStackTrace();}
//    }
public void toggleData(String student_id,String student_idl,String question_id)throws SQLException{
    try{
        con=new ConnectionProvider().getConnection();
        stm=con.createStatement();
        rs=stm.executeQuery("select * from upvote where question_id="+question_id+" and student_id="+student_id+" and student_idl="+student_idl+"");
        rs.next();
        String s=rs.getString("toggle");
      //  System.out.println(s);
        if(s.equals("T")){
         //   ps.setString(1,"F");
            ps=con.prepareStatement("update upvote set toggle='F' where question_id=? and student_id=? and student_idl=?");
        }
        else if(s.equals("F")){
           // ps.setString(1,"T");
            ps=con.prepareStatement("update upvote set toggle='T' where question_id=? and student_id=? and student_idl=?");
        }
        ps.setString(1,question_id);
        ps.setString(2,student_id);
        ps.setString(3,student_idl);
        int x=ps.executeUpdate();
    }
    catch (Exception e){e.printStackTrace();}finally {
        con.close();
        ps.close();
    }
}
    public int countUpvotes(String question_id,String student_id)throws SQLException{
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
            System.out.println("count Upvotes"+e);}finally {
            con.close();
            ps.close();
        }
        return count;
    }
    public boolean validateQuestion(String question_id,String student_id,String student_idl)throws SQLException{
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
        }finally {
            con.close();
            ps.close();
        }
      return flag;//return false
    }
    public int countTotalUpvotes()throws SQLException{
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
        }finally {
            con.close();
            ps.close();
        }
        return count;
    }
//    public static void main(String[] args) {
//         Upvote u=new Upvote();
//         u.toggleData("1","1","7");
//         int i=u.countUpvotes("7","1");
//         System.out.println(i);
//    }
}
