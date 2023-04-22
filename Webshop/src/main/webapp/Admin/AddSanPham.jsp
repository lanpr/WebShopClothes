<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="modal-dialog">
		<div class="modal-content" style="width: 600px; margin-left: -50px; margin-top: 50px">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalLabel">THÊM SẢN PHẨM</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<c:url var="url" value="/product">
			</c:url>
			<div class="modal-body">
				<form method="post" action="${url}/addSP" enctype="multipart/form-data">
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="floatingMaSP" name="masp" placeholder="Mã Sản Phẩm"> <label for="floatingMaSP">Mã Sản Phẩm</label>
					</div>
					<div class="form-floating mb-3">
						<select class="form-select form-control" name="danhmuc1" id="floatingMaDM">
							<c:forEach var="dm" items="${listDM}">
								<option  value="${dm.madanhmuc}">${dm.tendanhmuc} ${dm.madanhmuc}</option>
							</c:forEach>
						</select> <label for="floatingMaDM">Tên Danh Mục</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="floatingTenSP" name="tensp" placeholder="Tên Sản Phẩm"> <label for="floatingTenSP">Tên Sản Phẩm</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="floatingGiaSP" name="giaban" placeholder="Giá Sản Phẩm"> <label for="floatingGiaSP">Giá sản phẩm</label>
					</div>
					<div class=" mb-3">
						<input class="form-control" name="hinh" type="file" required="required" id="ctrl" multiple />
					</div>
					<div class=" mb-3">
						<br>
						<textarea placeholder="Mô tả sản phẩm" name="mota" class="form-control" cols="55" rows="4" maxlength="250"></textarea>
					</div>
					<div class="d-grid">
						<button class="btn text-uppercase fw-bold bg-success text-white">Thêm Sản Phẩm</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>