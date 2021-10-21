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
${currentpost.getTitle() }
</h2>
</div>
<div>
<p class="font-weight-bold">${currentpost.getSummary() }
</p>
</div>
<c:forEach var="i" items="${listpart}">
<div>
<h3>${i.getTitle()}</h3>
<img alt="" src="${i.getSrc_image() }">
<p>${i.getContent()}</p>
</div>
</c:forEach>

</div>
</body>
</html>