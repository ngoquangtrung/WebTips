$(document).ready(function(){
	$('#btn-addpart').click(function(){
		$.ajax({
    		url:"/GameRule/PartCtrl",
    		type:"post",
			data:{
				
			},
    		success:function (rs){
    			document.getElementById("content").innerHTML+=rs;
    		},
    		error: function(xhr){
	
}
    	})
	});
	$('.hidearea').toggle();
	
	$('#btnsendcmt').click(function(){
		let idpost= document.getElementById("idpostcmt").value;
		let content=document.getElementById("contentcmt").value;
		
		$.ajax({
    		url:"/GameRule/CmtCtrl",
    		type:"post",
			data:{
				contentcmt:content,
				idpost:idpost
			},
    		success:function (rs){
			if(rs=="loginned"){
				alert("Bình luận đã được gửi!")
			}else {
				if(confirm("Bạn phải đăng nhập để tiếp tục")){
				$(location).attr('href',"/GameRule/login.jsp")
				}else{
					return false;
				}
			}
    		},
    		error: function(xhr){
    			
    		}
    	});
		
	});
	
	
});


function listPost(){
	$.ajax({
    		url:"/GameRule/listPostctrl",
    		type:"post",
			data:{
				
			},
    		success:function (rs){
    			document.getElementById("replace").innerHTML=rs;
    		},
    		error: function(xhr){
    			$(location).attr('href',"/GameRule/login.jsp")
    		}
    	})
};

function detailPost(id){
	$.ajax({
    		url:"/GameRule/detailPostctrl",
    		type:"get",
			data:{
				id_currentpost:id,
			},
    		success:function (rs){
    			document.getElementById("replace").innerHTML=rs;
			$('#btn_deletePost').click(function(){
				if(confirm("Có chắc chắn xóa")){
				alert("Đã xóa bài viết");	
				$(location).attr('href',"/GameRule/UpdatePostCtrl?action=delete")
	    }
	    else{
	        return false;
	    }
				});
    		},
    		error: function(xhr){
    			
    		}
    	})
};

function addPost(){
	$.ajax({
    		url:"/GameRule/screen/addPost.jsp",
    		type:"get",
			data:{
				
			},
    		success:function (rs){
    			document.getElementById("replace").innerHTML=rs;
				
    		},
    		error: function(xhr){
    			
    		}
    	})
};

function addPart(){
	let countpart=document.getElementsByClassName("part").length;
	$.ajax({
		
    		url:"/GameRule/PartCtrl",
    		type:"get",
			data:{
				numberPart:countpart+1,
			},
    		success:function (rs){
    			document.getElementById("content").innerHTML+=rs;
				
    		},
    		error: function(xhr){
    			
    		}
    	})
};


function infoUser(){
	$.ajax({
    		url:"/GameRule/screen/infoUser.jsp",
    		type:"get",
			data:{
				
			},
    		success:function (rs){
    			document.getElementById("replace").innerHTML=rs;
    		},
    		error: function(xhr){
    			
    		}
    	})
};

function loadmore(){
	let amount=document.getElementsByClassName("post-item").length;
	let error=document.getElementsByClassName("nomore").length;
	$.ajax({
    		url:"/GameRule/loadMoreCtrl",
    		type:"get",
			data:{
				index:amount,
			},
    		success:function (rs){
				
				if(error>0){
					alert("Không còn bài viết nào");
				}else {
					document.getElementById("list-post").innerHTML+=rs;
				}
				
    		},
    		error: function(xhr){
    			
    		}
    	})
};

function confirmdelete(){
	if(confirm("Có chắc chắn xóa")){
		alert("Đã xóa các bài viết được chọn");
		return true;
	}
	else{
		return false;
	}
}

function screenuser(){
	$.ajax({
    		url:"/GameRule/managerUser/usermanager.jsp",
    		type:"post",
			data:{
				
			},
    		success:function (rs){
    			document.getElementById("replace").innerHTML=rs;
			$.ajax({
    		url:"/GameRule/ListUserCtrl",
    		type:"get",
			data:{
				status:1,
			},
    		success:function (rs){
				
				document.getElementById("listuser").innerHTML=rs;
				
    		},
    		error: function(xhr){
    			
    		}
    	})
    		},
    		error: function(xhr){
    			
    		}
    	})
};
function loadListuser(){
	let selectbox=document.getElementById("selectstatus");
	let userstatus=selectbox.options[selectbox.selectedIndex].value;
	
	$.ajax({
    		url:"/GameRule/ListUserCtrl",
    		type:"get",
			data:{
				status:userstatus,
			},
    		success:function (rs){
				
				document.getElementById("listuser").innerHTML=rs;
				
    		},
    		error: function(xhr){
    			
    		}
    	})
};

function deleteUser(id){
	let selectbox=document.getElementById("selectstatus");
	let userstatus=selectbox.options[selectbox.selectedIndex].value;
	$.ajax({
    		url:"/GameRule/ListUserCtrl",
    		type:"post",
			data:{
				status:userstatus,
				iduser:id
			},
    		success:function (rs){
				
				document.getElementById("listuser").innerHTML=rs;
    		},
    		error: function(xhr){
    			
    		}
    	})
};

function listPostRequest(){
	$.ajax({
    		url:"/GameRule/PostRequest",
    		type:"post",
			data:{
				
			},
    		success:function (rs){
				
				document.getElementById("replace").innerHTML=rs;
				
    		},
    		error: function(xhr){
    			
    		}
    	})
};
function viewPost(id){
	$.ajax({
    		url:"/GameRule/ViewRequestPost",
    		type:"get",
			data:{
				idpost:id,
			},
    		success:function (rs){				
				document.getElementById("replace").innerHTML=rs;
				$('#accept').click(function(){
					if(confirm("Chấp nhận bài viết này")){
				alert("Bài viết đã được duyệt");
				
				$.ajax({
    					url:"/GameRule/PostRequest",
    					type:"get",
						data:{
								decide:"accept"
						},
    					success:function (rs){
				
						document.getElementById("replace").innerHTML=rs;
				
    					},
    					error: function(xhr){
    			
    					}
    			});
				
				
	   				 }else{
	        			return false;
	    			}
				});
				$('#noaccept').click(function(){
					if(confirm("Xóa bài viết này")){
				alert("Bài viết đã được xóa");
				//$(location).attr('href',"/GameRule/UpdatePostCtrl?action=delete")
				
				$.ajax({
    					url:"/GameRule/PostRequest",
    					type:"get",
						data:{
								decide:"no accept"
						},
    					success:function (rs){
				
						document.getElementById("replace").innerHTML=rs;
				
    					},
    					error: function(xhr){
    			
    					}
    			});
				
				
	   				 }else{
	        			return false;
	    			}
				});
				
				
    		},
    		error: function(xhr){
    			
    		}
    	});
	
	
};


function reply(idcmt){
	letid='#repcmt_'+idcmt;
	$(letid).toggle();
};

function sendrep(idrepcmt){
	let content=document.getElementById("text_"+idrepcmt).value;
	let idpost= document.getElementById("idpostcmt").value;
	$.ajax({
    		url:"/GameRule/CmtCtrl",
    		type:"post",
			data:{
				contentcmt:content,
				idpost:idpost,
				idrep:idrepcmt
			},
    		success:function (rs){
			if(rs=="loginned"){
				alert("Đã gửi phản hồi")
			}else {
				if(confirm("Bạn phải đăng nhập để tiếp tục")){
				$(location).attr('href',"/GameRule/login.jsp")
				}else{
					return false;
				}
			}
    		},
    		error: function(xhr){
    			
    		}
    	});
};

