


function submit() {
	var hoten = $("#hoten").val();
	var email = $("#email").val();
	var ngaysinh = $("#ngaysinh").val();
	var gioitinh = $('input[name="gioitinh"]:checked').val();
	var matkhau = $("#matkhau").val();
	var xnmatkhau = $("#XNmatkhau").val();
	var sdt = $("#sdt").val();

	if (xnmatkhau != matkhau) {
		alert("Xác nhận password không đúng !");
	} else {
		$.ajax({
			type: 'post',
			url: '/JAVA4_ASM/account/sign-up',
			data: {
				"hoten": hoten,
				"email": email,
				"ngaysinh": ngaysinh,
				"gioitinh": gioitinh,
				"matkhau": matkhau,
				"xnmatkhau": xnmatkhau,
				"sdt": sdt
			},
			success: function(a) {
				var message = document.getElementById("message");
				if (a=="true") {
					message.innerHTML = "<h6>Đăng ký thành công</h6>";
					/*var successUrl = "../home/index"; 
					window.location.href = successUrl; */
				}else{
					message.innerHTML = a;
				}
			},
			error: function() {
				alert("Error !!");
			}
		});
	}


}