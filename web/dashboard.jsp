<%--
  Created by IntelliJ IDEA.
  User: Himalay
  Date: 08-04-2018
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.User" %>
<%@ page import="java.sql.*"%>
<%@ page import="utility.ConnectionProvider"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <form action="DashboardServlet">
        <div class="row" style="width:100%;">
            <div class="col-9">
                <div class="card">
                    <div class="card-header">
                        Having Question
                        <select name="topic">
                            <option value="default">Topic</option>
                            <option value="java/Android">java/Android</option>
                            <option value="java EE" >java EE</option>
                            <option value="SQA" >SQA</option>
                            <option value="PHP" >PHP</option>
                        </select>
                    </div>
                    <div class="card-body" style="">
                        <h5 class="card-title">Ask A Question</h5>
                        <p class="card-text"></p>

                        <textarea name="question" rows="8" cols="60"></textarea>
                        <br>
                        <button type="submit" name="postQuestioButton" class="btn btn-primary">Post your question</button>

                        <!--</form>  -->
                    </div>
                </div>
            </div>
            <div class="col-3" style="float: right;">
                <div class="card" style="width: 20rem;">
                    <img class="card-img-top" src="https://www.yueimg.com/en/images/common/avatar.b6a87.png" alt="Card image cap" style="
          width:7rem;margin-left:100px;">
                    <ul class="list-group list-group-flush">
                        <%!
                            String name=null;
                            String reg_id=null;
                            String email=null;
                            User u;
                            Object valueOBJ;
                            Integer valueString=0;
                        %>
                        <%
                             //valueOBJ=request.getAttribute("value");
                             //valueString=Integer.valueOf((String)valueOBJ);
                            u=new User();
                            name=u.getname(request.getParameter("emauil_us"));
                            reg_id=User.getbeboId(request.getParameter("emauil_us"));
                            // name=User.getname(valueString);
                        %>
                        <li class="list-group-item"><input type="hidden" name="name" value="<%=name%>"><%=name%></li>
                        <li class="list-group-item" value=""><%=reg_id%></li>
                        <li class="list-group-item">Java/sqa/PHP</li>
                    </ul>
                </div>
            </div>
        </div>
    </form>
    <br>
    <%!
        private static Connection con;
        private static PreparedStatement ps;
        private static ResultSet rs;
    %>
    <%
        if(request.getParameter("postQuestioButton")==null){
            try{
                con= ConnectionProvider.getConnection();
                ps=con.prepareStatement("SELECT * FROM save_question ORDER BY question_id desc");
                rs=ps.executeQuery();
                while(rs.next()){
    %>
    <div class="row" style="width: 100%">
        <div class="col-9">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><%=rs.getString(4)%></h5>
                    <h6 class="card-subtitle mb-2 text-muted"><%=rs.getString(3)%></h6>
                    <p class="card-text">Q:<%=rs.getString(2)%></p>
                    <a href="#"  type="button" class="btn btn-primary">upvote</a>
                    <a href="#" type="button" class="btn btn-primary">Reply</a>
                </div>
            </div>
        </div>
    </div>
    <br>
    <%
                }}catch (Exception e){e.printStackTrace();}}
    %>
    <%
        if(request.getParameter("postQuestioButton")!=null){
            try{
                con= ConnectionProvider.getConnection();
                ps=con.prepareStatement("SELECT question,topic,Name AS date FROM save_question ORDER BY date ASC");
                rs=ps.executeQuery();
                while(rs.next()){
    %>
    <div class="row" style="width: 100%">
        <div class="col-9">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><%=rs.getString(3)%></h5>
                    <h6 class="card-subtitle mb-2 text-muted"><%=rs.getString(2)%></h6>
                    <p class="card-text">Q:<%=rs.getString(1)%></p>
                    <a href="#"  type="button" class="btn btn-primary">upvote</a>
                    <a href="#" type="button" class="btn btn-primary">Reply</a>
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