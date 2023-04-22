<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<div class="accordion accordion-flush mt-1" id="accordionFlushExample">
		<div class="accordion-item">
			<form action="">
				<h2 class="accordion-header">
					<button class="accordion-button collapsed fw-bold mt-2 bg-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne">DANH MỤC</button>
				</h2>
				<div id="flush-collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionFlushExample">
					<div class="accordion-body p-0">
						<ul class="list-group">
							<c:url var="urlProducts" value="/products"></c:url>
							<a class="list-group-item fw-bold" href="${urlProducts}/all">Tất cả</a>
							<c:forEach var="dm" items="${listDM}">
								<input type="radio" value="${dm.madanhmuc}" onclick="findDM()" class="btn-check" name="madanhmuc" id="${dm.madanhmuc}" autocomplete="off">
								<label class=" btn btn-outline-primary" for="${dm.madanhmuc}">${dm.tendanhmuc}</label>
								
							</c:forEach>
						</ul>
					</div>
				</div>
		</div>
		<div class="accordion-item">
			<h2 class="accordion-header">
				<button class="accordion-button collapsed fw-bold bg-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">KHOẢNG GIÁ</button>
			</h2>
			<div id="flush-collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
				<div class="accordion-body p-0">
					<ul class="list-group">
						<li class="list-group-item">
							<div class="form-check">
								<input class="form-check-input" type="radio" name="khoanggia" value="0" checked="checked" onclick="findDM()" id="kg0"> <label class="form-check-label" for="kg0">Tất cả</label>
							</div>
						</li>
						<li class="list-group-item">
							<div class="form-check">
								<input class="form-check-input" type="radio" name="khoanggia" value="1" onclick="findDM()" id="kg1"> <label class="form-check-label" for="kg1">Dưới 100.000đ</label>
							</div>
						</li>
						<li class="list-group-item">
							<div class="form-check">
								<input class="form-check-input" type="radio" name="khoanggia" value="2" onclick="findDM()" id="kg2"> <label class="form-check-label" for="kg2">100.000đ - 300.000đ</label>
							</div>
						</li>
						<li class="list-group-item">
							<div class="form-check">
								<input class="form-check-input" type="radio" name="khoanggia" value="3" onclick="findDM()" id="kg3"> <label class="form-check-label" for="kg3">300.000đ - 700.000đ</label>
							</div>
						</li>
						<li class="list-group-item">
							<div class="form-check">
								<input class="form-check-input" type="radio" name="khoanggia" value="4" onclick="findDM()" id="kg4"> <label class="form-check-label" for="kg5">Trên 1.000.000</label>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript" src="../JS/danhmuc.js">
	
</script>
