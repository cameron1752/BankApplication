<jsp:useBean id="LoginManager" class="com.javaBeans.LoginManager" scope="session"/>
<%-- 
    Document   : login
    Created on : Oct 4, 2020, 4:33:17 PM
    Author     : cammy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Bank</title>
        <!-- Bootstrap -->
	<link href="${pageContext.request.contextPath}/css/bootstrap-4.4.1.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    </head>
    <body>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
	<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
        <jsp:setProperty name="LoginManager" property="email" param="email"/>
        <jsp:setProperty name="LoginManager" property="password" param="password"/>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script> 
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a class="navbar-brand" href="#">Your Bank</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent1" aria-controls="navbarSupportedContent1" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent1">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item active"> <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a> </li>
                <li class="nav-item"> <a class="nav-link" href="#">Contact Us</a> </li>
                <li class="nav-item dropdown"> <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Services </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown1"> <a class="dropdown-item" href="#">New Account</a> <a class="dropdown-item" href="#">Edit Account</a>
                    <a class="dropdown-item" href="#">Delete Account</a> </div>
                </li>

              </ul>
                  <form class="form-inline my-2 my-lg-0" action="login.jsp">
                      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</button>
                  </form>
            </div>
        </nav>
        
        <div class="card col-md-4 offset-xl-4">
        <div class="card-body">
            <form action="landing.jsp">
                <h5 class="card-title">Login <jsp:getProperty name="LoginManager" property = "message"/></h5>
                <input type="text" name="email"><br>
                <input type="password" name="password"><br>
                <input type="submit" value="login"> <br>
                <a href="newAccount.jsp">Create Account</a>  <a href="#"> Forgot Password </a>
            </form>
        </div>
    </body>
</html>
