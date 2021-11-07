<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">All user</h4>
                </div>
                <div><select onchange="loadListuser()" id="selectstatus">
                <option value="1"> Active </option>
                <option value="0">Inactive</option>
                </select>
                </div>
                
                
<div id="listuser" >
        <p id="show"></p>
</div>
<!-- 
<script  type="text/javascript">
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
</script>  -->