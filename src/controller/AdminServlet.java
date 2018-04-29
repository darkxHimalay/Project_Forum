package controller;

import model.AdminPageClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "AdminServlet")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminPageClass adPgCl=new AdminPageClass();
        String question_id=request.getParameter("question_id");
        String showReplies=request.getParameter("showQueryRepliesButton");
        String deletequeryButton=request.getParameter("deleteQueryButton");
        String user=request.getParameter("admin_ID");
        String pass=request.getParameter("password");
//        if(adPgCl.validateAdmin(user,pass)){
//            //request.setAttribute("admin_ID",user);
//            request.getRequestDispatcher("AdminDashboard.jsp").forward(request,response);
//        }
        System.out.println(showReplies);
         if(deletequeryButton!=null){
             adPgCl.deleteQueries(question_id);
           if(adPgCl.checkReplies(Integer.parseInt(question_id))){
               adPgCl.deleteReplies(question_id);
               adPgCl.deleteUpvotes(question_id);
            request.getRequestDispatcher("AdminDashboard.jsp").include(request,response);
           }
        }
        else if(showReplies!=null){
             request.setAttribute("question_id",question_id);
             request.getRequestDispatcher("adminPage.jsp").include(request,response);
         }
    }
}