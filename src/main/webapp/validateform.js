$(document).ready(function() {

		//Khi bàn phím được nhấn và thả ra thì sẽ chạy phương thức này
		$("#form_register").validate({
					rules: {
						email: "required",
						pass: {
							minlength:8,
							required: true},
						
						name: {
							required: true},
						repass: {
							required: true,
							equalTo: "#password"},
						birthday: {
							date: true}
					},
					messages: {
						email: "Không được bỏ trống",
						pass: {
							required: "Không được bỏ trống mật khẩu",
							minlength: "Mật khẩu tối thiểu 8 kí tự"
						},
						
						name: {
							required: "Không được bỏ trống"
						},
						repass: {
							required: 'Vui lòng nhập lại mật khẩu',
							equalTo: 'Mật khẩu không trùng'
						},
						birthday: {
							date:"Ngày tháng không đúng"
	
						}
					}
				});
	});