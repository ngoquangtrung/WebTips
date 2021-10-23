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
				$(location).attr('href',"/GameRule//UpdatePostCtrl?action=delete")
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
    		url:"/GameRule/userCtrl",
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
	$.ajax({
    		url:"/GameRule/loadMoreCtrl",
    		type:"get",
			data:{
				index:amount,
			},
    		success:function (rs){
    			document.getElementById("list-post").innerHTML+=rs;
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
