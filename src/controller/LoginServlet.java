package controller;

import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet{
        private Connection con=null;
        private static PreparedStatement ps;
        private static ResultSet rs;

        String username=null;
        String useremail=null;
        String userpass=null;
        String userpass2=null;
        String userreg_id=null;
        String dob=null;
        String buttonValue=null;
        PrintWriter out;
        User user;
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        out=response.getWriter();
        username=request.getParameter("name_us");
        useremail=request.getParameter("emauil_us");
        userpass=request.getParameter("pass_us");
        userpass2=request.getParameter("conf_pass_us");
        userreg_id=request.getParameter("reg_id");
        dob=request.getParameter("dob");
        buttonValue=request.getParameter("sign-sign-up-button");
        int student_id=new User().getStudent_id(useremail);
        //out.println(buttonValue);
       // System.out.println(student_id);
        //String name=User.getname(useremail);
        if(buttonValue.equals("sign_in")){
            try {
                user=new User();
                if(user.validate(useremail,userpass)){
                    //TODO creating a session
//                    HttpSession user_ses=request.getSession(true);
//                    user_ses.setAttribute("ID",name);
                    request.setAttribute("value",student_id);
                    out.println("<h5 STYLE=\"color: darkred\">  Login Sucess</h5>");
                    request.getRequestDispatcher("dashboard.jsp").include(request,response);
                }
            }
            catch(Exception e){e.printStackTrace();}
        }
        else if(buttonValue.equals("sign_up")){
            try {
                user=new User();
                user.insertData(username,useremail,userpass,userreg_id,dob);
                //TODO get the value and check the data is inserted
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);
            }
            catch (Exception e){e.printStackTrace();}
        }
    }
}