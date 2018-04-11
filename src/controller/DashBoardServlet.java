package controller;

import model.SaveQuestion;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "DashBoardServlet")
public class DashBoardServlet extends HttpServlet {
    PrintWriter out;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String s=request.getParameter("question");
        String p=request.getParameter("topic");
        String n=request.getParameter("name");
        PrintWriter out=response.getWriter();
        try{
            if(request.getParameter("postQuestioButton")!=null){
                SaveQuestion save=new SaveQuestion();
                save.saveQuestion(s,p,n,SaveQuestion.get_id(n));
                RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp");
                rd.forward(request,response);
            }
        }
        catch(Exception e){e.printStackTrace();}
    }
}
