package controller;

import model.AdminPageClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.mail.internet.*;
import java.util.*;
import javax.mail.*;
import javax.activation.*;


@WebServlet(name = "AdminServlet")
public class AdminServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        AdminPageClass adPgCl = new AdminPageClass();
        try {
            if (request.getParameter("login_Sign_in") != null) {
                String user = request.getParameter("admin_ID");
                String pass = request.getParameter("password");
                if (adPgCl.validateAdmin(user, pass)) {
                    request.getRequestDispatcher("adminPage.jsp").include(request, response);
                } else {
                    //PrintWriter out=response.getWriter();
                    out.println("<h5 STYLE=\"color: darkred\">  Login Not Sucess</h5>");
                    request.getRequestDispatcher("admin.jsp").include(request, response);
                }
            }
            //System.out.println(showReplies);
            String question_id = request.getParameter("question_id");
            String showReplies = request.getParameter("showQueryRepliesButton");
            String deletequeryButton = request.getParameter("deleteQueryButton");
            if (deletequeryButton != null) {
                adPgCl.deleteQueries(question_id);
                if (adPgCl.checkReplies(Integer.parseInt(question_id))) {
                    adPgCl.deleteReplies(question_id);

                } else if (adPgCl.checkUpvotes(question_id)) {
                    adPgCl.deleteUpvotes(question_id);
                }
                request.getRequestDispatcher("adminPage.jsp").include(request, response);
            } else if (showReplies != null) {
                request.setAttribute("question_id", question_id);
                request.getRequestDispatcher("adminPage.jsp").include(request, response);
            } else if (request.getParameter("deleteReplyButton") != null) {
                String reply_id = request.getParameter("reply_id");
                adPgCl.deleteReply(reply_id);
                request.getRequestDispatcher("adminPage.jsp").include(request, response);
            }
            String sendButton = request.getParameter("sendButton");
            if (sendButton != null) {
                String to1 = null;
                String to = "";
                String user = "b.18.java.01.02@gmail.com";//sender's id
                String pass = "BTES123#";//sender's password
                String host = "smtp.gmail.com";
                String from = "b.18.java.01.02@gmail.com";//sender's email
                String subject = request.getParameter("sub");
                String messageText = request.getParameter("msg");
                to1 = request.getParameter("emails");//receiver's id
                int j = 0;
                System.out.println(to1);
                //for(int i=0;i<to1.length();i++){
                //  if(to1.charAt(i)==';')
                //{

                //  to=to1.substring(j,i);
                // System.out.println(to);
                // j=i+1;

                boolean sessionDebug = false;
                String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
                // Create some properties and get the default Session.
                Properties props = System.getProperties();
                props.put("mail.host", host);
                props.put("mail.transport.protocol", "smtp");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.", "true");
                props.put("mail.smtp.port", "465");
                props.put("mail.smtp.socketFactory.fallback", "false");
                props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
                Session mailSession = Session.getDefaultInstance(props);

                // Set debug on the Session
                // Passing false will not echo debug info, and passing True will.

                mailSession.setDebug(sessionDebug);

                // Instantiate a new MimeMessage and fill it with the
                // required information.
                try {
                    Message msg = new MimeMessage(mailSession);
                    msg.setFrom(new InternetAddress(from));
                    InternetAddress[] address = {new InternetAddress(to1)};
                    msg.setRecipients(Message.RecipientType.TO, address);
                    msg.setSubject(subject);
                    msg.setSentDate(new java.util.Date());
                    msg.setText(messageText);

                    // Hand the message to the default transport service
                    // for delivery.
                    Transport transport = mailSession.getTransport("smtp");
                    //Transport.send(msg);
                    transport.connect(host, user, pass);

                    transport.sendMessage(msg, msg.getAllRecipients());
                    out.println("Mail was sent to " + to);
                    out.println(" from " + from);
                    out.println(" using host " + host + ".");
                } catch (Exception e) {
                    out.println(e);
                }
                //   }

                // }
                response.sendRedirect("adminPage.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}