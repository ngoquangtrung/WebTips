<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="header.jsp">
<c:param name="title" value="Home"></c:param>
</c:import>

<div class="container rounded bg-white mt-1 mb-1">
<div class="row top-post bg-gradient-info">
<div class="col-md-6 latest-news">
<img src="https://static.thuthuatchoi.com/posts/images/board_game/uno/luat_rung_uno/luat%20choi%20Uno%20sai%20bet.jpg" class="img-fluid">
<h3>7 " Luật rừng" sai bét nhè khi chơi Uno</h3>
<p>Có bao giờ bạn chơi UNO và bị bạn bè bắt bẻ lỗi sai ở đâu không? Hiện nay Uno đang làm mưa làm gió ở thị trường trò chơi Việt Nam với nhiều cách chơi biến thể khác nhau do người chơi tự nghĩ ra. Chính điều đó khiến cho thi thoảng bạn có thể thấy là lạ nếu chơi với một nhóm bạn mới</p>
</div>
<div class="col-md-6">
<div class=" row latest-news-item">
<div class="col-md-4">
<img alt="" src="https://cdn.tgdd.vn/2021/01/campaign/thumb-640x361.jpg" class="img-fluid img-thumbnail">
</div>
<div class="col-md-8">
<h4>Cờ chớp, cờ nhanh là gì ? Luật chơi cơ bản của cờ chớp, cờ nhanh</h4>
<p>Theo quy định của Liên đoàn Cờ Vua thế giới (FIDE), thời gian cho một ván cờ tiêu chuẩn là 90 phút mỗi bên, cộng 30 giây cho mỗi nước đi.</p>
</div>
</div>

<div class=" row latest-news-item">
<div class="col-md-4">
<img alt="" src="https://cdn.tgdd.vn/2021/01/campaign/thumb-640x361.jpg" class="img-fluid img-thumbnail">
</div>
<div class="col-md-8">
<h4>Cờ chớp, cờ nhanh là gì ? Luật chơi cơ bản của cờ chớp, cờ nhanh</h4>
<p>Theo quy định của Liên đoàn Cờ Vua thế giới (FIDE), thời gian cho một ván cờ tiêu chuẩn là 90 phút mỗi bên, cộng 30 giây cho mỗi nước đi.</p>
</div>
</div>

<div class=" row latest-news-item">
<div class="col-md-4">
<img alt="" src="https://cdn.tgdd.vn/2021/01/campaign/thumb-640x361.jpg" class="img-fluid img-thumbnail">
</div>
<div class="col-md-8">
<h4>Cờ chớp, cờ nhanh là gì ? Luật chơi cơ bản của cờ chớp, cờ nhanh</h4>
<p>Theo quy định của Liên đoàn Cờ Vua thế giới (FIDE), thời gian cho một ván cờ tiêu chuẩn là 90 phút mỗi bên, cộng 30 giây cho mỗi nước đi. </p>
</div>
</div>

</div>


</div>
<div id="list-post">
<c:forEach var="i" items="${postlist}">
<div class="row post-item">
	    <div class="col-md-3">
	    	<img alt="" src="${i.getSrc() }" class="img-fluid">
    	</div>
    	<div class="col-md-9">
		<h3><a href="/GameRule/contentPostCtrl?idpost=${i.getId_post()}&title=${i.getTitle()}">${i.getTitle()}</a></h3>
		<p>${i.getSummary()}</p>
    	</div>
    </div>
</c:forEach>
	<div class="row post-item">
	    <div class="col-md-3">
	    	<img alt="" src="https://cdn.tgdd.vn/2021/01/campaign/thumb-640x361.jpg" class="img-fluid">
    	</div>
    	<div class="col-md-9">
		<h3>Cờ chớp, cờ nhanh là gì ? Luật chơi cơ bản của cờ chớp, cờ nhanh</h3>
		<p>Theo quy định của Liên đoàn Cờ Vua thế giới (FIDE), thời gian cho một ván cờ tiêu chuẩn là 90 phút mỗi bên, cộng 30 giây cho mỗi nước đi. Tuy nhiên gần đây, cờ vua có thêm các thể loại khác trong đó có cờ nhanh và cờ chớp với thời gian thi đấu ngắn hơn. Cùng Thủ thuật thuật tìm hiểu hai thể loại mới này thông qua bài viết dưới đây nhé.</p>
    	</div>
    </div>
    
    <div class="row post-item">
	    <div class="col-md-3">
	    	<img alt="" src="https://cdn.tgdd.vn/2021/01/campaign/thumb-640x361.jpg" class="img-fluid">
    	</div>
    	<div class="col-md-9">
		<h3>Cờ chớp, cờ nhanh là gì ? Luật chơi cơ bản của cờ chớp, cờ nhanh</h3>
		<p>Theo quy định của Liên đoàn Cờ Vua thế giới (FIDE), thời gian cho một ván cờ tiêu chuẩn là 90 phút mỗi bên, cộng 30 giây cho mỗi nước đi. Tuy nhiên gần đây, cờ vua có thêm các thể loại khác trong đó có cờ nhanh và cờ chớp với thời gian thi đấu ngắn hơn. Cùng Thủ thuật thuật tìm hiểu hai thể loại mới này thông qua bài viết dưới đây nhé.</p>
    	</div>
    </div>
    
    <div class="row post-item">
	    <div class="col-md-3">
	    	<img alt="" src="https://cdn.tgdd.vn/2021/01/campaign/thumb-640x361.jpg" class="img-fluid">
    	</div>
    	<div class="col-md-9">
		<h3>Cờ chớp, cờ nhanh là gì ? Luật chơi cơ bản của cờ chớp, cờ nhanh</h3>
		<p>Theo quy định của Liên đoàn Cờ Vua thế giới (FIDE), thời gian cho một ván cờ tiêu chuẩn là 90 phút mỗi bên, cộng 30 giây cho mỗi nước đi. Tuy nhiên gần đây, cờ vua có thêm các thể loại khác trong đó có cờ nhanh và cờ chớp với thời gian thi đấu ngắn hơn. Cùng Thủ thuật thuật tìm hiểu hai thể loại mới này thông qua bài viết dưới đây nhé.</p>
    	</div>
    </div>
 </div>   
    

<div class="align-items-center text-center"><button type="button" id="btn-load-post" class="btn" onclick="loadmore()"> Read more</button></div>


</div>


</body>
</html>