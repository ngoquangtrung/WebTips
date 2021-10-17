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

function detailPost(){
	$.ajax({
    		url:"/GameRule/detailPostctrl",
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
