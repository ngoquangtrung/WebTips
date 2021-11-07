<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="header.jsp">
<c:param name="title" value="Account manager"></c:param>
</c:import>

<div class="container rounded bg-white mt-5 mb-5">
    <div class="row">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold">Edogaru</span><span class="text-black-50">${currentuser.getEmail()}</span><span> </span></div>
        	<div class="row mt-2">
        		<div class="col-md-12 border-bottom tabOption"  onclick="infoUser()"><p>Information</p> </div>
        		<div class="col-md-12 border-bottom tabOption" onclick="listPost()"><p>Post</p> </div>
        		<div class="col-md-12 border-bottom tabOption"><p>Comment</p> </div>
        		<div class="col-md-12 border-bottom tabOption" onclick="screenuser()"><p>List user</p></div>
        		<div class="col-md-12 border-bottom tabOption" onclick="listPostRequest()"><p>List post request</p> </div>
        	</div>
        </div>
        
        
        <div class="col-md-9 border-right" id="replace">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">Profile Settings</h4>
                </div>
                <form action="/GameRule/userCtrl" method="post">
                
                <div class="row mt-2">
                    <div class="col-md-12"><label class="labels">Name</label><input type="text" class="form-control" placeholder="first name" value="${currentuser.getName() }" name="nameuser"></div>
                </div>
                <div class="row mt-3">
                    <div class="col-md-12"><label class="labels">Pass Word</label><input type="password" class="form-control" placeholder="Pass Word" value="" name="password"></div>
                    <div class="col-md-12"><label class="labels">Re-Pass Word</label><input type="password" class="form-control" placeholder="Pass Word" value="" name="repassword">
                    <span class="alert-danger" role="alert">${passerror}</span>
                    </div>
                    
                    <div class="col-md-12"><label class="labels">Birthday</label><input type="date" class="form-control" value="${currentuser.getBirthday() }" name="birthday"></div>
                    <div class="col-md-12"><label class="labels">Gender</label>
						
						<c:set var="usergender" value="${currentuser.getGender() }"></c:set>
						<select class="form-control" name="genderuser">
						<c:choose>						
						
  						<c:when test="${usergender==1 }">
							<option selected="selected" value="1">Male </option>
							<option value="0">Female </option>
							<option value="3">Another </option>
  						</c:when>
  						
  						<c:when test="${usergender==0 }">
							<option value="1" >Male </option>
							<option selected="selected" value="0">Female </option>
							<option value="3">Another </option>
 					 	</c:when>
 					 	
  						<c:when test="${usergender==3 }">
							<option value="1">Male </option>
							<option value="0">Female </option>
							<option selected="selected" value="3">Another </option>
 					 	</c:when>
 					 	 					 	
						</c:choose>	
						</select> 					
					</div>
                    
                </div>
                <div class="row mt-3">
                    <div class="col-md-6"><label class="labels">Country</label><input type="text" class="form-control" placeholder="country" value=""></div>
                    <div class="col-md-6"><label class="labels">State/Region</label><input type="text" class="form-control" value="" placeholder="state"></div>
                </div>
                <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit">Save Profile</button></div>
                
                </form>
            </div>
        </div>        
    </div>
</div>
</body>
</html>