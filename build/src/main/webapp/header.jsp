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
<link rel="stylesheet" href="css/footer.css">

<title>${param.title}</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
  <a class="navbar-brand" href="#">Main</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/GameRule/">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle"  href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Category
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/GameRule/PostController?category=broadgame">BroadGame</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="/GameRule/PostController?category=vandong">V???n ?????ng</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="/GameRule/PostController?category=dangian">Tr??? ch??i d??n gian</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">About</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" method="post" action="/GameRule/">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
    <ul class="navbar-nav">
    	<li class="nav-item dropdown mr-auto">
        <a class="nav-link dropdown-toggle"  href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
          Account
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
          
          
          <c:set var="username" value="${currentuser.getName()}"></c:set>
          <c:set var="permission" value="${currentuser.getPermission() }"></c:set>
          <c:if test="${username!=null }">
          <c:if test="${permission==0 }">
          <a class="dropdown-item" href="/GameRule/user.jsp">${username}</a>
          </c:if>
          <c:if test="${permission==1 }">
          <a class="dropdown-item" href="/GameRule/adminuser.jsp">${username}</a>
          </c:if>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="/GameRule/LogOutServlet">Logout </a>
          </c:if>          
			<c:if test="${username==null }">
			<a class="dropdown-item" href="/GameRule/CheckCookie">Login </a>
			<div class="dropdown-divider"></div>
			</c:if>
          
          
        </div>
      </li>
    </ul>
    
  </div>
  
</nav>