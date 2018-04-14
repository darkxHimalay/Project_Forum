<%--
  Created by IntelliJ IDEA.
  User: Himalay
  Date: 13-04-2018
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    import="java.sql.Connection" import="java.sql.PreparedStatement" import="utility.ConnectionProvider"
    import="java.sql.ResultSet"%>
<%@ page import="model.SaveReply" %>
<%!
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String reply=null;
    SaveReply re;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <!--Flow of program is very Important while moving through the servlet to jsp-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="image/logo.png">

    <title>E-tech forum</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <style type="text/css">
        body {
            padding-top: 5rem;
        }
        .starter-template {
            padding: 5rem 1.5rem;
            text-align: center;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg fixed-top" style="background-color: #FFC200;">
    <a class="navbar-brand" href="#" style="color: black">E-tech Forum</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp" style="color: black">Login/SignUp<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"style="color: black">Logout</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="dashboard.jsp" style="color: black">Dashboard</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: black">Dropdown</a>
                <div class="dropdown-menu" style="background-color: #FFC200" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="admin.jsp" style="color: black">Admin/Login</a>
                    <a class="dropdown-item" href="# "style="color: black">About Us</a>
                    <a class="dropdown-item" href="# "style="color: black">Something else here</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<main role="main" class="container" style="max-width: 1400px;">
    <form action="ReplyServlet">
        <%! String question_id;
            String student_id;
            String student_idl;
        %>
        <% question_id=request.getParameter("question_id");
           student_id=request.getParameter("student_id");
           student_idl=request.getParameter("student_idl");
           re=new SaveReply();
        %>

        <div class="row" style="width:100%;">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                       <!-- In reply of the  Question-->
                       Topic: <b><%=re.getTopic(question_id)%></b>
                    </div>
                    <div class="card-body" style="">
                        <h5 class="card-title" style="margin-left:32px; ">Question:-<%=re.getQuestion(question_id)%><%%></h5>
                        <p class="card-text"></p>

                        <textarea name="ReplyFromJsp" rows="6" cols="160" style="margin-left:35px; "></textarea>
                        <br>
                        <br>
                        <input type="hidden" name="question_id" value="<%=question_id%>">
                        <input type="hidden" name="student_id" value="<%=student_id%>">
                        <input type="hidden" name="student_idl" value="<%=student_idl%>">
                        <button type="submit" name="postQuestioButton1" class="btn btn-primary" style="margin-left: 32px;">Post your Reply</button>
                        <!--</form>  -->
                    </div>
                </div>
            </div>
        </div>
    </form>
    <br>

    <%
        if(request.getParameter("postQuestionButton1")==null){
            try{
                 con=new ConnectionProvider().getConnection();
                 ps=con.prepareStatement("SELECT * FROM reply_table");
                 rs=ps.executeQuery();
                 while(rs.next()){
    %>
    <div class="row" style="width:100%">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title" style="margin-left: 32px;"><%=re.getName(rs.getString("student_id"))%> Asked <em>Q: <em><%=re.getQuestion(rs.getString("question_id"))%> </h5>
                    <h6 class="card-subtitle mb-2 text-muted"style="margin-left: 32px;">Topic : <b><%=re.getTopic(rs.getString("student_id"))%></b></h6>
                    <p class="card-text"style="margin-left: 32px;"><b><%=re.getName(rs.getString("student_idl"))%> Replied : </b><%=rs.getString("reply")%></p>
                </div>
            </div>
        </div>
    </div>
    <br>
    <%}}catch (Exception e){e.printStackTrace();}}%>
    <%
        if(request.getParameter("postQuestionButton1")!=null){
            try{
                con=new ConnectionProvider().getConnection();
                ps=con.prepareStatement("SELECT * FROM reply_table");
                rs=ps.executeQuery();
                while(rs.next()){
    %>
    <div class="row" style="width:100%">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title" style="margin-left: 32px;"><%=re.getName(rs.getString("student_id"))%> </h5>
                    <h6 class="card-subtitle mb-2 text-muted"style="margin-left: 32px;">Topic : <b><%=re.getTopic(rs.getString("student_id"))%></b></h6>
                    <p class="card-text"style="margin-left: 32px;"><b><%=re.getName(rs.getString("student_id"))%> Replied :</b><%=rs.getString("reply")%></p>
                </div>
            </div>
        </div>
    </div>
    <br>
    <%}}catch (Exception e){e.printStackTrace();}}%>
</main>
<style>
    .footer{
        position: fixed;
        left: 0;
        bottom: 0;
        width: 100%;
    }
</style>
<footer class="footer" style="background-color: #FFC200;">
    <div class="container">
        <span class="text-muted" style="text-color:black;">&copy;No Copyright Use it Well</span>
    </div>
</footer>
<!-- /.container -->
<!-- =========================================================Bootstrap core JavaScript================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>