<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="header.jsp">
<c:param name="title" value="Account manager"></c:param>
</c:import>

<div class="container rounded bg-white mt-1 mb-1">
<div>
<h2>
${viewpost.getTitle() }
</h2>
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


<form method="post" action="CmtCtrl">
<div><input type="text" value="${viewpost.getId_post() }" class="invisible" name="idpost" id="idpostcmt"></div>
<div>
<div class="text-center"><textarea rows="4" cols="140" class="commentarea" name="contentcmt" id="contentcmt"></textarea>
</div>

<div class="text-right"><button class="btn btn-success" type="button" id="btnsendcmt">Send</button></div>
</div>
</form>


<label>Bình luận (${listcmt.size()}) </label>
<div id="allcmt">
<c:forEach var="i" items="${listcmt }">
<div class="border-bottom">
<div>
<label>${i.getNameuser() }</label>
<p>${i.getDate() } </p>
<p>${i.getContent() }</p>
</div>
<div>
<span class="pointer" onclick="reply(${i.getIdcmt()})">Trả lời</span> <span class="pointer">Thích</span>
</div>

<div id="repcmt_${i.getIdcmt() }" class="text-center  hidearea">
<textarea rows="2" cols="140" placeholder="Ý kiến của bạn" class="commentarea" id="text_${i.getIdcmt() }"></textarea>
<button type=button onclick="sendrep(${i.getIdcmt()})" class="btn">Gửi</button>
</div>

	<c:set var="idcmt" value="${i.getIdcmt() }"></c:set>
	<c:forEach var="j" items="${listrep}">
	<c:set var="idrep" value="${j.getIdrep()}"></c:set>
	<c:if test="${idrep==idcmt}">
	<div class="repzone">
	<label>${j.getNameuser() }</label>
	<p>${j.getDate() } </p>
	<p>${j.getContent() }</p>
	</div>
	
	</c:if>
	
	</c:forEach>
	
</div>

</c:forEach>
</div>
</div>
</body>
</html>