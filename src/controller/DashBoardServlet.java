package controller;

import com.sun.org.apache.regexp.internal.RE;
import model.SaveQuestion;
import model.Upvote;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
      //  String email=request.getParameter("emauil_us");
        PrintWriter out=response.getWriter();
        try{
            if(request.getParameter("postQuestioButton")!=null){
                String ses=request.getParameter("ses");
                String value=request.getParameter("getValueFromLogin").toString();
                SaveQuestion save=new SaveQuestion();
                save.saveQuestion(s,p,n,SaveQuestion.get_id(n));
                request.setAttribute("value",value);
                request.setAttribute("ses",ses);
                request.getRequestDispatcher("dashboard.jsp").include(request,response);
            }
            else if(request.getParameter("UpVote")!=null ){
                String ses=request.getParameter("ses");
                String question_ID=request.getParameter("question_id");
                String student_idl=request.getParameter("student_idl");
                String student_id=request.getParameter("student_id");
                //String valueObj=request.getParameter("");
               // System.out.println( question_ID+" =====> "+student_idl+" ======> "+student_id);
                Upvote upvote=new Upvote();
                int countUpvote=0;
                if(!upvote.validateQuestion(question_ID,student_id,student_idl)){
                    upvote.insertData(student_id,student_idl,question_ID);
                    countUpvote=upvote.countUpvotes(question_ID,student_id);
                    request.setAttribute("ses",ses);
                    request.setAttribute("value",student_idl);
                    request.setAttribute("count",countUpvote);
                    request.getRequestDispatcher("dashboard.jsp").forward(request,response);

                }
                else{
                    upvote.toggleData(student_id,student_idl,question_ID);
                    countUpvote=upvote.countUpvotes(question_ID,student_id);
                    request.setAttribute("value",student_idl);
                    request.setAttribute("count",countUpvote);
                    request.setAttribute("ses",ses);
                    request.getRequestDispatcher("dashboard.jsp").forward(request,response);
                }
               // System.out.println(countUpvote);
                //Integer countUpvotes=countUpvote;
            }
        }
        catch(Exception e){e.printStackTrace();}
    }
}
