package controller;

import model.SaveReply;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ReplyServlet")
public class ReplyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String student_id=request.getParameter("student_id");
     String question_id=request.getParameter("question_id");
     String student_idl=request.getParameter("student_idl");
     int studentId=Integer.parseInt(student_id);
     int questionId=Integer.parseInt(question_id);
     int studentIdl=Integer.parseInt(student_idl);
       // System.out.println(student_id+" ==> "+question_id+" ==> "+student_idl);
     try {
         String ses=request.getParameter("ses");
         request.setAttribute("ses",ses);
         String reply = request.getParameter("ReplyFromJsp");
         SaveReply save= new SaveReply();
         save.save_reply(reply,studentId,studentIdl,questionId);
         request.getRequestDispatcher("Reply.jsp").include(request,response);
     }catch (Exception e){e.printStackTrace();}

     }
}