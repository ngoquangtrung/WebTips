<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<form action="/GameRule/UpdatePostCtrl" method="post" enctype="multipart/form-data">    
<div class="row">
         <div class="col-md-12">
         	<div>
         	<select name="category">
         	<option value="1">Broadgame</option>
         	
         	<option value="2">Vận động</option>
         	
         	<option value="3">Dân gian</option>
         	</select>
         	</div>
	       	 <div><label class="font-weight-bold">Title</label></div>
	         <div><textarea class="editcontent" name ="titlepost">${currentpost.getTitle()}</textarea></div>
         
	         <div><label class="font-weight-bold">Src Thumnail</label></div>
	         <div><p class="editcontent">${currentpost.getSrc()}</p></div>
	         <img alt="" src="${currentpost.getSrc()}" class="img-fluid img-thumbnail">
	         <input type="file" name="img_thumbnail">
         
	         <div><label class="font-weight-bold">Summary</label></div>
	         <div><textarea rows="5" cols="40" class="editcontent" name="summary">${currentpost.getSummary()}</textarea></div>
	        
        	<c:forEach var="i" items="${listpart}">        	
        	<div><label class="font-weight-bold">Part</label></div>
        	<div><label class="font-weight-bold">Image</label></div>
        	<input type="file" name="img_${i.getId_part()}">
        	<div><label class="font-weight-bold">Title</label></div>
        	 <div><textarea class="editcontent" name="title_"${i.getId_part()}>${i.getTitle()}</textarea></div>
        	 <div><label class="font-weight-bold">Content</label></div>
        	<div><textarea class="editcontent" name="content_"${i.getId_part()}>${i. getContent()}</textarea></div>      
        	</c:forEach>
          	
        </div>
        <script type="text/javascript">
         alert("Không có bài viết nào để hiển thị")
        </script>
        
        </div>
<div class="row">
	<div class="col-md-8"></div>
		<div class="col-md-2 align-items-center text-center"> <button type="submit" class="btn btn-success btnsetup">Update</button></div>
	  	<div class="col-md-2 align-items-center text-center"> <button type="button" class="btn btn-danger btnsetup" id="btn_deletePost">Delete </button></div>
	  
        
</div>
</form>