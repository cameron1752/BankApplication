<jsp:useBean id="AccountCreate" class="com.javaBeans.AccountCreate" />
<%-- 
    Document   : newAccount
    Created on : Oct 15, 2020, 7:43:21 PM
    Author     : cammy
--%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>New User</title>
    <!-- Bootstrap -->
        <link href="${pageContext.request.contextPath}/css/bootstrap-4.4.1.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
	
  </head>
  <body>
  	<!-- body code goes here -->
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
    
        
        <jsp:setProperty name="AccountCreate" property="FName" param="fName"/>
        <jsp:setProperty name="AccountCreate" property="LName" param="lName"/>
        <jsp:setProperty name="AccountCreate" property="email" param="email"/>
        <jsp:setProperty name="AccountCreate" property="password" param="password"/>
        
        <% 
            AccountCreate.setNewAccount();
    
            AccountCreate.createUser();
        %>
        
        <p> Welcome to our bank <jsp:getProperty name="AccountCreate" property = "FName"/>! </p> <br>
        
        <form class="form-inline my-2 my-lg-0" action="login.jsp">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</button>
        </form>
     </div>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script> 
  <script src="${pageContext.request.contextPath}/js/bootstrap-4.4.1.js"></script>
  </body>
</html>