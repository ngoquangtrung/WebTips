<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row" >
        <div class="col-md-12 align-items-center text-center createpost">
        <button class="btn btn-success my-2 my-sm-0" onclick="addPost()">Create new post</button>
        </div>
        
</div>
        <div class="row post-item" id="postid" onclick="detailPost()">
        <div class="col-md-3 post-item">
        <img alt="" src="https://static.thuthuatchoi.com/posts/images/board_game/uno/luat_rung_uno/luat%20choi%20Uno%20sai%20bet.jpg" class="img-fluid">
        </div>
        <div class=" col-md-9 border-bottom text-black-50">
            	<a href="#" class="titlepost ">7 " Luật rừng" sai bét nhè khi chơi Uno</a>
            	<div><span class="text-black-50">10-10-2021</span></div>
        </div>
        </div>
 <form action="/GameRule/UpdatePostCtrl" method="get" id="fromlistpost" onsubmit="return confirmdelete()">      
<c:forEach var="i" items="${listuser}">
<div class="row post-item" id="${i.getId_post()}">
        <div class="col-md-3 post-item">
        <img alt="" src="${i.getSrc() }" class="img-fluid" onclick="detailPost(${i.getId_post()})">
        </div>
        <div class=" col-md-8 border-bottom text-black-50">
            	<a href="#" class="titlepost"  onclick="detailPost(${i.getId_post()})">${i.getTitle()}</a>            	
            	<div><span class="text-black-50">${i.getTime()}</span></div>
        </div>
        <div class="col-md-1">
        <input type="checkbox" name="check_box_${i.getId_post()}" value="${i.getId_post()}">
        </div>
        
 </div>
</c:forEach>        
       <div class="row" >
        <div class="col-md-12 align-items-center text-center createpost">
        <button class="btn btn-danger my-2 my-sm-0" type="submit">Delect all selected</button>
        </div>
        
</div> 
   </form>       
  