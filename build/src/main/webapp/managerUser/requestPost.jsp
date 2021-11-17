<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:forEach var="i" items="${listrequest}">
<div class="row post-item" id="${i.getId_post()}">
        <div class="col-md-3 post-item">
        <img alt="" src="${i.getSrc() }" class="img-fluid" onclick="viewPost(${i.getId_post()})">
        </div>
        <div class=" col-md-9 border-bottom text-black-50">
            	<a href="#" class="titlepost"  onclick="viewPost(${i.getId_post()})">${i.getTitle()}</a>
            	<div><span class="text-black-50">${i.getTime()}</span></div>
        </div>
        
 </div>
</c:forEach>
       