<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="header.jsp">
	<c:param name="title" value="${type}"></c:param>
</c:import>
<div class="height-60"></div>
<div class="container rounded bg-white mt-1 mb-1">
	<div>
		<h3>${type}</h3>
	</div>
	<div id="list-post">
		<c:forEach var="i" items="${listpost}">
			<div class="row post-item">
				<div class="col-md-3">
					<img alt="" src="${i.getSrc() }" class="img-fluid">
				</div>
				<div class="col-md-9">
					<h3>
						<a
							href="/GameRule/contentPostCtrl?idpost=${i.getId_post()}&title=${i.getTitle()}">${i.getTitle()}</a>
					</h3>
					<p>${i.getSummary()}</p>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
</body>


</html>