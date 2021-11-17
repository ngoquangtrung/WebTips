<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="header.jsp">
	<c:param name="title" value="Home"></c:param>
</c:import>
<div class="height-60"></div>
<div class="container rounded bg-white mt-1 mb-1">

	<div class="row top-post bg-gradient-info">
		<div class="col-md-6 latest-news post-item">
			<img
				src="${postest.getSrc() }"
				class="img-fluid">
			<h3><a href="/GameRule/contentPostCtrl?idpost=${postest.getId_post()}&title=${postest.getTitle()}">  ${postest.getTitle()} </a></h3>
			<p>${postest.getSummary()}</p>
		</div>
		<div class="col-md-6">
		
		<c:forEach var="p" items="${latestpost}">
		
			<div class=" row latest-news-item post-item">
				<div class="col-md-4">
					<img alt=""
						src="${p.getSrc() }"
						class="img-fluid img-thumbnail">
				</div>
				<div class="col-md-8">
					<h4><a href="/GameRule/contentPostCtrl?idpost=${p.getId_post()}&title=${p.getTitle()}">  ${p.getTitle()} </a></h4>
					<p>${p.getSummary()}</p>
				</div>
			</div>
			
		
		</c:forEach>
		

		</div>

	</div>
	<div id="list-post">
		<c:forEach var="i" items="${postlist}">
			<div class="row post-item">
				<div class="col-md-3">
					<img alt="" src="${i.getSrc() }" class="img-fluid">
				</div>
				<div class="col-md-9">
					<h3>
						<a href="/GameRule/contentPostCtrl?idpost=${i.getId_post()}&title=${i.getTitle()}">${i.getTitle()}</a>
					</h3>
					<p>${i.getSummary()}</p>
				</div>
			</div>
		</c:forEach>
	</div>


	<div class="align-items-center text-center">
		<button type="button" id="btn-load-post" class="btn"
			onclick="loadmore()">Read more</button>
	</div>

</div>
</body>

<c:import url="footer.jsp">
</c:import>

</html>
