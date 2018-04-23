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

        String hello=request.getParameter("DeleteQuestion_id");
        AdminPageClass adPgCl=new AdminPageClass();
        if(adPgCl.deleteQueries(hello)){
           if(adPgCl.checkReplies(Integer.parseInt(hello))){
               adPgCl.deleteReplies(hello);
            request.getRequestDispatcher("AdminDashboard.jsp").include(request,response);
           }
           else{
               request.getRequestDispatcher("AdminDashboard.jsp").include(request,response);
           }
        }
    }
}