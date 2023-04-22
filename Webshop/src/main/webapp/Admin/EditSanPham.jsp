<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="url" value="/product"></c:url>
<div class="mx-auto d-block bg-secondary p-3 mt-4" style="width: 600px; margin-left: -50px; border-radius: 10px">
	<h3 class="text-center fw-bold">CHỈNH SỬA SẢN PHẨM</h3>
	<form enctype="multipart/form-data" method="POST">
		<div class="form-floating mb-3">
			<input value="${sanpham.masp}" type="text" class="form-control" id="masp" name="masp" placeholder="Mã Sản Phẩm" readonly="readonly"> <label for="masp">Mã Sản Phẩm</label>
		</div>
		<div class="form-floating mb-3">
			<select class="form-select form-control" name="danhmuc1" id="floatingMaDM">
				<c:forEach var="dm" items="${listDM}">
					<option value="${dm.madanhmuc}" ${sanpham.danhmuc.madanhmuc == dm.madanhmuc ? 'checked':''}>${dm.tendanhmuc}</option>
				</c:forEach>
			</select> <label for="floatingMaDM">Tên Danh Mục</label>
		</div>
		<div class="form-floating mb-3">
			<input value="${sanpham.tensp}" type="text" class="form-control" id="floatingTenSP" name="tensp"> <label for="floatingTenSP">Tên Sản Phẩm</label>
		</div>
		<div class="form-floating mb-3">
			<input type="text" value="${sanpham.giaban}" class="form-control" id="floatingGiaSP" name="giaban"> <label for="floatingGiaSP">Giá sản phẩm</label>
		</div>
		<div class="form-floating mb-3">
			<select class="form-select form-control" onselect="checkSize(this)"  onchange="checkSize(this)" name="size" id="floatingSize">
				<c:forEach var="size" items="${listSize}">
					<option value="${size.masize}">${size.tensize}</option>
				</c:forEach>
			</select> <label for="floatingSize">Size</label>
		</div>
		<div class="form-floating">
			<input type="text" class="form-control" id="slsize" value="" name="slSize"> <label for="slsize">Số lượng size</label>
		</div>
		<div class=" mb-3">
			<br>
			<input placeholder="Mô tả sản phẩm" value="${sanpham.mota}"  name="mota" class="form-control" height="50px" maxlength="250" style="height: 120px"/>
		</div>
		<div class="column-gap-3 row d-flex justify-content-center">
			<button class="btn text-uppercase fw-bold bg-success text-white col-3" formaction="${url}/editSP">Cập nhật</button>
			<button class="btn text-uppercase fw-bold bg-danger text-white col-3">Xóa</button>
		</div>
	</form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="../JS/sanpham.js"></script>
