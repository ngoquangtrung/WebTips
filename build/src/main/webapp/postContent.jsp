<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="header.jsp">
<c:param name="title" value="Account manager"></c:param>
</c:import>
<div class="height-60"></div>
<div class="container rounded bg-white mt-1 mb-1">
<div>
<h2>
${viewpost.getTitle() }
</h2>
<label>${viewpost.getTime()}</label>
</div>
<div>
<p class="font-weight-bold">${viewpost.getSummary() }
</p>
</div>
<c:forEach var="i" items="${listpart}">
<div>
<h3>${i.getTitle()}</h3>
<div class="text-center">
<img alt="" src="${i.getSrc_image() }">
</div>
<p>${i.getContent()}</p>
</div>
</c:forEach>
<div class="row justify-content-center">
<div class="commentarea">
<!-- Form binh luan -->
<form method="post" action="CmtCtrl">
<div><input type="text" value="${viewpost.getId_post() }" class="invisible" name="idpost" id="idpostcmt"></div>
<textarea rows="3" cols="110" class="form-control ml-1 shadow-none" name="contentcmt" id="contentcmt" required>
</textarea>
<div class="text-right mt-2">
<button class="btn btn-primary btn-sm shadow-none" type="button" id="btnsendcmt">Gửi bình luận</button>
</div>
</form>
<label>Bình luận (${listcmt.size()+listrep.size()}) </label>
<div id="allcmt">
<!-- hien thi cac comment -->
<c:forEach var="i" items="${listcmt }">
<div class="card ">
<div class="card-body">
<c:set var="permission" value="${currentuser.getPermission()}"></c:set>
<c:if test="${permission==1 }">
<span class="close pointer" onclick="deleteCmtbyAdmin(${i.getIdcmt()})">&times;</span>
</c:if>
<label><strong>${i.getNameuser() }</strong></label>
<p>${i.getDate() } </p>
<p>${i.getContent() }</p>
</div>

<div>
<span class="pointer cursor" onclick="reply(${i.getIdcmt()})">Trả lời</span> 
<c:set var="liked" value="${i.isLiked()}"></c:set>
<c:if test="${liked }">
<span class="pointer cursor unlike" id="like${i.getIdcmt()}" onclick="like_unlikecmt(${i.getIdcmt()})">Bỏ thích</span>
</c:if>
<c:if test="${!liked }">
<span class="pointer cursor like" id="like${i.getIdcmt()}" onclick="like_unlikecmt(${i.getIdcmt()})">Thích</span>
</c:if>
<span id="count${i.getIdcmt()}">(${i.getCountlike()})</span>
</div>
<!-- Tra loi mot binh luan -->
<div id="repcmt_${i.getIdcmt() }" class="text-center  hidearea">
<div class="text-center">
<textarea rows="2" cols="100" placeholder="Ý kiến của bạn" class="no-resize form-control ml-2 shadow-none" id="text_${i.getIdcmt() }" required></textarea>
</div>

<div class="text-right mt-2">
<button type="button" onclick="sendrep(${i.getIdcmt()})" class="btn btn-primary btn-sm shadow-none">Gửi phản hồi</button>
</div>

</div>
<!-- hien thi cac phan hoi -->
<div>
	<c:set var="idcmt" value="${i.getIdcmt() }"></c:set>
	<c:forEach var="j" items="${listrep}">
	<c:set var="idrep" value="${j.getIdrep()}"></c:set>
	<c:if test="${idrep==idcmt}">
	<div class="repzone card-body bordercmt">
	<c:if test="${permission==1 }">
	<span class="close pointer" onclick="deleteCmtbyAdmin(${j.getIdcmt()})">&times;</span>
	</c:if>
	<label><strong>${j.getNameuser() }</strong></label>
	<p>${j.getDate() } </p>
	<p>${j.getContent() }</p>
		<!-- Phan hoi lai mot phan hoi khac -->
		
		<div>
		<span class="pointer cursor" onclick="reply(${j.getIdcmt()})">Trả lời</span> 
		<c:set var="liked" value="${j.isLiked()}"></c:set>
		<c:if test="${liked }">
		<span class="pointer cursor unlike" id="like${j.getIdcmt()}" onclick="like_unlikecmt(${j.getIdcmt()})">Bỏ thích</span>
		</c:if>
		<c:if test="${!liked }">
		<span class="pointer cursor like" id="like${j.getIdcmt()}" onclick="like_unlikecmt(${j.getIdcmt()})">Thích</span>
		</c:if>
		<span id="count${j.getIdcmt()}">(${j.getCountlike()})</span>
		</div>
		<div id="repcmt_${j.getIdcmt() }" class="text-center  hidearea">
		<div class="text-center">
		<textarea rows="2" cols="100" placeholder="Ý kiến của bạn" class="no-resize form-control ml-2 shadow-none" id="text_${j.getIdcmt() }" required></textarea>
		</div>
		
		<div class="text-right mt-2">
		<button type="button" class="btn btn-primary btn-sm shadow-none" onclick="sendreply(${i.getIdcmt()},'${i.getNameuser()}' ,${j.getIdcmt()})">Gửi phản hồi</button>
		</div>
		
		</div>	
	 
	</div>
	
	</c:if>
	
	</c:forEach>
</div>
	
	
</div>

</c:forEach>
</div>
</div>
</div>
</div>
</body>
</html>