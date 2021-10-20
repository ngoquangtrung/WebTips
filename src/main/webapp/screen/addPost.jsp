<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<form action="">
<div class="row">
         <div class="col-md-12">
         	<div><label class="font-weight-bold">Category</label></div>
         	<div>
         	<select>
         	<option value="1">Broadgame</option>
         	
         	<option value="2">Vận động</option>
         	
         	<option value="3">Dân gian</option>
         	</select>
         	</div>
	       	 <div><label class="font-weight-bold">Title</label></div>
	         <div><textarea class="editcontent" name="txt_posttitle"></textarea></div>
         
	         <div><label class="font-weight-bold">Src Thumbnail</label></div>
	         <div>
	         <input type="file" placeholder="Thumnail image" name="img_thumbnail">
	          </div>
         
	         <div><label class="font-weight-bold">Summary</label></div>
	         <div><textarea rows="5" cols="40" class="editcontent" name="txt_summary" ></textarea></div>
	        
        	<div class="form-group" id="content" >
        	<div class="part">
	        	<div><label class="font-weight-bold">Part title</label>
	        	<textarea rows="2" cols="40" class="editcontent" name="txt_parttitle1"></textarea>
	        	 </div>
	        	 <div><label class="font-weight-bold">Part image</label>
	        	<input type="file" placeholder="image" name="file">
	        	 </div>
	        	<div><label class="font-weight-bold">Part content</label>
	        	<textarea rows="5" cols="40" class="editcontent" name="txt_partcontent1"></textarea>
	        	</div>
        	</div>
        	
        	
        	
        	</div>	
          	
         
        
        </div>
        
</div>
<div class=" row align-items-center text-center">	        
        <div class="col-md-6"> <button type="button" class="btn btn-success " id="btn-addpart" onclick="addPart()"> Add Part</button></div>
        <div class="col-md-6"> <button type="button" class="btn btn-success btnsetup">Send</button></div>
        
</div>
</form>