<%--
  Created by IntelliJ IDEA.
  User: Himalay
  Date: 08-04-2018
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<style>
    * { -moz-box-sizing: border-box;
        box-sizing: border-box; }
    body {  background: #809cff;
        font-family: "Comic Sans MS", cursive, sans-serif;
        background: url(http://idolza.com/a/f/d/design-hd-wallpaper-wood-background_cool-designs-wallpaper_christmas-decor-photos-bathroom-decoration-ideas-home-trends-2014-ceiling-canopy-for-bed-modern-bedside-lamps-black-furnitur.jpg);
    }
    .Title {
        text-align: center;
        margin-left: 0;
        margin-right: 0;
    }
    .tag-line {
        text-align: center;
        /*position:center;
    left:0;
    right:0;*/
        margin-left: 0;
        margin-right: 0;
        font-color: white;
    }
    .text-center p-t-12 {
        position: relative;
        right: 30rem;
    }
    .txt2 {
        font-family: "Comic Sans MS", cursive, sans-serif;
        font-size: 15px;
        position: relative;
        left: 30px;
        top: 112px;
        line-height: 1.5;
        color: #944f38;
    }
    .login {
        position: absolute;
        top: 50%;
        left: 50%;
        margin: -10rem 0 0 -10rem;
        width: 20rem;
        height: 20rem;
        padding: 20px;
        background: white;
        border-radius: 5px;
        overflow: hidden;
    }
    .login:hover>.login-header, .login.focused>.login-header {
        width: 2rem;
    }
    .login:hover>.login-header>.text, .login.focused>.login-header>.text {
        font-size: 0.6rem;
        transform: rotate(-90deg);
    }
    .login.loading>.login-header {
        width: 20rem;
    }
    .login.loading>.login-header>.text {
        display: none;
    }
    .login.loading>.login-header>.loader {
        display: block;
    }
    .login-header {
        position: absolute;
        left: 0;
        top: 0;
        z-index: 1;
        width: 20rem;
        height: 20rem;
        background-color: #944f38;
        transition: width 0.5s ease-in-out;
    }
    .login-header>.text {
        display: block;
        width: 100%;
        height: 100%;
        font-size: 40px;
        text-align: center;
        line-height: 20rem;
        color: #fff;
        transition: all 0.5s ease-in-out;
    }
    .login-header>.loader {
        display: none;
        position: absolute;
        left: 5rem;
        top: 5rem;
        width: 10rem;
        height: 10rem;
        border: 2px solid #fff;
        border-radius: 50%;
        animation: loading 2s linear infinite;
    }
    .login-header>.loader:after {
        content: "";
        position: absolute;
        left: 4.5rem;
        top: -0.5rem;
        width: 1rem;
        height: 1rem;
        background: #fff;
        border-radius: 50%;
        border-right: 2px saddlebrown;
    }
    .login-header>.loader:before {
        content: "";
        position: absolute;
        left: 4rem;
        top: -0.5rem;
        width: 0;
        height: 0;
        border-right: 1rem solid #fff;
        border-top: 0.5rem #944f38;
        border-bottom: 0.5rem solid transparent;
    }
    @keyframes loading { 50%{opacity: 0.5;} 100%{transform:rotate(360deg);}}
    .login-form {
        margin: 0 0 0 2rem;
        padding: 0.5rem;
    }
    .login-input {
        display: block;
        width: 100%;
        font-size: 1.5rem;
        padding: 0.5rem 1rem;
        box-shadow: none;
        border-color: #ccc;
        border-width: 0 0 2px 0;
    }
    .login-input+.login-input {
        margin: 10px 0 0;
    }
    .login-input:focus {
        outline: none;
        border-bottom-color: #944f38;
    }
    .login-input:focus {
        outline: none;
        border-bottom-color: #944f38;
    }
    .login-btn {
        position: absolute;
        right: 1rem;
        bottom: 1rem;
        width: 5rem;
        height: 5rem;
        border: none;
        background: #944f38;
        /*border-radius:;*/
        font-size: 0;
        border: 0.6rem solid transparent;
        transition: all 0.3s ease-in-out;
    }
    .login-btn:after {
        content: "";
        position: absolute;
        left: 1rem;
        top: 0.8rem;
        width: 0;
        height: 0;
        border-left: 2.4rem solid #fff;
        border-top: 1.2rem solid transparent;
        border-bottom: 1.2rem solid transparent;
        transition: border 0.3s ease-in-out 0s;
    }
    .login-btn:hover, .login-btn:focus, .login-btn:active {
        background: #fff;
        border-color: #944f38;
        outline: none;
    }
    .login-btn:hover:after, .login-btn:focus:after, .login-btn:active:after
    {
        border-left-color: #944f38;
    }
</style>
<body>
<div class="Title">
    <h1><font color="white">E-tech Forum</font></h1>
</div>
<div class="tag-line">
    <h2><font color="white">where learning becomes Easy</font></h2>
</div>
<div class="login">
    <header class="login-header">
        <span class="text">E-tech Login</span><span class="loader"></span>
    </header>
    <form action="AdminDashboard.jsp" class='login-form' name="myform">
        <input class="login-input" type="text" name="admin_ID" placeholder=" Admin ID" />
        <input class="login-input" type="password" name="password" placeholder="Password" />
        <button class="login-btn" type="submit" name="login_Sign_in" value="login">Login</button>
    </form>
    <!--<div class="text-center p-t-12">
        <span class="txt1"><a class="txt2" href='http://localhost:8080/E-Tech_forum/signUp.html'>New User/Click_Here </a></span>
    </div>-->
</div>
</body>
</html>