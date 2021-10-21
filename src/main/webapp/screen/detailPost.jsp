<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<div class="row">
         <div class="col-md-12">
	       	 <div><label class="font-weight-bold">Title</label></div>
	         <div><textarea class="editcontent">${currentpost.getTitle()}</textarea></div>
         
	         <div><label class="font-weight-bold">Src Thumnail</label></div>
	         <div><textarea rows="1" class="editcontent">${currentpost.getSrc()}</textarea></div>
	         <input type="file" name="img_thumbnail">
         
	         <div><label class="font-weight-bold">Summary</label></div>
	         <div><textarea rows="5" cols="40" class="editcontent" >${currentpost.getContent()}</textarea></div>
	        
        	<c:forEach var="i" items="${listpart}">        	
        	<div><label class="font-weight-bold">Part</label></div>
        	<div><textarea rows="1" class="editcontent">${i.getSrc_image()}</textarea></div>
        	<input type="file" name="img_part${i.getId_part()}">
        	 <div><textarea class="editcontent">${i.getTitle()}</textarea></div>
        	<div><textarea class="editcontent">${i. getContent()}</textarea></div>      
        	</c:forEach>
          	
        </div>
        
        </div>
<div class="row">
	<div class="col-md-8"></div>
		<div class="col-md-2 align-items-center text-center"> <button type="button" class="btn btn-success btnsetup">Update</button></div>
	  	<div class="col-md-2 align-items-center text-center"> <button type="button" class="btn btn-danger btnsetup">Delete</button></div>
	  
        
</div>