<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <form action="#" method="get" id="fromlistpost">
<c:forEach var="i" items="${listcmt}">
<div class="row post-item" id="${i.getIdcmt()}">
        <div class="col-md-11 border-bottom text-black-50">
            	<div><a href="/GameRule/contentPostCtrl?idpost=${i.getIdpost()}&title=${i.getPosttitle()}">${i.getPosttitle()}</a></div>
            	<div><span class="text-black-50">${i.getDate()}</span></div>
            	<div><p>${i.getContent() }</p></div>
        </div>
        <div class="col-md-1">
        <input type="checkbox" name="check_box_${i.getIdcmt()}" id="check_box_${i.getIdcmt()}" value="${i.getIdcmt()}">
        </div>
 </div>
</c:forEach>
 <div class="align-items-center text-center" >
 <c:set var="listdelete" value="${listid}"></c:set>
        <button class="btn btn-danger my-2 my-sm-0" type="button" onclick="deleteCmt(${listdelete})">Delect all selected</button>
</div> 
</form>       
  