<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="header.jsp">
<c:param name="title" value="All post"></c:param>
</c:import>

<div class="container rounded bg-white mt-5 mb-5">
    <div class="row">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold">Edogaru</span><span class="text-black-50">edogaru@mail.com.my</span><span> </span></div>
        	<div class="row mt-2">
        		<div class="col-md-12 border-bottom tabOption"><p>Information</p> </div>
        		<div class="col-md-12 border-bottom tabOption"><p>Post</p> </div>
        		<div class="col-md-12 border-bottom tabOption"><p>Comment</p> </div>
        	</div>
        </div>
        
        <div class="col-md-9">
        <div class="row">
        <div class="col-md-12 align-items-center text-center createpost">
        <button class="btn btn-success my-2 my-sm-0">Create new post</button>
        </div>
        
        </div>
        <div class="border-bottom text-black-50">
            	<a href="#" class="titlepost ">7 " Luật rừng" sai bét nhè khi chơi Uno</a>
            	<div><span class="text-black-50">10-10-2021</span></div>
        </div>
        
          
    </div>
    </div>
          
    </div>
</body>
</html>