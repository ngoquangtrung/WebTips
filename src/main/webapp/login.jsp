<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="js/script.js"></script>
<meta charset="utf-8">
<link rel="stylesheet" href="css/styleweb.css">
<link rel="stylesheet" href="css/styleuser.css">

<title>Login</title>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card border-0 shadow rounded-3 my-5">
          <div class="card-body p-4 p-sm-5">
            <h5 class="card-title text-center mb-5 fw-light fs-5">Sign In</h5>
            <form action="/GameRule/LoginServlet" method="post">
              <div class="form-floating mb-3">
               <label for="floatingInput">Email address</label>
                <input type="email" class="form-control" id="email" placeholder="name@example.com" name="email" required>
               
              </div>
              <div class="form-floating mb-3">
              <label for="floatingPassword">Password</label>
                <input type="password" class="form-control" id="password" placeholder="Password" name="pass"required>
                
              </div>
              
              <div class="alert-danger" role="alert">${loginerror}</div>

              <div class="form-check mb-3">
                <input class="form-check-input" type="checkbox" value="" id="rememberPasswordCheck" name="remember">
                <label class="form-check-label" for="rememberPasswordCheck" >
                  Remember password
                </label>
              </div>
              
              <div class="d-grid">
                <button class="btn btn-primary btn-login text-uppercase fw-bold" type="submit">Sign
                  in</button>
              </div>
              
              <div><p>Not have a account, <a href="http://localhost:8080/GameRule/register.jsp"> Register</a></p></div>
              <hr class="my-4">
              <div class="d-grid mb-2">
                <p class="btn btn-google btn-login text-uppercase fw-bold" >
                  <i class="fab fa-google me-2"></i> <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/GameRule/login-google&response_type=code
    &client_id=290818297744-pdh2mp1jckhb4bk82218kpc7s7g4i60k.apps.googleusercontent.com&approval_prompt=force">Sign in with Google</a>
                </p>
              </div>
              <div class="d-grid">
                <button class="btn btn-facebook btn-login text-uppercase fw-bold" type="button">
                  <i class="fab fa-facebook-f me-2"></i> Sign in with Facebook
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>

</html>