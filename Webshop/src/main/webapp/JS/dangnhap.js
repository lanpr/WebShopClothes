 function dangnhap(){
	 var email =  $("#email").val();
	 var matkhau = $("#matkhau").val();
	  var remember = $("#remember").val();
	 $.ajax({
			type: 'post',
			url: '/JAVA4_ASM/account/sign-in',
			data: {
				"email": email,
				"matkhau": matkhau,
				"remember":remember
			},
			success: function(a) {
				var message = document.getElementById("message");
				if (a=="true") {
					var successUrl = "../home/index"; 
					window.location.href = successUrl;
				}else{
					message.innerHTML = a;
				}
			},
			error: function() {
				alert("Error !!");
			}
		});
	 
	 
 }
 

