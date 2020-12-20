<jsp:useBean id="LoginManager" class="com.javaBeans.LoginManager" scope="session"/>
<%-- 
    Document   : despositPage
    Created on : Oct 16, 2020, 12:20:27 PM
    Author     : cammy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Your Bank</title>
    <!-- Bootstrap -->
	<link href="${pageContext.request.contextPath}/css/bootstrap-4.4.1.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

  </head>
  <body>
      <!-- body code goes here -->
        <jsp:setProperty name="LoginManager" property="email" param="email"/>
        <jsp:setProperty name="LoginManager" property="password" param="password"/>
        <jsp:setProperty name="LoginManager" property="accountSelected" param="accounts"/>
        <jsp:setProperty name="LoginManager" property="amount" param="amount"/>
        
    <%
        //LoginManager.setEmail("camks12@gmail.com");
        //LoginManager.setPassword("testPassword");
        boolean flag = LoginManager.getValidate();
        if(flag == true){
            LoginManager.makeDeposit();
        } else{
            String redirectURL = "login.jsp";
            response.sendRedirect(redirectURL);
        }
//        
       %>
  	<!-- body code goes here -->


   
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
	<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>

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
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit" action="login.jsp">Logout</button>
            </form>
      </div>
  </nav>
        
        <div class="card col-md-4 offset-xl-4">
        <div class="card-body">
            <form action="landing.jsp">
                <p> Successful deposit of <jsp:getProperty name="LoginManager" property="amount"/> into <jsp:getProperty name="LoginManager" property="accountSelected"/> <jsp:getProperty name="LoginManager" property="FName"/>!
            
                <input type="hidden" name="email" type="text" value=<jsp:getProperty name="LoginManager" property="email"/> >
                <input type="hidden" name="password" type="text" value=<jsp:getProperty name="LoginManager" property="password"/> > <br>
                <input type="submit" action="landing.jsp" name="home" value="Return Home">
            </form>    
        </div>
        </div>
	
  
<script src="${pageContext.request.contextPath}/js/bootstrap-4.4.1.js"></script>
  </body>
</html>
