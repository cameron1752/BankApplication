
<jsp:useBean id="LoginManager" class="com.javaBeans.LoginManager" scope="session"/>

<%-- 
    Document   : landing
    Created on : Oct 4, 2020, 12:22:30 PM
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
        
    <%
        //LoginManager.setEmail("camks12@gmail.com");
        //LoginManager.setPassword("testPassword");
        boolean flag = LoginManager.getValidate();
        if(flag == true){
            
        } else{
            String redirectURL = "login.jsp";
            response.sendRedirect(redirectURL);
        }
//        
       %>
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
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown1"> <a class="dropdown-item" href="newAccount.jsp">New Account</a> <a class="dropdown-item" href="#">Edit Account</a>
	          <a class="dropdown-item" href="#">Delete Account</a> </div>
          </li>
	      
        </ul>
	    <form class="form-inline my-2 my-lg-0" action="login.jsp">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit" action="login.jsp">Logout</button>
            </form>
      </div>
  </nav>
        
        <div class="jumbotron">            
            <h1 class="display-4">Hello, <jsp:getProperty name="LoginManager" property = "FName"/>!</h1>
            
	    <p class="lead">Welcome to your account home page! Take a look around to see all the features you can use</p>
        </div>
        
        
	<div class="container-fluid">
	  <ul id="clothingnav1" class="nav nav-tabs" role="tablist">
	    <li class="nav-item"> <a class="nav-link active" href="#home1" id="hometab1" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">Accounts</a> </li>
	    <li class="nav-item"> <a class="nav-link" href="#paneTwo1" role="tab" id="hatstab1" data-toggle="tab" aria-controls="hats">Transfers</a> </li>
		  <li class="nav-item"> <a class="nav-link" href="#paneTwo2" role="tab" id="hatstab2" data-toggle="tab" aria-controls="hats">Deposit</a> </li>
		  <li class="nav-item"> <a class="nav-link" href="#paneTwo3" role="tab" id="hatstab3" data-toggle="tab" aria-controls="hats">Transactions</a> </li>

      </ul>
	  <!-- Content Panel -->
        <div id="clothingnavcontent1" class="tab-content">
            <!--accounts tab-->
	    <div role="tabpanel" class="tab-pane fade show active" id="home1" aria-labelledby="hometab1">
                <div>
                   <jsp:getProperty name="LoginManager" property="account"/>
                </div>
            </div> <!--end accounts tab-->
            
            <!--transfer tab-->
	    <div role="tabpanel" class="tab-pane fade" id="paneTwo1" aria-labelledby="hatstab1">
                <form action="transferPage.jsp">
                    <label for="accounts">Choose an account to transfer from:</label>
                    <select name="account1" id="account1">
                        <jsp:getProperty name="LoginManager" property="accounts"/>
                    </select><br>
                    <label for="accounts">Choose an account to transfer into:</label>
                    <select name="account2" id="account2">
                        <jsp:getProperty name="LoginManager" property="accounts"/>
                    </select>
                    <input type="hidden" name="email" type="text" value=<jsp:getProperty name="LoginManager" property="email"/> >
                    <input type="hidden" name="password" type="text" value=<jsp:getProperty name="LoginManager" property="password"/> >
                    <br>
                    <label for="amount">Enter in an amount to transfer:</label>
                    <input name="amount" type="text"> <br>
                    <input type="submit">
                    <input type="reset">
                </form>
            </div> <!--end transfer tab-->
            
            <!--deposit tab-->
            <div role="tabpanel" class="tab-pane fade" id="paneTwo2" aria-labelledby="hatstab2">
                <form action="despositPage.jsp">
                    <label for="accounts">Choose an account to deposit into:</label>
                    <select name="accounts" id="accounts">
                       <jsp:getProperty name="LoginManager" property="accounts"/>
                    </select> <br>
                    <input type="hidden" name="email" type="text" value=<jsp:getProperty name="LoginManager" property="email"/> >
                    <input type="hidden" name="password" type="text" value=<jsp:getProperty name="LoginManager" property="password"/> >
                    <label for="amount">Amount of Deposit:</label>
                    <input name="amount" type="text"> <br>

                    <label for="date">Date of Deposit:</label>
                    <input name="date" type="text"> <br>

                    <label for="file">Upload Image of Deposit:</label>
                    <input name="file" type="file"> <br>

                    <input type="submit" action="despositPage.jsp" name="depButton" value="submit">
                    <input type="reset">
                </form>
            </div>  <!--end deposit tab-->
            
            <!--transactions tab-->
            <div role="tabpanel" class="tab-pane fade" id="paneTwo3" aria-labelledby="hatstab3">
                <form>
                    <jsp:getProperty name="LoginManager" property="transactions"/>
                </form>
            </div>  <!--end transactions tab-->
        </div>
  </div>
    <script src="${pageContext.request.contextPath}/js/bootstrap-4.4.1.js"></script>
  </body>
</html>
