
 function findDM(){
	 //lấy pramater
	
	var khoanggia = $('input[name="khoanggia"]:checked').val();
	var sapxep = $('select[name="sapXep"]').val();
	var maDM = $('input[name="madanhmuc"]:checked').val();
	
	$.ajax({
			type: 'post',
			url: '/JAVA4_ASM/products/findGiaSX',
			data: {
				"khoanggia": khoanggia,
				"sapxep": sapxep,
				"madanhmuc":maDM
			},
			success: function(a) {
				var divchua = document.getElementById("chuaSP");
				divchua.innerHTML = a
				
			},
			error: function() {
				alert("Error !!");
			}
		});
 }