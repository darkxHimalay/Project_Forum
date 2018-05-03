<%--
  Created by IntelliJ IDEA.
  User: Himalay
  Date: 29-04-2018
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="model.AdminPageClass" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="utility.ConnectionProvider" %>
<%@ page import="model.Upvote" %>
<%@ page import="model.User" %>
<%!
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- <meta name="description" content="Binary Pack">
     <meta name="author" content="Binary Pack Ltd.">-->
    <link rel="icon" href="img/favicon.ico">
    <title>Adminstator</title>

    <!-- CSS libraries-->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome/css/font-awesome.min.css" rel="stylesheet">

    <!-- Google fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">

    <!-- Custom stylesheet -->
    <link href="css/main.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div id="wrapper">
    <!-- Sidebar -->
    <form action="adminPage.jsp">
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4Iz2mR-W6WAFZlndCmCEiCMMHF-bdHh02uNlkfk9wf_nu8HOD4Q" class="logo" alt="Logo"/>
                    </a>
                </li>
                <li>
                    <button type="submit" style="padding: 0;border: none;background: none; color: whitesmoke" name="dashboard"><i class="fa fa-dashboard"></i> Dashboard</button>
                </li>
                <li>
                    <button type="submit" style="padding: 0;border: none;background: none; color: whitesmoke" name="deleteButton"><i class="fa fa-book"></i> Delete Queries </button>
                </li>
                <li>
                    <button type="submit" style="padding: 0;border: none;background: none; color: whitesmoke" name="mailForm"><i class="fa fa-file-text"></i> Send Mail </button>
                </li>
                <li>
                    <button type="submit" style="padding: 0;border: none;background: none; color: whitesmoke" name="AdminForm"><i class="fa fa-female"></i> Add a Admin </button>
                </li>
                <li>
                    <button type="submit" style="padding: 0;border: none;background: none; color: whitesmoke"><i class="fa fa-foursquare"></i> Forum</button>
                </li>
                <li>
                    <button type="submit" style="padding: 0;border: none;background: none; color: whitesmoke"><i class="fa fa-support"></i> Support</button>
                </li>
                <li>
                    <button type="submit" style="padding: 0;border: none;background: none; color: whitesmoke"><i class="fa fa-signal"></i> Settings</button>
                </li>
            </ul>

        </div>
    </form>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <button href="#menu-toggle" class="wrapper_toggle_btn" id="menu-toggle">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <div class="clearfix"></div>
        <!-- Header -->
        <div class="header">
            <!--<div class="clearfix"></div>-->
            <div class="row">
                <form action="adminPage.jsp">
                <div class="col-lg-6 visible-lg visible-md">
                    <div class="search_bar">
                        <div class="input-group search_bar_input">
                            <span class="input-group-addon">
                                <button type="submit">
                                    <span class="fa fa-search"></span>
                                </button>
                            </span>
                            <input type="text" class="form-control"  placeholder="Search..." >
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="pull-left">
                        <button type="Submit" class="btn btn-group btn-group-justified bg-primary">Search</button>
                    </div>

                    <div class="pull-right">
                        <div class="profile-overview">
                            <div class="dropdown customm-dropdown">
                                <img src="img/IMG_20180317_162034.jpg" class="profile-pic" alt="Avatar"/>
                                <button class="btn dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                    E-Tech Forum Admin
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
                                    <li><a href="index.jsp"><i class="fa fa-user"></i> E-tech Login</a></li>
                                    <li><a href="#"><i class="fa fa-wrench"></i> Setting</a></li>
                                    <li><a href="admin.jsp"><i class="fa fa-power-off"></i> Logout</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!--<div class="clearfix"></div>-->
                </div>
                </form>
            </div>
        </div>
        <!-- /#header -->
        <%!
            AdminPageClass adPgCl;
            int i=0;
            int j=0;
            int k=0;
            int l=0;
            String topicValue;
            Upvote upvote;
        %><%
        upvote=new Upvote();
        adPgCl=new AdminPageClass();
        i=adPgCl.countQueries();
        j=adPgCl.countRegisteredUser();
        k=adPgCl.countQueriesAnswered();
        l=upvote.countTotalUpvotes();
    %>

        <!-- Content area -->
        <div class="container-fluid">
            <div class="content-area">
                <!-- content overview -->
                <div class="row">
                    <div class="col-lg-3">
                        <!-- Single block -->
                        <div class="overview-block">
                            <!--<div class="overview-left pull-left">
                                <div class="overview-icon">
                                    <i class="fa fa-pie-chart"></i>
                                </div>
                            </div>-->
                            <div class="overview-right pull-left">
                                <h4 class="overview-value"><%=i%></h4>
                                <span class="overview-title">Total Queries</span>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>

                    <div class="col-lg-3">
                        <!-- Single block -->
                        <div class="overview-block">
                            <!--<div class="overview-left pull-left">
                                <div class="overview-icon">
                                    <i class="fa fa-bar-chart"></i>
                                </div>
                            </div>-->
                            <div class="overview-right pull-left">
                                <h4 class="overview-value"><%=j%></h4>
                                <span class="overview-title">Total Users</span>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>

                    <div class="col-lg-3">
                        <!-- Single block -->
                        <div class="overview-block">
                            <!--<div class="overview-left pull-left">
                                <div class="overview-icon">
                                    <i class="fa fa-bullhorn"></i>
                                </div>
                            </div>-->
                            <div class="overview-right pull-left">
                                <h4 class="overview-value"><%=k%></h4>
                                <span class="overview-title">Total Replies</span>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>

                    <div class="col-lg-3">
                        <!-- Single block -->
                        <div class="overview-block">
                            <!-- <div class="overview-left pull-left">
                                 <div class="overview-icon">
                                     <i class="fa fa-briefcase"></i>
                                 </div>
                             </div>-->
                            <div class="overview-right pull-left">
                                <h4 class="overview-value"><%=l%></h4>
                                <span class="overview-title">Total Upvotes</span>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
                <!--   For delete  -->
                <% if (request.getParameter("deleteButton")!=null){%>
                <!--<form action="AdminServlet.jsp">-->
                <div id="DeletePart">
                    <form name="myform" action="adminPage.jsp">
                        <h4 class="overview-value"><span> Delete a Query </span></h4>
                        Select Topic <select name="topic" onchange=myform.submit()>
                        <option value="java"> Topic </option>
                        <option value="java EE"> Java EE </option>
                        <option value="java/Android"> Java\Android </option>
                        <option value="PHP"> Php </option>
                        <option value="SQA"> Sqa </option>
                    </select></form>

                    <%}
                        if(request.getParameter("topic")!=null){
                                try{
                                    con= new ConnectionProvider().getConnection();
                                    ps=con.prepareStatement("select * from save_question where topic=?");
                                    ps.setString(1,request.getParameter("topic"));
                                    rs=ps.executeQuery();
                                    while(rs.next()){
                    %>


                    <div class="row ">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <!--<div class="panel-heading">
                                    <h3 class="panel-title">Recent Visitor</h3>
                                </div>-->
                                <div class="panel-body">
                                    <h4>Question :<%=rs.getString("question")%></h4>
                                    <form action="AdminServlet"> <input type="hidden" name="DeleteQuestion_id" value="<%=rs.getString("question_id")%>">
                                        <div class="pull-right">
                                            <button type="submit" name="deleteQueryButton" class="btn btn-group bg-primary">Delete</button>
                                            <button type="submit" name="showQueryRepliesButton" class="btn btn-group bg-primary">Show Replies</button>
                                            <input  type="hidden" name="question_id" value="<%=rs.getString("question_id")%>">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div><%}}catch (Exception e){e.printStackTrace();}}%>
                </div>
                <div id="DeletePart">
                    <%
                        if(request.getParameter("showQueryRepliesButton")!=null){
                        try{
                        con= new ConnectionProvider().getConnection();
                        ps=con.prepareStatement("select * from reply_table where question_id=?");
                        ps.setString(1,request.getAttribute("question_id").toString());
                        rs=ps.executeQuery();
                        while(rs.next()){
                    %>
                    <div class="row ">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <h4><%=new User().getname(Integer.parseInt(rs.getString("student_idl")))%> : Replied :<%=rs.getString("reply")%></h4>
                                        <div class="pull-right">
                                            <form action="AdminServlet">
                                                <input type="hidden" name="reply_id" value="<%=rs.getString("reply_id")%>">
                                                <button type="submit" name="deleteReplyButton" class="btn btn-group bg-primary">Delete</button>
                                            </form>
                                        </div>
                                </div>
                            </div>
                        </div>
                    </div><%}}catch (Exception e){e.printStackTrace();}}%>
                </div>

                <!-- Compose Mail Form-->
                <%if (request.getParameter("mailForm")!=null){%>
                <div class="container"><span><h4 class="overview-value"> Students who have asked Question from the topic
                    <form name="myform" action="adminPage.jsp"><select name="topic" onchange=myform.submit()>
                        <option value="java/Android"> Topic </option>
                        <option value="java EE"> Java EE </option>
                        <option value="java/Android"> Java\Android </option>
                        <option value="PHP"> Php </option>
                        <option value="SQA"> Sqa </option>
                    </select>
                    </form>
                    </h4></span>
                    <h4>Send An Email</h4>
                    <p></p>
                    <form action="AdminServlet">
                        <div class="form-group">
                            <label for="user">To:</label>
                            <input type="text" name="emails" class="form-control" id="user">
                        </div>
                        <div class="form-group">
                            <label for="pawd">Subject:</label>
                            <input type="text" name= "sub" class="form-control" id="pawd">
                        </div>
                        <div class="form-group">
                            <label for="asd">Message:</label>
                            <textarea rows="7"  name="msg" type="textarea" class="form-control" id="asd"></textarea>
                        </div>
                        <div class="form-group">
                            <br>
                            <button type="Submit" class="btn btn-group btn-group-justified bg-primary" name="sendButton">Send An Email</button>
                        </div>
                    </form>
                </div>
                <%} if(request.getParameter("AdminForm")!=null){%>
                <div class="container">
                    <h2>Form Add an Admin</h2>
                    <p>Enter the following fields to add an Admin</p>
                    <form action="AdminServlet">
                        <div class="form-group">
                            <label for="usr">ADMIN EMAIL ID:</label>
                            <input type="text" class="form-control" id="usr">
                        </div>
                        <div class="form-group">
                            <label for="pwd">Password:</label>
                            <input type="password" class="form-control" id="pwd">
                        </div>
                        <div class="form-group">
                            <br>
                            <button type="Submit" class="btn btn-group btn-group-justified bg-primary">Add an Admin</button>
                        </div>
                    </form>
                </div>

                <%}%>
            </div>
        </div>
        <!-- /#Content area -->

        <!-- Footer area -->
        <footer class="footer">
            <div class="container-fluid">
                <p class="copy-text"> No Copyright Use it well © 2018</p>
            </div>
        </footer>
        <!-- /#Footer area -->
    </div>
    <!-- /#page-content-wrapper -->
</div>
<!-- /#wrapper -->
<script src="js/jquery-2.2.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="js/ie10-viewport-bug-workaround.js"></script>
<!-- Custom javascript -->
<script src="js/theme.js"></script>
</body>
</html>