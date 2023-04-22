<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" href="../CSS/shop.css">
<div class="banner position-relative h-100 " style="background-image: url('../IMG/IMG_Panel/sildeSP.webp');">
	<div>
		<h1 class="d-flex justify-content-center align-items-center position-absolute" style="text-shadow: 5px 5px 10px rgb(206, 84, 84); width: 100%; height: 100%; font-size: 4rem; color: orange;">SHOP</h1>
	</div>
</div>
<div class="row p-2 col-11 mx-auto d-block">
	<div class="bo_Loc mt-3">
		<ul class="nav nav-pills menu-loc ">
			<li class="nav-item  ms-auto col-12 col-lg-2 p-2 p-lg-0">
				<select class="form-select mb-2" name="sapXep" onchange="findDM()">
					<option value="0" selected="selected">Mặc định</option>
					<option value="1">Giá A-Z</option>
					<option value="2">Giá Z-A</option>
				</select>
			</li>
		</ul>
	</div>
	<div class="content">
		<aside class="col-12 col-lg-3 float-start float-lg-end p-1" style="">
			<jsp:include page="/VIEWS/danhmuc.jsp"></jsp:include>
		</aside>
		<article class="col-12 col-lg-9 float-lg-start float-end p-1">
			<div class="row box_SP p-2 mt-2" id="chuaSP">
				<c:forEach var="sp" items="${listSP}">
					<div class="col-6 col-lg-4 p-0">
						<jsp:include page="../VIEWS/item.jsp">
							<jsp:param value="${sp.masp}" name="masp" />
							<jsp:param value="${sp.tensp}" name="ten" />
							<jsp:param value="${sp.hinh[0].tenhinh}" name="hinh" />
							<jsp:param value="${sp.giaban}" name="gia" />
						</jsp:include>
					</div>
				</c:forEach>
			</div>
			<c:url var="url" value="/products"></c:url>
			<div class="phan-Page d-flex justify-content-start mt-5">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<c:forEach var="i" begin="1" end="${page}">
							<li class="page-item">
								<a class="page-link" href="${url}/all?indexPage=${i-1}">${i}</a>
							</li>
						</c:forEach>
					</ul>
				</nav>
			</div>
		</article>
	</div>
	<hr>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript" src="../JS/danhmuc.js">
	
</script>
