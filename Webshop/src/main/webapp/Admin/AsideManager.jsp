<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#card-aside {
	background-color: #485461;
	background-image: linear-gradient(315deg, #485461 0%, #28313b 74%);
	border-radius: 20px;
	height: 98vh;
}
</style>
<div class="card border-0  p-2" id="card-aside">
	<div class="card-header border-0">
		<h6 class="fw-bold mt-1 text-white text-center">DANH MỤC QUẢN LÝ</h6>
	</div>
	<div class="card-body p-0 mt-3">
		<div class="accordion h-50" id="accordionExample">
			<div class="list-group">
		<c:url var="url" value="/manager"></c:url>
				<a href="${url}/index" class="list-group-item list-group-item-action active"> Quản lý sản phẩm </a>
			
				<a href="${url}/qltaikhoan" class="list-group-item list-group-item-action">Quản lý tài khoản</a>
			</div>
		</div>
	</div>
</div>