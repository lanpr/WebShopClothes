<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link href="../CSS/dangnhap.css" rel="stylesheet">
<c:url var="urlAccount" value="/account"></c:url>
<div class="content py-5">
	<article class="container">
		<div class="row">
			<div class="col-11 card col-sm-10 col-md-8 col-lg-7 col-xl-5 col-xxl-4  mx-auto px-0">
				<div class="card-body">
					<h4 class="title text-center mt-3 mb-3 text-uppercase"><fmt:message key="login.title"></fmt:message></h4>
					<form class="mt-5">
						<div class="form-input mb-3">
							<span><i class="fa-solid fa-user"></i></span> <input type="email" id="email" name="email" class="form-control" value="${email}" required placeholder="<fmt:message key="plhd.email"></fmt:message>">
						</div>
						<div class="form-input mb-3">
							<span><i class="fa-solid fa-lock"></i></span> <input type="password" id="matkhau" name="matkhau" value="${password}" class="form-control" placeholder="<fmt:message key="plhd.pass"></fmt:message>" required>
						</div>
					</form>
					<div class="row">
						<div class="col-6 mb-3 text-center">
							<div class="checkbox mt-2">
								<input type="checkbox" name="remember" id="remember"> <label><fmt:message key="login.remem"></fmt:message></label>
							</div>
						</div>
						<div class=" col-6 submit mb-2 text-center">
							<button class="btn btn-dark" name="btn-dangnhap" onclick="dangnhap()" style="border-radius: 50px 50px 50px 50px;"><fmt:message key="login.log"></fmt:message></button>
						</div>
					</div>
					<div id="message"></div>
					<div class="text-center mb-3">
						<a href="#" class="text-decoration-none"><fmt:message key="login.forgot"></fmt:message></a>
					</div>
					<div class="text-center mb-3"><fmt:message key="login.or"></fmt:message></div>
					<div class="g-signin2" data-onsuccess="onSignIn"></div>
					<div class="row mb-3 justify-content-center">
						<div class="text-center mb-3">
							<i class="bi bi-facebook h3" style="color: blue;"></i>
							<a href="">
								<i class="fa-brands fa-google-plus h3 mx-2" style="color: green;"></i>
							</a>
							<i class="fa-brands fa-square-instagram h3 accordion" style="color: red;"></i>
						</div>
						<div class="text-center mb-2">
							<fmt:message key="login.or"></fmt:message>
							<a href="dangky.jsp" class="text-decoration-none "> Đăng ký</a>
						</div>
					</div>
				</div>
			</div>
	</article>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="../JS/dangnhap.js"></script>
