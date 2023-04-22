<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="urlAccount" value="/QLTaiKhoan"></c:url>
<div class="content col-12" style="height: 800px;">
	<article class="container mt-2 p-0">
		<div class="row" style="height: 780px; margin-bottom: 10px">
			<div class="card col-12 col-sm-10 col-md-10 col-lg-10 col-xl-9 col-xxl-8  mx-auto px-0 ">
				<div class="card-body">
					<h4 class="title text-center mt-2 mb-3 text-uppercase">Quản Lý Tài Khoản</h4>
					<form enctype="multipart/data">
						<div class="form-input mb-3">
							<input type="text" name="hoten" value="${user.email}" id="hoten" class="form-control" required placeholder="Nhập Họ và tên">
						</div>
						<div class="form-input mb-3">
							<input type="email" name="email" id="email" class="form-control" required placeholder="Nhập Email">
						</div>
						<div class="form-input mb-3">
							<input type="date" id="ngaysinh" class="form-control" name="ngaysinh" required>
						</div>
						<div class="b-3 ms-3 mb-3">
							<div class="form-check form-check-inline">
								<input class="form-check-input" required type="radio" name="gioitinh" id="inlineRadio1" value="true" checked="checked"> <label class="form-check-label" for="inlineRadio1">Nam</label>
							</div>
							<div class="form-check form-check-inline ">
								<input class="form-check-input" type="radio" name="gioitinh" id="inlineRadio2" value="false"> <label class="form-check-label" for="inlineRadio2">Nữ</label>
							</div>
						</div>
						<div class="form-input mb-3">
							<input type="text" class="form-control" id="sdt" name="sdt" placeholder="Số điện thoại" required>
						</div>
						<div class="form-input mb-3">
							<input type="password" class="form-control" id="matkhau" name="matkhau" placeholder="Mật khẩu" required>
						</div>
						<div class="form-input mb-3">
							<input type="radio" required>User <input type="radio" required>Admin
						</div>
					</form>
					<div id="message"></div>
					<div class="row">
						<div class=" mb-2 col-3 px-3 text-center">
							<button onclick="submit()" class="btn btn-dark text-uppercase rounded-4">Thêm</button>
						</div>
						<div class=" mb-2 col-3 px-3 text-center">
							<button onclick="submit()" class="btn btn-dark text-uppercase rounded-4">Sửa</button>
						</div>
						<div class=" mb-2 col-3 px-3 text-center">
							<button onclick="submit()" class="btn btn-dark text-uppercase rounded-4">Xóa</button>
						</div>
						<div class=" mb-2 col-3 px-3 text-center">
							<button onclick="submit()" class="btn btn-dark text-uppercase rounded-4">Reset</button>
						</div>
					</div>
					<div class="col-12 ">
						<div class="card">
							<h4 class="title text-center mt-3 mb-3 text-uppercase">List Tài khoản</h4>
							<table class="table overflow-y-scroll">
								<tr>
									<th>Username</th>
									<th>Password</th>
									<th>Fullname</th>
									<th>Giới Tính</th>
									<th>Ngày sinh</th>
									<th>Vai trò</th>
									<th></th>
								</tr>
								<c:forEach var="user" items="${listUser}">
									<tr>
										<td>${user.email}</td>
										<td>${user.matkhau}</td>
										<td>${user.hoten}</td>
										<td>${user.gioitinh?'Nam':'Nữ'}</td>
										<td>${user.ngaysinh}</td>
										<td>${item.email}</td>
										<td>${user.vaitro?'Admin':'User'}</td>
										<td><a class="btn btn-info" href="${urlAccount}/edit?email=${user.email}">Edit</a></td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</article>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="../JS/dangky.js"></script>
