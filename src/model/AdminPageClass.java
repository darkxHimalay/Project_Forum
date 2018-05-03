package model;

import utility.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminPageClass {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    public int countQueries()throws SQLException{
        try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("select count(*) from save_question");
            rs=ps.executeQuery();
            rs.next();
            return rs.getInt("count(*)");
        }
        catch(Exception e){
            System.out.println(" Inside Count Queries"+e);}finally {
            con.close();
            ps.close();
        }
        return 0;
    }
    public int countRegisteredUser()throws SQLException{
        try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("select count(*) from logintableetech");
            rs=ps.executeQuery();
            rs.next();
            return rs.getInt("count(*)");
        }
        catch(Exception e){
            System.out.println("Inside Count registered user"+e);}finally {
            con.close();
            ps.close();
        }
        return 0;
    }
    public int countQueriesAnswered()throws SQLException{
        try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("select count(*) from reply_table");
            rs=ps.executeQuery();
            rs.next();
            return rs.getInt("count(*)");
        }
        catch(Exception e){
            System.out.println(e+" Inside Count Queries Answered");
        }finally {
            con.close();
            ps.close();
        }
        return 0;
    }
    public boolean deleteQueries(String ques_id)throws SQLException{
        try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("delete from save_question where question_id=? ");
            ps.setString(1,ques_id);
            ps.executeUpdate();
            return true;
        }
        catch(Exception e){
            System.out.println(e+"inside Delete Queries");
        }finally {
            con.close();
            ps.close();
        }
        return false;
    }
    public boolean deleteReplies(String ques_id)throws SQLException{
            try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("delete from reply_table where question_id=?");
            ps.setString(1,ques_id);
            ps.executeUpdate();
            return true;
        }catch(Exception e){
                System.out.println("Inside Delete Replies"+e);
            }finally {
                con.close();
                ps.close();
            }
        return  false;
    }
    public boolean checkReplies(int ques_id)throws SQLException{
        try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("select count(*) from reply_table where question_id=?");
            ps.setInt(1,ques_id);
            rs=ps.executeQuery();
            rs.next();
            int i=rs.getInt("count(*)");
            if(i>0){ return true;}
        }
        catch(Exception e){
            System.out.println(e+"Inside Check Replies");
        }finally {
            con.close();
            ps.close();
        }
        return  false;
    }
    public void deleteUpvotes(String question_id)throws SQLException{
        try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("delete * from upvote where question_id=?");
            ps.setString(1,question_id);
            ps.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Inside delete upvotes"+e);
        }finally {
            con.close();
            ps.close();
        }
    }
    public boolean checkUpvotes(String question_id)throws SQLException{
        try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("select count(*) from upvote where question_id=?");
            ps.setString(1,question_id);
            rs=ps.executeQuery();
            rs.next();
            int i=rs.getInt("count(*)");
            if(i>0){ return true;}
        }
        catch(Exception e){
            System.out.println(e+"Inside Check Upvotes");
        }finally {
            con.close();
            ps.close();
        }
        return  false;
    }
    public boolean validateAdmin(String user,String pass)throws SQLException{
        boolean flag=false;
        try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("select * from admin_login where admin_email_id=? and pass_word=?");
            ps.setString(1,user);
            ps.setString(2,pass);
            rs=ps.executeQuery();
            if(rs!=null){
                flag=true;
                return flag;
            }
        }
        catch(Exception e){
            System.out.println(AdminPageClass.class.getMethods()[8].getName() +" : "+e);
        }finally {
            con.close();
            ps.close();
        }
        return flag;
    }
    public void deleteReply(String reply_id)throws SQLException{
        try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("delete * from reply_table where question_id=?");
            ps.setString(1,reply_id);
            ps.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Inside delete Reply"+e);
        }finally {
            con.close();
            ps.close();
        }
    }
    public void saveAdmin(String email_id,String password)throws SQLException {
        try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("insert into admin_login values(?,?,null)");
            ps.setString(1,email_id);
            ps.setString(2,password);
            ps.executeQuery();
        }
        catch (Exception e){
            System.out.println(e+"Inside save admin");
        }
        finally {
            con.close();
            ps.close();
        }
    }
    public static void main(String[] args) throws SQLException {
        boolean vi=new AdminPageClass().checkReplies(4);
        System.out.println(vi);
    }
}