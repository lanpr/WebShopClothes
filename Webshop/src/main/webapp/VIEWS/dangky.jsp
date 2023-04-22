<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link href="../CSS/dangky.css" rel="stylesheet">
<c:url var="urlAccount" value="/account"></c:url>
<div class="content">
	<article class="container">
		<div class="row">
			<div class="card  col-11 col-sm-10 col-md-8 col-lg-6 col-xl-5 col-xxl-4  mx-auto px-0">
				<div class="card-body">
					<h4 class="title text-center mt-2 mb-3 text-uppercase"><fmt:message key="regis.title"></fmt:message></h4>
					<form enctype="multipart/data">
						<div class="form-input mb-3">
							<span><i class="fa-solid fa-user"></i></span> <input type="text" name="hoten" id="hoten" class="form-control" required placeholder="<fmt:message key="plhd.fullname"></fmt:message>">
						</div>
						<div class="form-input mb-3">
							<span><i class="fa-solid fa-envelope"></i></span> <input type="email" name="email" id="email" class="form-control" required placeholder="<fmt:message key="plhd.email"></fmt:message>">
						</div>
						<div class="form-input mb-3">
							<span><i class="fa-sharp fa-solid fa-calendar-days"></i></span> <input type="date" id="ngaysinh" class="form-control" name="ngaysinh" required>
						</div>
						<div class="b-3 ms-3 mb-3">
							<div class="form-check form-check-inline">
								<input class="form-check-input" required type="radio" name="gioitinh" id="inlineRadio1" value="true" checked="checked"> <label class="form-check-label" for="inlineRadio1"><fmt:message key="regis.male"></fmt:message></label>
							</div>
							<div class="form-check form-check-inline ">
								<input class="form-check-input" type="radio" name="gioitinh" id="inlineRadio2" value="false"> <label class="form-check-label" for="inlineRadio2"><fmt:message key="regis.fem"></fmt:message></label>
							</div>
						</div>
						<div class="form-input mb-3">
							<span><i class="fa-solid fa-phone"></i></span> <input type="phone" class="form-control" id="sdt" name="sdt" placeholder="<fmt:message key="plhd.phone"></fmt:message>" required>
						</div>
						<div class="form-input mb-3">
							<span><i class="fa-solid fa-lock"></i></span> <input type="password" class="form-control" id="matkhau" name="matkhau" placeholder="<fmt:message key="plhd.pass"></fmt:message>" required>
						</div>
						<div class="form-input mb-3">
							<span><i class="fa-solid fa-lock"></i></span> <input type="password" class="form-control" id="XNmatkhau" name="XNmatkhau" placeholder="<fmt:message key="plhd.confpass"></fmt:message>" required>
						</div>
					</form>
					<div id="message"></div>
					<div class="submit mb-2 text-center">
						<button onclick="submit()" class="btn btn-dark text-uppercase" style="border-radius: 50px 50px 50px 50px;"><fmt:message key="login.regis"></fmt:message></button>
					</div>
					<div class="rollback text-center">
						<a href="dangnhap.jsp" class="text-decoration-none text-center"><fmt:message key="a.back"></fmt:message></a>
					</div>
				</div>
			</div>
		</div>
	</article>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="../JS/dangky.js"></script>
