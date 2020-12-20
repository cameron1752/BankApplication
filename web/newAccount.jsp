<jsp:useBean id="AccountCreate" class="com.javaBeans.AccountCreate" />
<jsp:useBean id="LoginManager" class="com.javaBeans.LoginManager"  scope="session"/>
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
         <form class="offset-xl-3 col-xl-6" action="newAccountParam.jsp">
	     <div class="form-group offset-xl-0 col-xl-11">
	      <label for="exampleInputEmail1">First Name</label>
	      <input type="text" class="form-control" id="exampleInputEmail1" placeholder="<jsp:getProperty name="LoginManager" property="firstNameStuff"/>" name="fName">
	    </div>
		<div class="form-group offset-xl-0 col-xl-11">
	      <label for="exampleInputEmail1">Last Name</label>
	      <input type="text" class="form-control" id="exampleInputEmail1" placeholder="<jsp:getProperty name="LoginManager" property="lastNameStuff"/>" name="lName">
	    </div>
		<div class="form-group offset-xl-0 col-xl-11">
	      <label for="exampleInputEmail1">Email address</label>
	      <input type="email" class="form-control" id="exampleInputEmail1" placeholder="<jsp:getProperty name="LoginManager" property="emailStuff"/>" name="email">
		</div>
	    <div class="form-group offset-xl-0 col-xl-11">
	      <label for="exampleInputPassword1">Password</label>
	      <input type="password" class="form-control" id="exampleInputPassword1" placeholder="<jsp:getProperty name="LoginManager" property="passwordStuff"/>" name="password">
      </div>
	    <div class="form-check offset-xl-0 col-xl-11">
	      <input type="checkbox" class="form-check-input" id="exampleCheck1">
	      <label class="form-check-label" for="exampleCheck1">Check me out</label>
      </div>
	    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
     </div>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script> 
  <script src="${pageContext.request.contextPath}/js/bootstrap-4.4.1.js"></script>
  </body>
</html>