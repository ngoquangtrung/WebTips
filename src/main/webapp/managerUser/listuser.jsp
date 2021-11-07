<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="i" items="${alluser}">
	<div class="row border-bottom useritem">
		<div class="col-md-10">
		<label>Name</label>
		<p>${i.getName()}</p>
		<label>Email</label>
		<p>${i.getEmail() }</p>
		<label>Permission</label>
		<c:set var="permission" value="${i.getPermission()}"></c:set>
		<c:if test="${permission==1}">
		<p>Admin</p>
		</c:if>
		<c:if test="${permission==0}">
		<p>User</p>
		</c:if>
		</div>
		<c:set var="active" value="${i.getStatus() }"></c:set>
		<c:if test="${active==1}">
		<div class="col-md-2">
		<button onclick="deleteUser(${i.getIduser()})" class="btn btn-danger">Delete</button>
		 </div>
		</c:if>
		<c:if test="${active==0}">
		<div class="col-md-2">
		<button onclick="deleteUser(${i.getIduser()})" class="btn btn-success">Re Active</button>
		 </div>
	</c:if>
	</div>
	
	
</c:forEach>


  