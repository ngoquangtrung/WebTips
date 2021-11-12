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
			/*$('#btn_deletePost').click(function(){
				if(confirm("Có chắc chắn xóa")){				
				$(location).attr('href',"/GameRule/UpdatePostCtrl?action=delete")
				alert("Đã xóa bài viết");	
	    }
	    else{
	        return false;
	    }
				});*/
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

function uptoAdmin(iduser){
	$.ajax({
    		url:"/GameRule/userCtrl",
    		type:"get",
			data:{
				iduser:iduser,
			},
    		success:function (rs){
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
	
    		},
    		error: function(xhr){
    			
    		}
    	});
}


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
function listComment(){
	$.ajax({
    		url:"/GameRule/CmtCtrl",
    		type:"get",
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
function deleteCmt(listid){
	if(confirm("Có chắc chắn xóa")){
	
					let listdelete=new Array();
					for(let i=0;i<listid.length;i++){
						let idcheckbox="check_box_"+ listid[i];
						if(document.getElementById(idcheckbox).checked==true){
							listdelete.push(listid[i]);
						}
						
					}
					$.ajax({
			    		url:"/GameRule/DeleteCmt",
			    		type:"post",
						data:{
							'idList': listdelete
						},
			    		success:function (rs){
							document.getElementById("replace").innerHTML=rs;
			    		},
			    		error: function(xhr){
			    			
			    		}
		    		});
				alert("Đã xóa các bình luận được chọn");
				}
		else{
			return false;
		}
};
				
function deletePostselected(listid){
	if(confirm("Có chắc chắn xóa")){
		
					let listdelete=new Array();
					for(let i=0;i<listid.length;i++){
						let idcheckbox="checkbox_"+ listid[i];
						if(document.getElementById(idcheckbox).checked==true){
							listdelete.push(listid[i]);
						}
						
					}
						$.ajax({
				    		url:"/GameRule/UpdatePostCtrl",
				    		type:"get",
							data:{
								'listIddelete': listdelete
							},
				    		success:function (rs){
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
				    		},
				    		error: function(xhr){
				    			$(location).attr('href',"/GameRule/login.jsp")
				    		}
			    		});
				alert("Đã xóa các bình luận được chọn");
					
	}else{
		return null;
	}
}

function deletePost(idpost){
		if(confirm("Có chắc chắn xóa")){					
					
						$.ajax({
			    		url:"/GameRule/UpdatePostCtrl",
			    		type:"get",
						data:{
							action:"delete",
							idpost:idpost,
						},
			    		success:function (rs){
				
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
			    			
			    		},
			    		error: function(xhr){
	    		}
	    	});
	    }
	    else{
	        return false;
	    }
}

function like_unlikecmt(idcmt){
	let status=document.getElementById("like"+idcmt).innerHTML;
	$.ajax({
			    		url:"/GameRule/LikeCtrl",
			    		type:"post",
						data:{
							current_status:status,
							cmtid:idcmt,
						},
			    		success:function (rs){
				
						if(rs!="login"){
							document.getElementById("like"+idcmt).innerHTML=rs;
							$.ajax({
				    		url:"/GameRule/LikeCtrl",
				    		type:"get",
							data:{
								cmtid:idcmt,
							},
				    		success:function (rs){
				    			document.getElementById("count"+idcmt).innerHTML="("+rs+")";
				    		},
				    		error: function(xhr){
									
							}
							});
							
								
						}
						else{
							if(confirm("Chuyển đến trang đăng nhập?")){
								$(location).attr('href',"/GameRule/CheckCookie")
							}
							else{
								return false;
							}
						}
													
				    	},
			    		
			    		error: function(xhr){
	    		}
})

}
