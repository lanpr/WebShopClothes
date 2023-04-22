<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" integrity="sha512-3P8rXCuGJdNZOnUx/03c1jOTnMn3rP63nBip5gOP2qmUh5YAdVAvFZ1E+QLZZbC1rtMrQb+mah3AfYW11RUrWA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet" href="../CSS/item_detail.css">
<article class="container my-5">
	<div class="row p-4 p-md-0">
		<div class="col-12 col-md-8">
			<div id="carouselExampleIndicators" class="carousel slide carousel-dark">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="${product.hinh[0].tenhinh}" class="d-block " width="100%" alt="...">
					</div>
					<div class="carousel-item">
						<img src="${product.hinh[0].tenhinh}" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="${product.hinh[0].tenhinh}" class="d-block w-100" alt="...">
					</div>
				</div>
				<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="visually-hidden">Next</span>
				</button>
			</div>
			<div class="row d-flex w-75 ">
				<img class="img-thumbnail w-25 me-1" src="${product.hinh[1].tenhinh}"> <img class="img-thumbnail w-25 me-1" src="${product.hinh[0].tenhinh}"> <img class="img-thumbnail w-25 me-1" src="${product.hinh[0].tenhinh}">
			</div>
		</div>
		<div class="col-12 col-md-4">
			<div class="card text-center border-0 ">
				<div class="card-header pb-0 bg-white border-0">
					<span class="h4 fw-bold " name="namePro">${product.tensp}</span>
					<h6 name="price" class="mb-0  text-danger fs-5 fw-bold">
						<fmt:formatNumber type="number" pattern="##,###.##" value="${product.giaban}" />
						VND
					</h6>
				</div>
				<div class="card-body border-0 pt-1">
					<c:set var="masp" scope="session" value="${product.masp}" />
					<c:url var="url" value="/cart"></c:url>
					<form method="get" class="mt-2 size row d-flex justify-content-center column-gap-2 column-gap-lg-2">
						<c:forEach var="size" items="${listSPSize}">
							<input type="radio" ${size.slcon < 1 ?'disabled':''} class="btn-check btn-size col-3 col-lg-2 btn" name="size" value="${size.size.masize}" id="${size.size.tensize}" autocomplete="off">
							<label class="btn btn-outline-success btn-size col-3 col-lg-2" for="${size.size.tensize}">${size.size.tensize}</label>
						</c:forEach>
						<div class="mt-2 row mt-4">
							<button class="btn text-uppercase p-2" style="border: solid gray 1px;" formaction="${url}/addCart">Thêm vào giỏ</button>
						</div>
					</form>
					<br>
					<div>
						<h6 class="fw-bold">Mua trực tiếp trên sàn TMDT:</h6>
						<img class="tmdt" src="../IMG/IMG_SP/lazada_200px.png" alt=""> <img class="tmdt" src="../IMG/IMG_SP/shopee_96px.png" alt=""> <img class="tmdt" src="../IMG/IMG_SP/tiktok_96px.png" alt="">
					</div>
				</div>
				<div class="card-footer bg-white text-start border-0">
					<ul class="list-group">
						<span class="fw-bold">Chi tiết sản phẩm:</span>
						<li>Chất liệu: Cotton</li>
						<li>Regular fit</li>
						<li>Hình in mặt trước và sau áp dụng công nghệ in kéo lụa</li>
					</ul>
					<span class="fw-bold">Size chart:</span>
					<div>
						<img class="size-chart" src="../IMG/IMG_SP/sc-t-shirt-2023.webp" alt="" width="100%">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal hide fade" tabindex="-1" id="myModal">
		<jsp:include page="modalMessage.jsp"></jsp:include>
	</div>
	<%@include file="sanphamLQ.jsp"%>
	<!-- SHOW MODAL khi add cart thành công -->
</article>
