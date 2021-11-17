<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
<div class="text-center">
<img alt="" src="${i.getSrc_image() }">
</div>
<p>${i.getContent()}</p>
</div>
</c:forEach>

</div>
<div class="row">
<div class="col-md-6">
<button class="btn btn-success" type="button" id="accept">Accept</button>
</div>
<div class="col-md-6">
<button class="btn btn-danger" type="button" id="noaccept">Delete</button>
</div>
</div>



</body>
</html>