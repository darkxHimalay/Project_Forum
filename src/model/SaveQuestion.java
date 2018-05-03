package model;

import utility.ConnectionProvider;

import java.sql.*;

public class SaveQuestion {
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static Statement stm;
    public static int get_id(String name)throws SQLException {
        try {
            con=new ConnectionProvider().getConnection();
            ps = con.prepareStatement("select student_id from logintableetech where full_name=?");
            ps.setString(1,name);
            rs=ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {e.printStackTrace();}finally {
            con.close();
            ps.close();
        }
        return 0;
    }
    public static void saveQuestion(String question,String topic,String name,int id)throws SQLException {
        try {
            con=new ConnectionProvider().getConnection();
            ps = con.prepareStatement("INSERT INTO save_question VALUES (null,?,?,?,now(),?)");
            ps.setString(1, question);
            ps.setString(2, topic);
            ps.setString(3,name);
            ps.setInt(4,id);
            ps.executeUpdate();
        } catch (Exception e) {e.printStackTrace();}finally {
            con.close();
            ps.close();
        }
    }
    public String showName()throws SQLException{
        try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("SELECT * FROM save_question");
            rs=ps.executeQuery();
            while(rs.next()){
                return rs.getString(3);
            }
        }
        catch (Exception e){e.printStackTrace();}finally {
            con.close();
            ps.close();
        }
        return null;
    }
    public String showTopic()throws SQLException{
        try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("SELECT * FROM save_question");
            rs=ps.executeQuery();
            while(rs.next()){
                return rs.getString(2);
            }
        }
        catch (Exception e){e.printStackTrace();}finally {
            con.close();
            ps.close();
        }
        return null;
    }
    public String showQuestion()throws SQLException{
        try{
            con=new ConnectionProvider().getConnection();
            ps=con.prepareStatement("SELECT * FROM save_question");
            rs=ps.executeQuery();
            while(rs.next()){
                return rs.getString(1);
            }
        }
        catch (Exception e){e.printStackTrace();}finally {
            con.close();
            ps.close();
        }
        return null;
    }
    // public String showdate(){}
    //public ArrayList<Question> showQuestion(){}
//    public static void main(String[] args) {
//       int id=get_id("hello");
//        System.out.println(id);
//    }
}
