<%--
  Created by IntelliJ IDEA.
  User: Himalay
  Date: 26-04-2018
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Notice</title>
    <style type="text/css">
        .boxed {
            border: 1px solid green ;
        }
    </style>
</head>
<body>

<form action="mail.jsp">


    <p><b>Select the Category</b></p>
    <select  name="Categories" onchange="this.form.submit()">
        <option value="select">Select Category</option>

        <option value="course">Course</option>

    </select>
</form>
<form>
    <select name="SubCategories" onchange="this.form.submit()">
    </select>
    <input type="hidden" name="search" value="<%--=search--%>"/>

</form>
<form action="mail_sender.jsp">
    <div>
        <br>
        <b>To:</b>
        <input type="text" name="emails" value="<%=emails%>">
        <br>
    </div>

    <div>
        <br>
        <b>From:</b>
        <input type="text" name="from">
        <br>
    </div>

    <div>
        <br>
        <b>Subject:</b>
        <input type="text" name="sub">
    </div>
    <br>

    <div>
        <b>Body:</b>
        <br>
        <textarea  rows="8" cols="100" name="msg" placeholder="Enter your message here......"></textarea>
        <br>
    </div>

    <div>
        <br><br>
        <input type="submit" name="Send" value="send" onclick="showAlert()">

        <br>
    </div>
</form>
</body>
</html>