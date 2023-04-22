function checkSize(param) {
	var masp = $("#masp").val();
	var masize = param.value;
	$.ajax({
		type: 'post',
		url: '/JAVA4_ASM/product/checkSize',
		data: {
			"masp": masp,
			"masize": masize
		},
		success: function(a) {
			
			var sl = document.getElementById("slsize");
			sl.value = a;
		},
		error: function() {
			alert("Error !!");
		}
	});

}