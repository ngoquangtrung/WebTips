<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="utf-8">
<link rel="stylesheet" href="styleweb.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Register</title>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card border-0 shadow rounded-3 my-5">
          <div class="card-body p-4 p-sm-5">
            <h5 class="card-title text-center mb-5 fw-light fs-5">Sign Up</h5>
            
            <form action="/GameRule/RegisterController" method="post" id="form_register">
              <div class="form-floating mb-3">
               <label for="floatingInput">Email address</label>
                <input type="email" class="form-control" id="email" placeholder="name@example.com" name="email" required> 
                <span class="alert-danger" role="alert">${emailerror}</span>             
                </div>
              
              <div class="form-floating mb-3">
              <label for="floatingPassword">Password</label>
                <input type="password" class="form-control" id="password" placeholder="Password" name="pass" required>                
              </div>
              
              <div class="form-floating mb-3">
              <label for="floatingPassword">Repassword</label>
                <input type="password" class="form-control" id="password" placeholder="Re-Password" name="repass" required> 
                <span class="alert-danger" role="alert">${passerror}</span>
              </div>
              
              <div class="form-floating mb-3">
              <label for="floatingPassword">Name</label>
                <input type="text" class="form-control" id="password"  name="name" required>                
              </div>
              
              <div class="form-floating mb-3">
              <label for="floatingPassword">Birth day</label>
                <input type="date" class="form-control" id="password"  name="birthday">                
              </div>
              
              <div class="form-floating mb-3">
              <label for="floatingPassword">Gender</label>
                <select class="form-control" id="password" name="gender">
                <option>Male</option>
                <option>Female</option>
                <option>Another</option>
                </select>
              </div>

             
              <div class="d-grid">
                <button class="btn btn-primary btn-login text-uppercase fw-bold" type="submit">Sign up</button>
              </div>
              <hr class="my-4">
              <div class="d-grid mb-2">
                <button class="btn btn-google btn-login text-uppercase fw-bold" type="submit">
                  <i class="fab fa-google me-2"></i> Sign Up with Google </button>
              </div>
              <div class="d-grid">
                <button class="btn btn-facebook btn-login text-uppercase fw-bold" type="submit">
                  <i class="fab fa-facebook-f me-2"></i> Sign Up with Facebook
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