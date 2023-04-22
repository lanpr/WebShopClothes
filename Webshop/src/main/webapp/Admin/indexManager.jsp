<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Insert title here</title>
</head>
<body>
	<div class="row m-0">
		<div class="col-3 p-1" style="height: 98vh";>
			<aside class="bg-secondary" style="border-radius: 20px; height: 98vh">
				<jsp:include page="AsideManager.jsp"></jsp:include>
			</aside>
		</div>
		<article class="col-9  p-0" style="height: 100vh; overflow: scroll;">
			<div class="bg-danger" style="height: 50px; border-radius: 10px">
				<nav class="navbar navbar-expand-lg bg-body-tertiary" style="height: 60px">
					<div class="container-fluid">
						<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<ul class="navbar-nav ms-auto mb-2 mb-lg-0 mx-2">
								<li class="nav-item fw-bold text-black-50">
									<a href="#" class="nav-link">
										<i class="fa-solid fa-user mx-2"></i>Đăng nhập
									</a>
								</li>
							</ul>
						</div>
					</div>
				</nav>
			</div>
			<div>
				<jsp:include page="${views}"></jsp:include>
			</div>
		</article>
	</div>
</body>
</html>